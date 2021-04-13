package com.ptsecurity.sp2j

import java.nio.file.Path

interface Converter {
    fun convert(input: Path, output: Path)
}