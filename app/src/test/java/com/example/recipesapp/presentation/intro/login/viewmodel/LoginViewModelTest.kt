package com.example.recipesapp.presentation.intro.login.viewmodel

import app.cash.turbine.test
import com.example.recipesapp.domain.usecase.local.auth.LoginUseCase
import com.example.recipesapp.utils.Resource
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class LoginViewModelTest {
    private lateinit var useCase: LoginUseCase
    private lateinit var classUnderTest: LoginViewModel


    @Before
    fun setup() {
        useCase = mockk(relaxed = true)
        classUnderTest = LoginViewModel(useCase)
    }

    @Test
    fun `test login() with valid email and password`() = runTest {

        // Given
        val email = "hazem@gmail.com"
        val password = "Hazem123$"
        every { useCase.invoke(email, password) } returns Resource.Success("valid user")

        // When
        classUnderTest.login(email, password)
        delay(10L)

        // Then
        classUnderTest.loginState.test {
            Assert.assertEquals(LoginState.LoginSuccessfully("valid user"), awaitItem())
            cancelAndConsumeRemainingEvents()
        }
    }
    @Test
    fun `test login() with invalid email`() = runTest {

        // Given
        val email = "hazem@gmail"
        val password = "Hazem123$"
        every { useCase.invoke(email, password) } returns Resource.Error("please enter a valid email !")

        // When
        classUnderTest.login(email, password)
        delay(10L)

        // Then
        classUnderTest.loginState.test {
            Assert.assertEquals(LoginState.ShowError("please enter a valid email !"), awaitItem())
            cancelAndConsumeRemainingEvents()
        }
    }

    @Test
    fun `test login() with empty email`() = runTest {

        // Given
        val email = ""
        val password = "Hazem123$"
        every { useCase.invoke(email, password) } returns Resource.Error("email can't be empty !")

        // When
        classUnderTest.login(email, password)
        delay(10L)

        // Then
        classUnderTest.loginState.test {
            Assert.assertEquals(LoginState.ShowError("email can't be empty !"), awaitItem())
            cancelAndConsumeRemainingEvents()
        }
    }

    @Test
    fun `test login() with empty password`() = runTest {

        // Given
        val email = "hazem@gmail"
        val password = ""
        every { useCase.invoke(email, password) } returns Resource.Error("password can't be empty !")

        // When
        classUnderTest.login(email, password)
        delay(10L)

        // Then
        classUnderTest.loginState.test {
            Assert.assertEquals(LoginState.ShowError("password can't be empty !"), awaitItem())
            cancelAndConsumeRemainingEvents()
        }
    }

    @Test
    fun `test login() with invalid password`() = runTest {

        // Given
        val email = "hazem@gmail"
        val password = "Haz"
        every { useCase.invoke(email, password) } returns Resource.Error("please enter a valid password !")

        // When
        classUnderTest.login(email, password)
        delay(10L)

        // Then
        classUnderTest.loginState.test {
            Assert.assertEquals(LoginState.ShowError("please enter a valid password !"), awaitItem())
            cancelAndConsumeRemainingEvents()
        }
    }
}