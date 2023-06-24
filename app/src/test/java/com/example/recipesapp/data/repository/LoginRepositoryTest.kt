package com.example.recipesapp.data.repository

import com.example.recipesapp.domain.repository.LoginRepository
import com.example.recipesapp.utils.Constants
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
    fun testSaveInSharedPreference() {
        // Given
        val key = "TEST_KEY"
        val data = "TEST_DATA"
        // When
        repository.saveInSharedPreference(key, data)

        // Then
        verify { sharedPrefs.put(key, data) }
    }

    @Test
    fun testGetFromSharedPreference() {
        // Given
        val key = "TEST_KEY"
        val data = "TEST_DATA"
        every { sharedPrefs.get(key, String::class.java) } returns data
        // When
        val result = repository.getFromSharedPreference(key, String::class.java)
        // Then
        assertEquals(data, result)
    }
    @Test
    fun testLogin() {
        // Given

        // When
        repository.login()

        // Then
        verify { sharedPrefs.put(Constants.IS_LOGGED_IN_KEY, true) }
    }
}