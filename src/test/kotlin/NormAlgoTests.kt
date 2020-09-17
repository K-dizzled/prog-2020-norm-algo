import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import ru.emkn.kotlin.*

class NormAlgoTests {
    @Test
    fun `simple test` () {
        assertEquals("1000", main("input.txt"))
    }
}