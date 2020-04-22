plugins {
    java
    idea
    application
    id("io.freefair.lombok") version "5.0.0-rc6"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    //LOMBOK
    annotationProcessor("org.projectlombok:lombok:1.18.12")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.12")
    //mockserver
    implementation("org.mock-server:mockserver-netty:5.6.1")
    implementation("org.reflections:reflections:0.9.12")
    //Logging
    implementation("org.slf4j:slf4j-api:1.7.25")
    implementation("org.slf4j:slf4j-simple:1.7.25")
    //extras
    implementation("com.fasterxml.jackson.core:jackson-databind:2.10.3")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.10.3")
    implementation("com.fasterxml.jackson.module:jackson-modules-java8:2.10.3")
    implementation("com.github.javafaker:javafaker:0.14")
    implementation("com.jayway.jsonpath:json-path-assert:2.4.0")
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

application {
    mainClassName = "com.mulecode.sample.Application"
}
