import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertTimeoutPreemptively
import ru.emkn.kotlin.*
import java.time.Duration

class NormAlgoTests {
    @Test
    fun `simple test` () {
        assertEquals("1000", main("data/test1.txt"))
        assertEquals("10", main("data/test2.txt"))

    }

    @Test
    fun `illegal argument test` () {

    }

    @Test
    fun `timeout test` () {
        val res = assertTimeoutPreemptively(Duration.ofSeconds(6)){
            main("data/test3.txt")
        }
        assertEquals("Алгоритм работает свыше 5 секунд", res)
    }

    @Test
    fun `incorrect input test` () {
        assertEquals("Входные данные некорректны. Прочитайте документацию в файле DOC.md",
            main("data/test4.txt"))
    }
}