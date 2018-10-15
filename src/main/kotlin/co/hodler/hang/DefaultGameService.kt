package co.hodler.hang

import org.springframework.stereotype.Service

@Service
class DefaultGameService(val gameRepository: GameRepository) : GameService {
    override fun startGame(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun playGame(id: String): GameStatus {
        val game = gameRepository.findGameById(id)
        return GameStatus(
                id = game.id,
                placeholder = Hangman(game.pickedLetters, game.originalWord).display()
        )
    }
}

interface GameRepository {
    fun findGameById(id: String): Game
}

data class Game(val id: String,
                val originalWord: String,
                val pickedLetters: List<Char> = emptyList())
