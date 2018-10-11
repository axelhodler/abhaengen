class Hangman(val pickedLetters: List<Char> = emptyList(),
              val wordToGuess: String) {
    private val placeholder = '_'

    fun display(): String {
        return wordToGuess
                .map { placeholderOrFoundCharacter(character = it) }
                .joinToString(separator = "")
    }

    private fun placeholderOrFoundCharacter(character: Char): Char = if (pickedLetters.contains(character)) character else placeholder

    fun isWon(): Boolean {
        return !display().contains(placeholder)
    }
}