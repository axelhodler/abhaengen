package co.hodler.hang

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.stereotype.Repository

internal class DefaultGameServiceTest {
    @Test
    fun `finds game by id`() {
        val subject = DefaultGameService(InMemoryGameRepository())
        val gamestatus = subject.playGame("2")

        assertThat(gamestatus.id).isEqualTo("2")
        assertThat(gamestatus.placeholder).isEqualTo("_r__")
    }
}

@Repository
class InMemoryGameRepository : GameRepository {
    override fun findGameById(id: String): Game {
        return Game(
                id = id,
                originalWord = "tree",
                pickedLetters = listOf('r')
        )
    }
}
