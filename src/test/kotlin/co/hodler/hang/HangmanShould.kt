package co.hodler.hang

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class HangmanShould {
    @Test
    fun `display initial word, without yet found characters, with underscores`() {
        val first = Hangman(wordToGuess = "word")
        val second = Hangman(wordToGuess = "way")

        assertThat(first.display()).isEqualTo("____")
        assertThat(second.display()).isEqualTo("___")
    }
}

class Hangman(val wordToGuess: String) {
    fun display(): String {
        return wordToGuess.map { "_" }.joinToString(separator = "")
    }
}
