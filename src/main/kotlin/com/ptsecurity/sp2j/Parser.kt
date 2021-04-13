package com.ptsecurity.sp2j

object Parser {
    fun parse(args: Array<String>) {
        TODO("Not yet implemented")
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