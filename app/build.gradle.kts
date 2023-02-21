plugins {
    id (Dependencies.Plugins.application)
    id (Dependencies.Plugins.kotlinAndroid)
    id (Dependencies.Plugins.kotlinKapt)
//    id (Dependencies.Plugins.hilt)
}

android {
    namespace = Config.appName
    compileSdk = Config.compileSdk

    defaultConfig {
        applicationId = Config.appName
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk
        versionCode = Config.versionCode
        versionName = Config.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Dependencies.Core.Version.composeCompiler
    }
    packagingOptions {
        exclude("META-INF/gradle/incremental.annotation.processors")
    }
}

dependencies {

    implementation(Dependencies.Core.coreKts)
    implementation(Dependencies.Core.appCompat)
    implementation(Dependencies.Core.activityCompose)
    implementation(Dependencies.Core.androidMaterial)

    implementation(Dependencies.Lifecycle.viewModelKtx)
    implementation(Dependencies.Lifecycle.runtimeKtx)
    implementation(Dependencies.Lifecycle.extensions)
    
//    implementation(Dependencies.Compose.ui)
    implementation(Dependencies.Compose.uiTooling)
    implementation(Dependencies.Compose.uiToolingPreview)
    implementation(Dependencies.Compose.material)
    implementation(Dependencies.Compose.materialIconsExtended)
    implementation(Dependencies.Compose.coilCompose)

    implementation(Dependencies.Navigation.navigationCompose)
    implementation(Dependencies.Navigation.lifecycleViewModelCompose)

//    implementation(Dependencies.Retrofit.retrofit)
//    implementation(Dependencies.Retrofit.retrofitConverterGson)

//    implementation(Dependencies.Hilt.android)
//    implementation(Dependencies.Hilt.compiler)
//    implementation(Dependencies.Hilt.compose)

    testImplementation(Dependencies.Test.junit)
    testImplementation(Dependencies.Test.roboeletric)
    testImplementation(Dependencies.Test.mockk)
    testImplementation(Dependencies.Test.okHttp3MockWebServer)
    androidTestImplementation(Dependencies.Test.androidJunit)
    androidTestImplementation(Dependencies.Test.espressoCore)
    androidTestImplementation(Dependencies.Test.composeJunit)
}

//kapt{
//    correctErrorTypes = true
//}