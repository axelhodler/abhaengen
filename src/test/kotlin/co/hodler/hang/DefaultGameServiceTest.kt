package co.hodler.hang

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

@Tag("unit")
internal class DefaultGameServiceTest {
    private val subject =
            DefaultGameService(InMemoryGameRepository(), SingleWordService())

    @Test
    fun `stores game`() {
        subject.initGame()
        val gamestatus = subject.playGame("1", 'e')

        assertThat(gamestatus.id).isEqualTo("1")
        assertThat(gamestatus.placeholder).isEqualTo("__ee")
    }

    @Test
    fun `stores games`() {
        subject.initGame()
        subject.initGame()
        subject.initGame()
        val gamestatus = subject.playGame("3", 'a')

        assertThat(gamestatus.id).isEqualTo("3")
        assertThat(gamestatus.placeholder).isEqualTo("____")
    }

    @Test
    fun `can pick multiple letters in same game`() {
        subject.initGame()
        subject.playGame("1", 'r')
        val gamestatus = subject.playGame("1", 'e')

        assertThat(gamestatus.placeholder).isEqualTo("_ree")
    }
}

