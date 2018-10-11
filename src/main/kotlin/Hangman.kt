class Hangman(val wordToGuess: String) {
    val placeholder = '_'

    fun display(): String {
        return wordToGuess
                .map { placeholderOrFoundCharacter(character = it) }
                .joinToString(separator = "")
    }

    private fun placeholderOrFoundCharacter(character: Char): Char = if (pickedChars.contains(character)) character else placeholder

    private var pickedChars = mutableListOf<Char>()

    fun pick(letter: Char) {
        this.pickedChars.add(letter)
    }

    fun isWon(): Boolean {
        return !display().contains(placeholder)
    }
}