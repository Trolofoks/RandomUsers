plugins {
    id (Dependencies.Plugins.library)
    id (Dependencies.Plugins.kotlinAndroid)
    id (Dependencies.Plugins.kotlinKapt)
}

android {
    namespace = "com.example.data"
    compileSdk = 33

    defaultConfig {
        minSdk = 33
        targetSdk = 33

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
//        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(Dependencies.Room.runtime)
    implementation(Dependencies.Room.ktx)
    annotationProcessor(Dependencies.Room.compiler)
    kapt(Dependencies.Room.compiler)

    implementation(Dependencies.Retrofit.retrofit)
    implementation(Dependencies.Retrofit.retrofitConverterGson)

    implementation(Dependencies.Core.coreKts)
    implementation(Dependencies.Core.appCompat)
    implementation(Dependencies.Core.androidMaterial)

    testImplementation(Dependencies.Test.junit)
    androidTestImplementation(Dependencies.Test.androidJunit)
    androidTestImplementation(Dependencies.Test.espressoCore)
}

kapt{
    correctErrorTypes = true
}