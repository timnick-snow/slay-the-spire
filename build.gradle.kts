plugins {
    java
    id("org.springframework.boot") version "3.2.0"
    id("io.spring.dependency-management") version "1.1.4"
    id("io.freefair.lombok") version "8.4"
    id("org.graalvm.buildtools.native") version "0.9.16"
}

group = "io.github.snow"
version = "0.0.1-SNAPSHOT"

graalvmNative {
    metadataRepository {
        enabled = true
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_21
}

repositories {
    maven { url = uri("https://maven.aliyun.com/repository/central") }
    mavenCentral()
    maven { url = uri("https://repo.spring.io/milestone") }
}

extra["springShellVersion"] = "3.2.0-RC1"

dependencies {
    implementation("org.springframework.shell:spring-shell-starter")
    implementation("org.springframework.shell:spring-shell-starter-jna")
    implementation("org.springframework.boot:spring-boot-starter-json")
    implementation("ch.qos.logback:logback-classic:1.4.8")

    testImplementation("com.alibaba:easyexcel:3.3.3")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.shell:spring-shell-dependencies:${property("springShellVersion")}")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}