plugins {
    id ("com.android.application")
    kotlin ("android")
    kotlin ("kapt")
}

repositories {
    google()
    mavenCentral()
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
        kotlinCompilerExtensionVersion = Dependencies.Compose.version
    }
    packagingOptions {
        resources {
            exclude("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
}

dependencies {

    implementation(Dependencies.Core.core)
    implementation(Dependencies.Core.composeActivity)

    implementation(Dependencies.Lifecycle.runtime)

    testImplementation(Dependencies.Test.junit)
    androidTestImplementation(Dependencies.Test.junitTest)
    androidTestImplementation(Dependencies.Test.testCore)

    implementation(Dependencies.Compose.ui)
    implementation(Dependencies.Compose.preview)
    implementation(Dependencies.Compose.material)
    debugImplementation(Dependencies.Compose.UiTooling)
    debugImplementation(Dependencies.Compose.TestManifest)
    androidTestImplementation(Dependencies.Compose.JUnitTest)

}