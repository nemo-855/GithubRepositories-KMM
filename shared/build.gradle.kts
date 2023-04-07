import java.io.File
import java.io.FileInputStream
import java.util.*

plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("kotlinx-serialization")
    id("maven-publish")
}

val prop = Properties().apply {
    load(FileInputStream(File(rootProject.rootDir, "github.properties")))
}

val libVersion = "0.0.6"

publishing {
    publications {
        create<MavenPublication>("gpr") {
            run {
                groupId = "com.nemo.githubrepositories_kmm"
                artifactId = artifactId
                version = libVersion
                artifact("$buildDir/outputs/aar/$artifactId-release.aar")
            }
        }
    }

    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/nemo-855/GithubRepositories-KMM")
            version = libVersion
            credentials {
                username = prop.getProperty("github_user").orEmpty()
                password = prop.getProperty("github_key").orEmpty()
            }
        }
    }
}

kotlin {
    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(Libraries.kotlinDateTime)
                implementation(Libraries.Koin.core)
                implementation(Libraries.Koin.test)
                implementation(Libraries.Ktor.core)
                implementation(Libraries.kotlinxCoroutines)
                implementation(Libraries.kotlinxSerialization)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(Libraries.Ktor.okhttp)
                implementation(Libraries.okhttpLoggingInterceptor)
            }
        }
        val androidUnitTest by getting
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
            dependencies {
                implementation(Libraries.Ktor.darwin)
            }
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }
    }
}

android {
    namespace = "com.nemo.githubrepositories_kmm"
    compileSdk = 33
    defaultConfig {
        minSdk = 26
        targetSdk = 33
    }
}

//FIXME: 別ファイルに切り出したい
object Versions {
    const val koin = "3.2.0"
    const val ktor = "2.2.4"
}

object Libraries {
    const val kotlinDateTime = "org.jetbrains.kotlinx:kotlinx-datetime:0.4.0"

    const val kotlinxCoroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4"

    const val kotlinxSerialization = "org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.0"

    const val okhttpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:4.10.0"

    object Koin {
        const val core = "io.insert-koin:koin-core:${Versions.koin}"
        const val test = "io.insert-koin:koin-test:${Versions.koin}"
        const val android = "io.insert-koin:koin-android:${Versions.koin}"
    }

    object Ktor {
        const val core = "io.ktor:ktor-client-core:${Versions.ktor}"
        const val okhttp = "io.ktor:ktor-client-okhttp:${Versions.ktor}"
        const val darwin = "io.ktor:ktor-client-darwin:${Versions.ktor}"
    }
}
