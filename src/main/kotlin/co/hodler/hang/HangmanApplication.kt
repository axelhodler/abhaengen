package co.hodler.hang

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.*


@SpringBootApplication
class HangmanApplication {
    @Autowired
    fun configureObjectMapper(mapper: ObjectMapper) {
        mapper.registerModule(KotlinModule())
    }
}

fun main(args: Array<String>) {
    runApplication<HangmanApplication>(*args)
}


@RestController
class GameController(val gameService: GameService) {
    @PostMapping("/game")
    fun `play`(): String {
        val game = gameService.startGame()
        return toJson(game)
    }

    @PatchMapping(value = "/game/{gameId}")
    fun pickLetter(@RequestBody pickedCharacter: PickedCharacter, @PathVariable gameId: String): String {
        val game = gameService.playGame(gameId, pickedCharacter.pick)
        return toJson(game)
    }

    private fun toJson(game: GameStatus): String {
        return """
                {
                    "game_id": "${game.id}",
                    "placeholder": "${game.placeholder}"
                }
            """.trimIndent()
    }
}

data class PickedCharacter(var pick: Char)
