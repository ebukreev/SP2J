package com.ptsecurity.sp2j

class ParserException : RuntimeException("can not parse command line arguments")

object CommandLineParser {
    fun parse(args: Array<String>): CommandLineConfiguration {

        var input: String? = null
        var output: String? = null

        var i = 0
        while (i < args.size) {
            when (args[i]) {
                "-i" -> input = args[++i]

                "-o" -> output = args[++i]

                else -> throw  ParserException()
            }
            i++
        }

        if (input == null) throw ParserException()

        val kind = when {
            input.endsWith(".properties") -> ConverterKind.PROPERTIES_2_JSON

            input.endsWith(".json") -> ConverterKind.JSON_2_PROPERTIES

            else -> throw RuntimeException("input should be .properties or json")
        }

        if (output == null) {
            output = input

            output = when (kind) {
                ConverterKind.PROPERTIES_2_JSON -> output.removeSuffix(".properties") + ".json"

                ConverterKind.JSON_2_PROPERTIES -> output.removeSuffix(".json") + ".properties"
            }
        }

        return CommandLineConfiguration(input, output, kind)
    }
}

data class CommandLineConfiguration(
    val input: String,
    val output: String,
    val kind: ConverterKind
)

enum class ConverterKind {
    PROPERTIES_2_JSON,

    JSON_2_PROPERTIES
}