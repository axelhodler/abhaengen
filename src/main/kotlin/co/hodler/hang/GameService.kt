package co.hodler.hang

interface GameService {
    fun startGame(): GameStatus

    fun playGame(id: String, pickedLetter: Char): GameStatus
}

data class GameStatus(val id: String,
                      val placeholder: String)