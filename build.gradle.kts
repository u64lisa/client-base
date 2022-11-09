plugins {
    id("java")
    id("java-library")
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

version = "1.0-SNAPSHOT"
group = "io.nicky"

repositories {
    mavenCentral()
}

dependencies {
    // files
    implementation(group = "com.google.code.gson", name = "gson", version = "2.9.1")

    // networking
    implementation(group = "io.netty", name = "netty-all", version = "4.1.69.Final")

    // collections
    implementation(group = "it.unimi.dsi", name = "fastutil", version = "8.5.9")

    // asm
    implementation(group = "org.ow2.asm", name = "asm", version = "9.4")
    implementation(group = "org.ow2.asm", name = "asm-commons", version = "9.4")
    implementation(group = "org.ow2.asm", name = "asm-tree", version = "9.4")

    // tests
    testImplementation(group = "org.junit.jupiter", name = "junit-jupiter-api", version = "5.8.1")
    testImplementation(group = "org.junit.jupiter", name = "junit-jupiter-engine", version = "5.8.1")
}

tasks {
    java {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
        withSourcesJar()
        build {
            dependsOn.add(shadowJar)
        }
    }
    test {
        useJUnitPlatform()
    }
}
