package co.hodler.hang

import org.springframework.stereotype.Service

interface WordService {
    fun randomWord(): String
}

@Service
class SingleWordService : WordService {
    override fun randomWord(): String {
        return "tree"
    }

}