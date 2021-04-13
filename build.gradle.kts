plugins {
    java
    kotlin("jvm") version "1.4.32"
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