package com.example.recipesapp.data.repository

import com.example.recipesapp.domain.repository.LoginRepository
import com.example.recipesapp.utils.Resource
import com.example.recipesapp.utils.SharedPrefs
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class LoginRepositoryTest {

    private lateinit var repository: LoginRepository
    private val sharedPrefs: SharedPrefs = mockk(relaxed = true)

    @Before
    fun setup() {
        repository = LoginRepositoryImp(sharedPrefs)
    }

    @Test
    fun `test SaveInSharedPreference function`() {
        // Given
        val key = "TEST_KEY"
        val data = "TEST_DATA"
        // When
        repository.saveInSharedPreference(key, data)
        // Then
        verify(exactly = 1) { sharedPrefs.put(key, data) }
    }

    @Test
    fun `test GetFromSharedPreference function`() {
        // Given
        val key = "TEST_KEY"
        val expected = "TEST_DATA"
        every { sharedPrefs.get(any(), String::class.java) } returns expected
        // When
        val actual = repository.getFromSharedPreference(key, String::class.java)
        // Then
        assertEquals(expected, actual)
    }

    @Test
    fun `test Login function`() {
        // Given
        val expected = Resource.Success("Logged In Successfully")
        // When
        val actual = repository.login()
        // Then
        assertEquals(expected, actual)
    }
}