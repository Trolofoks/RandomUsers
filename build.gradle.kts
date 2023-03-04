buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Dependencies.ClassPath.androidGradlePlugin)
        classpath(Dependencies.ClassPath.kotlinGradlePlugin)
        classpath(Dependencies.ClassPath.daggerGradlePlugin)
    }
}

tasks{
    register("clean", Delete::class){
        delete(rootProject.buildDir)
    }
}


