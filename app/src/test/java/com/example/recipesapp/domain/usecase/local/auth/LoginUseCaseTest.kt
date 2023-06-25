package com.example.recipesapp.domain.usecase.local.auth

import com.example.recipesapp.domain.repository.LoginRepository
import com.example.recipesapp.utils.Resource
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class LoginUseCaseTest {
    private lateinit var useCase: LoginUseCase

    private val loginRepository: LoginRepository = mockk(relaxed = true)


    @Before
    fun setup() {
        useCase = LoginUseCase(loginRepository)
    }

    @Test
    fun `test invoke() function with valid email and password`() {
        // Given
        val email = "hazem@gmail.com"
        val password = "Hazem123$"
        val result = Resource.Success("valid user")
        every { loginRepository.login() } returns Resource.Success("valid user")

        // When
        val loginResult = useCase(email, password)

        // Then
        assertEquals(result, loginResult)
        verify { loginRepository.login() }
    }

    @Test
    fun `test invoke() function with an invalid email `() {
        // Given
        val email = "hazem gmail.com"
        val password = "Hazem123$"
        val result = Resource.Error("please enter a valid email !")

        // When
        val loginResult = useCase(email, password)

        // Then
        assertEquals(result, loginResult)
        verify (exactly = 0) { loginRepository.login() }
    }

    @Test
    fun `test invoke() function with an invalid password `() {
        // Given
        val email = "hazem@gmail.com"
        val password = "hazem"
        val result = Resource.Error("please enter a valid password !")

        // When
        val loginResult = useCase(email, password)

        // Then
        assertEquals(result, loginResult)
        verify (exactly = 0) { loginRepository.login() }
    }

    @Test
    fun `test invoke() function with an empty email `() {
        // Given
        val email = ""
        val password = "Hazem123$"
        val result = Resource.Error("email can't be empty !")

        // When
        val loginResult = useCase(email, password)

        // Then
        assertEquals(result, loginResult)
        verify (exactly = 0) { loginRepository.login() }
    }

    @Test
    fun `test invoke() function with an empty password `() {
        // Given
        val email = "hazem@gmail.com"
        val password = ""
        val expected = Resource.Error("password can't be empty !")

        // When
        val actual = useCase(email, password)

        // Then
        assertEquals(expected, actual)
        verify (exactly = 0) { loginRepository.login() }
    }
}