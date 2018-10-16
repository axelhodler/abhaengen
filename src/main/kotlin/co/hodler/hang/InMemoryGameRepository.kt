package co.hodler.hang

import org.springframework.stereotype.Repository

@Repository
class InMemoryGameRepository : GameRepository {
    private var games = mutableMapOf<String, Game>()

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