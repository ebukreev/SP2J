package com.ptsecurity.sp2j

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.*
import java.util.*

object Properties2JsonConverter {
    fun convert(input: String, output: String) {
        val properties = Properties()
        FileReader(File(input)).use { properties.load(it) }

        val propertiesMap = properties
                .mapKeys { it.key.toString() }
                .mapValues { it.value.toString() }

        val jsonString = Json { prettyPrint = true }.encodeToString(propertiesMap)
        FileWriter(output).use { it.write(jsonString) }
    }
}