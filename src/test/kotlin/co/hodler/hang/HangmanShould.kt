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
            )
    )

    @ParameterizedTest
    @MethodSource("testDataProvider")
    fun `display word, without found characters, with underscores`(testData: HangmanTestData) {
        val subject = Hangman(wordToGuess = testData.input)

        testData.picks.forEach { subject.pick(it) }

        assertThat(subject.display()).isEqualTo(testData.expectedOutput)
    }

    data class HangmanTestData(
            val input: String,
            val picks: List<Char> = emptyList(),
            val expectedOutput: String
    )

}

class Hangman(val wordToGuess: String) {
    fun display(): String {
        return wordToGuess
                .map { if (pickedChars.contains(it)) it else "_" }
                .joinToString(separator = "")
    }

    private var pickedChars = mutableListOf<Char>()

    fun pick(letter: Char) {
        this.pickedChars.add(letter);
    }
}
