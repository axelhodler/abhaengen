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

    @Test
    fun `stores game`() {
        val subject = DefaultGameService(InMemoryGameRepository())
        val gamestatus = subject.startGame()

        assertThat(gamestatus.id).isEqualTo("1")
        assertThat(gamestatus.placeholder).isEqualTo("____")
    }
}

@Repository
class InMemoryGameRepository : GameRepository {
    override fun saveGame(id: String, pickedLetters: List<Char>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findGameById(id: String): Game {
        return Game(
                id = id,
                originalWord = "tree",
                pickedLetters = listOf('r')
        )
    }
}
