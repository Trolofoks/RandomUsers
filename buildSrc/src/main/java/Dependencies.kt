object Dependencies {

    object Compose {
        const val version = "1.2.0"

        const val ui = "androidx.compose.ui:ui:$version"
        const val preview = "androidx.compose.ui:ui-tooling-preview:$version"
        const val material = "androidx.compose.material:material:$version"

        const val composeJUnit = "androidx.compose.ui:ui-test-junit4:$version"
        const val composeUiTooling = "androidx.compose.ui:ui-tooling:$version"
        const val composeTestManifest = "androidx.compose.ui:ui-test-manifest:$version"
    }
    object Kotlin {
        const val version = "1.5.21"
    }

    object ProjectPlugins{
        const val androidGradlePlugin = "com.android.tools.build:gradle:7.4.1"
        const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.0"
    }
}