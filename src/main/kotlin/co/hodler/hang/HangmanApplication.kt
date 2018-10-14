package co.hodler.hang

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class HangmanApplication

fun main(args: Array<String>) {
    runApplication<HangmanApplication>(*args)
}

@RestController
class GameController {
    @GetMapping("/game")
    fun `play`(): String {
        return """
            { "placeholder": "____" }
        """.trimIndent()
    }
}
