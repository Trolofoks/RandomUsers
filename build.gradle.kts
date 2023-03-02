buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Dependencies.ClassPath.androidGradlePlugin)
        classpath(Dependencies.ClassPath.kotlinGradlePlugin)
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.0")
//        classpath(Dependencies.ClassPath.daggerGradlePlugin)
    }
}

tasks{
    register("clean", Delete::class){
        delete(rootProject.buildDir)
    }
}

