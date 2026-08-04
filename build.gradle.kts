import jdk.internal.vm.vector.VectorSupport.test

plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test { // запускает все тесты в проекте
    useJUnitPlatform()
    group = "hometest"
}

tasks.register<Test>("progon1"){//Запускает 3 теста с тегом "Anather"
    group = "hometest"
    useJUnitPlatform {
        includeTags("Anather")
    }
}







