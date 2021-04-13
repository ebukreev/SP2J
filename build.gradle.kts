import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

buildscript {
    dependencies {
        classpath("com.github.jengelman.gradle.plugins:shadow:6.1.0")
    }
}

plugins {
    java
    kotlin("jvm") version "1.4.32"
    id("com.github.johnrengelman.shadow") version "6.1.0"
}

group = "com.ptsecurity"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation("junit:junit:4.12")
    testImplementation("org.jetbrains.kotlin:kotlin-test:1.4.32")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.1.0")
}

val shadowJar: ShadowJar by tasks

shadowJar.apply {
    archiveBaseName.set("sp2j")
    archiveClassifier.set("")
    archiveVersion.set("")

    manifest.attributes.apply {
        put("Main-Class", "com.ptsecurity.sp2j.MainKt")
    }
}