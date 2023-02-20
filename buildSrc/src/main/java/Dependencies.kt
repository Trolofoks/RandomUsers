object Dependencies {

    object Plugins {
        const val application = "com.android.application"
        const val kotlinAndroid = "org.jetbrains.kotlin.android"
        const val kotlinKapt = "org.jetbrains.kotlin.kapt"
        const val hilt = "com.google.dagger.hilt.android"
    }

    object ClassPath {
        const val versionGradle = "7.4.1"
        const val versionKotlin = "1.8.10"
        const val versionDagger = "2.44"

        const val androidGradlePlugin = "com.android.tools.build:gradle:$versionGradle"
        const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$versionKotlin"
        const val daggerGradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:$versionDagger"
    }

    object Core{
        object Version {
            const val coreKtx = "1.9.0"
            const val appCompat = "1.4.1"
            const val activityCompose = "1.4.0"
            const val androidMaterial = "1.6.0"
            const val composeCompiler = "1.4.2"
        }
        const val coreKts = "androidx.core:core-ktx:${Version.coreKtx}"
        const val appCompat = "androidx.appcompat:appcompat:${Version.appCompat}"
        const val activityCompose = "androidx.activity:activity-compose:${Version.activityCompose}"
        const val androidMaterial = "com.google.android.material:material:${Version.androidMaterial}"
    }

    object Lifecycle{
        const val version = "2.5.1"
        const val versionEx = "2.2.0"

        const val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
        const val runtimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:$version"
        const val extensions = "androidx.lifecycle:lifecycle-extensions:$versionEx"
    }

    object Compose {
        const val version = "1.4.0-beta01"
        const val versionCoil = "1.3.1"

//        const val ui = "androidx.compose.ui:ui:$version"
        const val uiTooling = "androidx.compose.ui:ui-tooling:$version"
        const val uiToolingPreview = "androidx.compose.ui:ui-tooling-preview:$version"
        const val material = "androidx.compose.material:material:$version"
        const val materialIconsExtended = "androidx.compose.material:material-icons-extended:$version"
        // я хз что это лучше удалить если без него работать тоже будет
        const val coilCompose = "io.coil-kt:coil-compose:$versionCoil"

    }

    object Navigation {
        const val version = "2.5.1"

        const val navigationCompose = "androidx.navigation:navigation-compose:$version"
        const val lifecycleViewModelCompose = "androidx.lifecycle:lifecycle-viewmodel-compose:$version"
    }

    object Retrofit {
        const val version = "2.9.0"

        const val retrofit = "com.squareup.retrofit2:retrofit:$version"
        const val retrofitConverterGson = "com.squareup.retrofit2:converter-gson:$version"
    }

    object Hilt {
        const val version = "2.44"
        const val versionCompose = "1.0.0"

        const val android = "com.google.dagger:hilt-android:$version"
        const val compiler = "com.google.dagger:hilt-compiler:$version"
        const val compose = "androidx.hilt:hilt-navigation-compose:$versionCompose"
    }

    //тесты, вообще было бы круто их подучить а то я же вообще не знаю
    object Test {
        object Version {
            const val junit = "1.1.1"
            const val androidxJunit = "1.1.3"
            const val roboeletric = "4.6.1"
            const val mockk = "1.12.4"
            const val okHttp3MockWebServer = "4.9.2"
            const val espressoCore = "3.4.0"
        }
        const val junit = "junit:junit:${Version.junit}"
        const val androidJunit = "androidx.test.ext:junit:${Version.junit}"
        const val roboeletric = "org.robolectric:robolectric:${Version.roboeletric}"
        const val mockk = "io.mockk:mockk:${Version.mockk}"
        const val okHttp3MockWebServer = "com.squareup.okhttp3:mockwebserver:${Version.okHttp3MockWebServer}"
        const val espressoCore = "androidx.test.espresso:espresso-core:${Version.espressoCore}"
        const val composeJunit = "androidx.compose.ui:ui-test-junit4:${Compose.version}"
    }
}