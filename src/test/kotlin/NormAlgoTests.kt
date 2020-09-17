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
    @Test
    fun `module test goThroughRules` () {
        assertEquals(Pair("aaæææäå", true), goThroughRules("aaæäå", listOf<String>("æ ->. æææ")))
        assertEquals(Pair("aaæææäå", false), goThroughRules("aaæäå", listOf<String>("æ -> æææ")))
        assertEquals(Pair("abababababuuaa", true),
                goThroughRules("abababababaaaa", listOf<String>("d -> ss", "aa ->. uu")))
        assertEquals(Pair("abababababuuaa", false),
                goThroughRules("abababababaaaa", listOf<String>("d -> ss", "aa -> uu")))
        assertEquals(Pair("19992743645", true),
                goThroughRules("1525326372743645", listOf<String>("1222 -> 23",
                                                                           "543 -> 74574",
                                                                           "24324 -> 2423",
                                                                           "52532637 ->. 999")))
    }
    @Test
    fun `module test checkInput` () {
        assertEquals(true, checkInput("aaæäå", listOf<String>("a ->. aaaa")))
        assertEquals(false, checkInput("aaæäå", listOf<String>("a ->. a a")))
        assertEquals(false, checkInput("a", listOf<String>("a  aaaa")))
        assertEquals(false, checkInput("a", listOf<String>(" a aaaa")))
        assertEquals(false, checkInput("a", listOf<String>("a aaaa ")))
        assertEquals(false, checkInput("a", listOf<String>("a aaaa")))
        assertEquals(false, checkInput("aaæäå", listOf<String>("a ->. aaaa 999")))
        assertEquals(false, checkInput("77", listOf<String>("a ->. ##")))
        assertEquals(true, checkInput("aaæäå", listOf<String>("a ->. 1111")))
        assertEquals(false, checkInput("uu8", listOf<String>("a ->. &ads")))
    }
}