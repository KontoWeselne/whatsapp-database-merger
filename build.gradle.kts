import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

tasks.withType<KotlinCompile>().configureEach {
    compilerOptions {
        jvmTarget.set(JvmTarget.JVM_17)
    }
}

plugins {
    kotlin("jvm") version "2.0.20"
    application
}

group = "dev.natario"
version = "0.2.0"

repositories {
    mavenCentral()
    google()
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-cli:0.3.6")
    implementation("com.squareup.sqldelight:sqlite-driver:1.5.5")
}


application {
    mainClass.set("dev.natario.MainKt")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

kotlin {
    jvmToolchain {
        (this as JavaToolchainSpec).languageVersion.set(JavaLanguageVersion.of(17))
    }
}