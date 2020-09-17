import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertTimeoutPreemptively
import ru.emkn.kotlin.*
import java.time.Duration

class NormAlgoTests {
    @Test
    fun `simple test` () {
        assertEquals("1000", load("data/test1.txt"))
        assertEquals("10", load("data/test2.txt"))
        assertEquals("absdsdsdd334b4b4bibsbocannn", load("data/test5.txt"))
        assertEquals("askfjssdfalf", load("data/test6.txt"))
    }

    @Test
    fun `timeout test` () {
        val res = assertTimeoutPreemptively(Duration.ofSeconds(6)){
            load("data/test3.txt")
        }
        assertEquals("Алгоритм работает свыше 5 секунд", res)
    }

    @Test
    fun `incorrect input test` () {
        assertEquals("Входные данные некорректны. Прочитайте документацию в файле DOC.md",
            load("data/test4.txt"))
    }
}