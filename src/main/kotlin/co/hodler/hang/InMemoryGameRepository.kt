package co.hodler.hang

import org.springframework.stereotype.Repository

@Repository
class InMemoryGameRepository : GameRepository {
    private var games = mutableListOf<Game>()

    override fun saveGame(id: String, word: String, pickedLetters: List<Char>): Game {
        val game = Game(id, word, pickedLetters)
        games.add(game)
        return game
    }

    override fun findGameById(id: String): Game {
        return games.find { it.id == id }!!
    }
}