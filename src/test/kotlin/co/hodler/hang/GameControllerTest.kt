package co.hodler.hang

import com.jayway.jsonpath.JsonPath
import com.toomuchcoding.jsonassert.JsonAssertion.assertThatJson
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

@Tag("unit")
class GameControllerTest {

    private val gameServiceStub: GameServiceStub = GameServiceStub()
    private var subject: GameController = GameController(gameServiceStub)

    @Test
    fun `can start the game`() {
        val response = subject.play()

        val parsedJson = JsonPath.parse(response)
        assertThatJson(parsedJson).field("['placeholder']").isEqualTo("____");
        assertThatJson(parsedJson).field("['game_id']").isEqualTo("1");
    }

    @Test
    fun `can play the game`() {
        val response = subject.`pick letter`()

        val parsedJson = JsonPath.parse(response)
        assertThatJson(parsedJson).field("['placeholder']").isEqualTo("_r__");
    }
}

class GameServiceStub : GameService {
    override fun playGame(id: String): String {
        return """
            {
                "placeholder": "_r__"
            }
        """.trimIndent()
    }

    override fun startGame(): String {
        return """
            {
                "game_id": "1",
                "placeholder": "____"
            }
        """.trimIndent()
    }

}
