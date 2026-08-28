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
    testImplementation("org.assertj:assertj-core:3.24.2")
    implementation("io.rest-assured:rest-assured:5.5.6")
    implementation("com.codeborne:selenide:7.17.0")

}

tasks.test {
    useJUnitPlatform()
    group = "verification"
}

tasks.register( "runAllTests") {
    group = "verification"
    description = "Запускает все тесты проекта"
    dependsOn(tasks.test)
    finalizedBy("printTestRunOver")
}

tasks.register("printTestRunOver") {
    group = "verification"
    doLast {
        println()
        println("======================================")
        println("         TEST RUN IS OVER")
        println("======================================")
    }
}
tasks.test {
    useJUnitPlatform {
        // логическое ИЛИ: запустится, если есть хотя бы один из тегов
        includeTags("testTag | random-data")
    }
    group = "verification"
}







