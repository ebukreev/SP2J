package com.ptsecurity.sp2j

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonObject
import java.io.*

object Json2PropertiesConverter {
    fun convert(input: String, output: String) {
        val jsonElement = FileReader(input).use {
            Json { prettyPrint = true }.parseToJsonElement(it.readText())
        }

        FileWriter(File(output)).use { fw ->
            jsonElement.jsonObject.entries.forEach {
                fw.appendLine(it.toString().replace("\"", ""))
            }
        }
    }
}