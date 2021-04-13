package com.ptsecurity.sp2j

fun main(args : Array<String>) {
    val configuration = CommandLineParser.parse(args)

    when (configuration.kind) {
        ConverterKind.JSON_2_PROPERTIES ->
            Json2PropertiesConverter().convert(configuration.input, configuration.output)

        ConverterKind.PROPERTIES_2_JSON ->
            Properties2JsonConverter().convert(configuration.input, configuration.output)
    }
}