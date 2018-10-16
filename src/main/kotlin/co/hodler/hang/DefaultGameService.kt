package co.hodler.hang

import org.springframework.stereotype.Service

@Service
class DefaultGameService(val gameRepository: GameRepository) : GameService {
    private var gameIdCounter = 1
    override fun startGame(): GameStatus {
        val game = gameRepository.saveGame(
                id = gameIdCounter.toString(),
                pickedLetters = emptyList()
        )
        gameIdCounter++
        return GameStatus(
                id = game.id,
                placeholder = Hangman(wordToGuess = "tree").display()
        )
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

    fun saveGame(id: String, pickedLetters: List<Char>): Game
}

data class Game(val id: String,
                val originalWord: String,
                val pickedLetters: List<Char> = emptyList())
