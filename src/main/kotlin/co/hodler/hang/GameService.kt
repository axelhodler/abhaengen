package co.hodler.hang

interface GameService {
    fun startGame(): String

    fun playGame(id: String): String
}