package co.hodler.hang

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

internal class InMemoryGameRepositoryTest {
    @Test
    fun `game not found throws`() {
        val subject = InMemoryGameRepository()
        assertThatThrownBy {
            subject.findGameById("2")
        }.isInstanceOf(GameNotFoundException::class.java)
    }
}


