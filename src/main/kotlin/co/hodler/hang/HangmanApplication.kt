package co.hodler.hang

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.PatchMapping
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
    fun `pick letter`(): String {
        return """
            {
                "placeholder": "_r__"
            }
        """.trimIndent()
        return gameService.playGame("1")
    }
}
