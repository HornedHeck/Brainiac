plugins {
    kotlin("jvm") version "1.9.10"
    id("org.jlleitschuh.gradle.ktlint") version "11.6.1"
    id("com.google.devtools.ksp") version "1.9.10-1.0.13"
}

allprojects {
    group = "hornedheck"
    version = "1.0-SNAPSHOT"

    repositories {
        mavenCentral()
    }
}

subprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "org.jlleitschuh.gradle.ktlint")
    apply(plugin = "com.google.devtools.ksp")

    dependencies {
        //    Koin
        implementation("io.insert-koin:koin-core:3.5.0")
        implementation("io.insert-koin:koin-annotations:1.3.0")
        ksp("io.insert-koin:koin-ksp-compiler:1.3.0")
    }

    ktlint {
        filter {
            exclude("**/generated/**")
        }
    }
}
