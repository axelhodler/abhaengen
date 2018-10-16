package co.hodler.hang

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import org.springframework.stereotype.Repository

@Tag("unit")
internal class DefaultGameServiceTest {
    private val subject =
            DefaultGameService(InMemoryGameRepository(), SingleWordService())

    @Test
    fun `stores game`() {
        subject.startGame()
        val gamestatus = subject.playGame("1", 'e')

        assertThat(gamestatus.id).isEqualTo("1")
        assertThat(gamestatus.placeholder).isEqualTo("__ee")
    }

    @Test
    fun `stores games`() {
        subject.startGame()
        subject.startGame()
        subject.startGame()
        val gamestatus = subject.playGame("3", 'a')

        assertThat(gamestatus.id).isEqualTo("3")
        assertThat(gamestatus.placeholder).isEqualTo("____")
    }
}

@Repository
class InMemoryGameRepository : GameRepository {
    private var games = mutableListOf<Game>()

    override fun saveGame(id: String, pickedLetters: List<Char>): Game {
        val game = Game(id, "tree", pickedLetters)
        games.add(game)
        return game
    }

    override fun findGameById(id: String): Game {
        return games.find { it.id == id }!!
    }
}
