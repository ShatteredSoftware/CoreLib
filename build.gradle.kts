plugins {
    kotlin("jvm") version "1.5.10"
}

group = "software.shattered"
version = "1.0.0"

repositories {
    mavenCentral()
    maven(url = "https://oss.sonatype.org/content/repositories/snapshots/") {
        name = "sonatype-oss-snapshots"
    }
    maven(url = "https://repo.dmulloy2.net/repository/public/") {
        name = "dmulloy"
    }
}

dependencies {
}

val coroutinesVersion: String by project
val kamlVersion: String by project
val guiceVersion: String by project
val kotlinGuiceVersion: String by project
val adventureVersion: String by project
val minimessageVersion: String by project
val moshiVersion: String by project
val moshiKotlinVersion: String by project
val hikariVersion: String by project
val packetWrapperVersion: String by project
val protocolLibVersion: String by project
val mineskinVersion: String by project
val menubuilderVersion: String by project
val exposedVersion: String by project

subprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")

    repositories {
        mavenCentral()
        maven(url = "https://oss.sonatype.org/content/repositories/snapshots/") {
            name = "sonatype-oss-snapshots"
        }
        maven(url = "https://repo.dmulloy2.net/repository/public/") {
            name = "dmulloy"
        }
    }

    dependencies {
        implementation(kotlin("stdlib"))
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
        implementation("com.charleskorn.kaml:kaml:$kamlVersion")
        testImplementation(kotlin("test-junit5"))
        testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
        testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.6.0")
        implementation("com.google.inject:guice:$guiceVersion")
        implementation("dev.misfitlabs.kotlinguice4:kotlin-guice:$kotlinGuiceVersion")
        implementation("net.kyori:adventure-api:$adventureVersion")
        implementation("net.kyori:adventure-text-minimessage:$minimessageVersion")
        implementation("com.squareup.moshi:moshi:$moshiVersion")
        implementation("com.squareup.moshi:moshi-kotlin:$moshiKotlinVersion")
        implementation("com.zaxxer:HikariCP:$hikariVersion")
    }
}
