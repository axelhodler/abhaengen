package co.hodler.hang

interface GameService {
    fun initGame(): GameStatus

    fun playGame(id: String, pickedLetter: Char): GameStatus
}

data class GameStatus(val id: String,
                      val placeholder: String)