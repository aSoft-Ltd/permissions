plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("tz.co.asoft.library")
    id("io.codearte.nexus-staging")
    signing
}

kotlin {
    multiplatformLib()
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(project(":permissions-core"))
                api(asoft("persist-core", vers.asoft.persist))
            }
        }

        val commonTest by getting {
            dependencies {
                implementation(asoft("test-core", vers.asoft.test))
                implementation(asoft("expect-core", vers.asoft.expect))
            }
        }
    }
}

aSoftOSSLibrary(
    version = vers.asoft.permissions,
    description = "A Kotlin Multiplatform Library with entities required for access to different resources"
)