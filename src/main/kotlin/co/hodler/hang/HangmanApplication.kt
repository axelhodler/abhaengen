package co.hodler.hang

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class HangmanApplication

fun main(args: Array<String>) {
    runApplication<HangmanApplication>(*args)
}

@RestController
class GameController(val gameService: GameService) {
    @PostMapping("/game")
    fun `play`(): String {
        return gameService.startGame()
    }

    @PatchMapping("/game/{gameId}")
    fun `pick letter`(@PathVariable gameId: String): String {
        val game = gameService.playGame(gameId)
        return """
            {
                "game_id": "${game.id}",
                "placeholder": "${game.placeholder}"
            }
        """.trimIndent()
    }
}

