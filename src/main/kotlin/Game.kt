import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    var won = false;
    val word = "forest";
    var hangman = Hangman(wordToGuess = word)
    hangman.display()
    while (!won) {
        println("Pick letter")
        val letter = scanner.next().first()
        hangman = Hangman(
                pickedLetters = hangman.letters() + listOf(letter),
                wordToGuess = word
        )
        println(hangman.display())
        if (hangman.isWon()) {
            won = true;
        }
    }
}
