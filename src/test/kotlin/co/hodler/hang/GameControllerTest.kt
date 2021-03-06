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
        val pick = PickedCharacter('r')

        val response = subject.pickLetter(pick, "2")

        val parsedJson = JsonPath.parse(response)
        assertThatJson(parsedJson).field("['placeholder']").isEqualTo("_r__");
        assertThatJson(parsedJson).field("['game_id']").isEqualTo("2");
    }
}

class GameServiceStub : GameService {
    override fun playGame(id: String, pickedLetter: Char): GameStatus {
        return GameStatus(
                id = id,
                placeholder = "_r__"
        )
    }

    override fun initGame(): GameStatus {
        return GameStatus(
                id = "1",
                placeholder = "____"
        )
    }
}
