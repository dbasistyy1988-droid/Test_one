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
    implementation("com.codeborne:selenide:7.18.1")
    implementation("org.assertj:assertj-core:3.24.2")
// Source: https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java
 //   implementation("org.seleniumhq.selenium:selenium-java:4.43.0")

}

tasks.test {
    useJUnitPlatform()
}