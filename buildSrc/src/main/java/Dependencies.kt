object Dependencies {

    object Core{
        const val core = "androidx.core:core-ktx:1.9.0"
        const val composeActivity = "androidx.activity:activity-compose:1.6.1"
    }


    object Test {
        const val junit = "junit:junit:4.13.2"
        const val junitTest = "androidx.test.ext:junit:1.1.5"
        const val testCore = "androidx.test.espresso:espresso-core:3.5.1"
    }

    object Lifecycle{
        const val version = "2.5.1"

        const val runtime = "androidx.lifecycle:lifecycle-runtime-ktx:$version"
    }
    
    object Compose {
        const val version = "1.2.0"

        const val ui = "androidx.compose.ui:ui:$version"
        const val preview = "androidx.compose.ui:ui-tooling-preview:$version"
        const val material = "androidx.compose.material:material:$version"
        const val JUnitTest = "androidx.compose.ui:ui-test-junit4:$version"
        const val UiTooling = "androidx.compose.ui:ui-tooling:$version"
        const val TestManifest = "androidx.compose.ui:ui-test-manifest:$version"
    }

    object Kotlin {
        const val version = "1.5.21"
    }

    object ProjectPlugins{
        const val androidGradlePlugin = "com.android.tools.build:gradle:7.4.1"
        const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.0"
    }
}