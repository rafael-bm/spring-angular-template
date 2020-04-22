plugins {
    java
    idea
    jacoco
    id("io.freefair.lombok") version "5.0.0-rc6"
    id("org.springframework.boot") version "2.2.6.RELEASE"
    id("io.spring.dependency-management") version "1.0.9.RELEASE"
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

group = "uk.co.mulecode"
version = "1.0-SNAPSHOT"

dependencyManagement {
    imports {
        mavenBom("org.springframework.boot:spring-boot-parent:2.2.6.RELEASE")
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:Hoxton.SR3")
    }
}

repositories {
    mavenLocal()
    mavenCentral()
}

sourceSets {
    main {
        resources.srcDir("../frontend_dist")
    }
}

dependencies {
    //LOMBOK
    annotationProcessor("org.projectlombok:lombok:1.18.12")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.12")
    //MVC
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web")
    //thymeleaf
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
    implementation("nz.net.ultraq.thymeleaf:thymeleaf-layout-dialect")
    implementation("org.webjars:bootstrap:4.4.1")
    //security
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.security:spring-security-oauth2-client")
    implementation("org.springframework.security:spring-security-oauth2-jose")
    implementation("org.springframework.security.oauth.boot:spring-security-oauth2-autoconfigure")

}
