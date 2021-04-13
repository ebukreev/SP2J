package com.ptsecurity.sp2j

class ParserException : RuntimeException("can not parse command line arguments")

object CommandLineParser {
    fun parse(args: Array<String>): CommandLineConfiguration {

        var input: String? = null
        var output: String? = null

        var isInput = false
        var isOutput = false

        for (arg in args) {
            when (arg) {
                "-i" -> {
                    if (isInput || isOutput) throw ParserException()
                    isInput = true
                }
                "-o" -> {
                    if (isInput || isOutput) throw ParserException()
                    isOutput = true
                }
                else -> {
                    when {
                        isInput -> {
                            input = arg
                            isInput = false
                        }
                        isOutput -> {
                            output = arg
                            isOutput = false
                        }
                    }
                }
            }
        }

        if (input == null) throw ParserException()

        var kind = when {
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
    val output: String?,
    val kind: ConverterKind
)

enum class ConverterKind {
    PROPERTIES_2_JSON,

    JSON_2_PROPERTIES
}