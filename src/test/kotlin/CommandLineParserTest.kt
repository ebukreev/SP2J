import com.ptsecurity.sp2j.CommandLineConfiguration
import com.ptsecurity.sp2j.CommandLineParser
import com.ptsecurity.sp2j.ConverterKind
import org.junit.Test
import kotlin.test.assertEquals

class CommandLineParserTest {
    @Test
    fun `PARSE PROPERTIES_2_JSON`() {
        val input = "./test.properties"
        val output = "./test.json"
        val args = arrayOf("-i", input, "-o", output)
        val configuration = CommandLineParser.parse(args)

        assertEquals(configuration, CommandLineConfiguration(input, output, ConverterKind.PROPERTIES_2_JSON))
    }

    @Test
    fun `PARSE JSON_2_PROPERTIES`() {
        val input = "./test.json"
        val output = "./test.properties"
        val args = arrayOf("-i", input, "-o", output)
        val configuration = CommandLineParser.parse(args)

        assertEquals(configuration, CommandLineConfiguration(input, output, ConverterKind.JSON_2_PROPERTIES))
    }

    @Test
    fun `EMPTY OUTPUT`() {
        val input = "./test.json"
        val args = arrayOf("-i", input)
        val configuration = CommandLineParser.parse(args)

        assertEquals(configuration, CommandLineConfiguration(input, "./test.properties", ConverterKind.JSON_2_PROPERTIES))
    }
}