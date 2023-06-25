import com.example.recipesapp.domain.repository.LoginRepository
import com.example.recipesapp.domain.usecase.local.shared_preference.GetFromSharedPreferenceUseCase
import io.mockk.every
import io.mockk.mockk
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class GetFromSharedPreferenceUseCaseTest {
    private lateinit var useCase: GetFromSharedPreferenceUseCase
    private lateinit var repository: LoginRepository

    @Before
    fun setup() {
        repository = mockk(relaxed = true)
        useCase = GetFromSharedPreferenceUseCase(repository)
    }

    @Test
    fun `test invoke() function to get value from shared preference by the key`() {
        // Given
        val key = "test_key"
        val expected = "test_value"
        every { repository.getFromSharedPreference(key, String::class.java) } returns expected

        // When
        val actual = useCase(key, String::class.java)

        // Then
        assertEquals(expected, actual)
    
    }
}