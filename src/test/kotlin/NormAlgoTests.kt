import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertTimeoutPreemptively
import ru.emkn.kotlin.*
import java.time.Duration

class NormAlgoTests {
    @Test
    fun `simple test` () {
        assertEquals("1000", test("data/test1.txt"))
        assertEquals("10", test("data/test2.txt"))
        assertEquals("absdsdsdd334b4b4bibsbocannn", test("data/test5.txt"))
        assertEquals("askfjssdfalf", test("data/test6.txt"))
    }

    @Test
    fun `timeout test` () {
        val res = assertTimeoutPreemptively(Duration.ofSeconds(6)){
            test("data/test3.txt")
        }
        assertEquals("Алгоритм работает свыше 5 секунд", res)
    }

    @Test
    fun `incorrect input test` () {
        assertEquals("Входные данные некорректны. Прочитайте документацию в файле DOC.md",
            test("data/test4.txt")
        )
    }
}