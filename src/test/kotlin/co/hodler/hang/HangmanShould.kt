package co.hodler.hang

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class HangmanShould {

    private fun testDataProvider() = Stream.of(
            HangmanTestData(input = "word", expectedOutput = "____"),
            HangmanTestData(input = "way", expectedOutput = "___")
    )

    @ParameterizedTest
    @MethodSource("testDataProvider")
    fun `display word, without found characters, with underscores`(testData: HangmanTestData) {
        val subject = Hangman(wordToGuess = testData.input)

        assertThat(subject.display()).isEqualTo(testData.expectedOutput)
    }

    data class HangmanTestData(
            val input: String,
            val expectedOutput: String
    )

}

class Hangman(val wordToGuess: String) {
    fun display(): String {
        return wordToGuess.map { "_" }.joinToString(separator = "")
    }
}
