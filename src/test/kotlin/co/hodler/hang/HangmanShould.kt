package co.hodler.hang

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class HangmanShould {

    private fun testDataProvider() = Stream.of(
            HangmanTestData(
                    input = "word",
                    expectedOutput = "____"
            ),
            HangmanTestData(
                    input = "way",
                    expectedOutput = "___"
            ),
            HangmanTestData(
                    input = "bear",
                    picks = listOf('e'),
                    expectedOutput = "_e__"
            ),
            HangmanTestData(
                    input = "tree",
                    picks = listOf('r', 't'),
                    expectedOutput = "tr__"
            ),
            HangmanTestData(
                    input = "bar",
                    picks = listOf('b', 'a', 'r'),
                    expectedOutput = "bar",
                    hasWon = true
            ),
            HangmanTestData(
                    input = "bar",
                    picks = listOf('b', 'a'),
                    expectedOutput = "ba_",
                    hasWon = false
            )
    )

    @ParameterizedTest
    @MethodSource("testDataProvider")
    fun `display word, without found characters, with underscores`(testData: HangmanTestData) {
        val subject = Hangman(
                pickedLetters = testData.picks,
                wordToGuess = testData.input
        )

        assertThat(subject.display()).isEqualTo(testData.expectedOutput)
        assertThat(subject.isWon()).isEqualTo(testData.hasWon)
    }

    data class HangmanTestData(
            val input: String,
            val picks: List<Char> = emptyList(),
            val expectedOutput: String,
            val hasWon: Boolean = false
    )

}

