plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.assertj:assertj-core:3.24.2")
    implementation("io.rest-assured:rest-assured:5.5.6")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    // Source: https://mvnrepository.com/artifact/tools.jackson.core/jackson-databind
    implementation("tools.jackson.core:jackson-databind:3.2.1")

}

tasks.test {
    useJUnitPlatform()
}
tasks.register<Test>( "runHomeWork4Test") {
    group = "verification"
    description = "Запускает все тесты проекта"
    useJUnitPlatform()
    filter{
        includeTestsMatching("*HomeWork4")
    }
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