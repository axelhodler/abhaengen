package co.hodler.hang

import org.springframework.stereotype.Repository

@Repository
class InMemoryGameRepository : GameRepository {

    private var idCounter = "1"
    private var games = mutableMapOf<String, Game>()

    override fun storeGame(word: String): Game {
        val newGame = Game(idCounter, word, emptyList())
        games.put(idCounter, newGame)
        idCounter = (idCounter.toInt() + 1).toString()
        return newGame;
    }

    override fun saveGame(id: String, word: String, pickedLetters: List<Char>): Game {
        var gamePresent = games.containsKey(id)
        val game = if (gamePresent) {
            val foundGame = games.get(id)!!
            Game(id = id,
                    originalWord = foundGame.originalWord,
                    pickedLetters = pickedLetters)

        } else {
            Game(id, word, pickedLetters)
        }
        games.put(id, game)
        return game
    }

    override fun findGameById(id: String): Game {
        return games.get(id)!!
    }
}