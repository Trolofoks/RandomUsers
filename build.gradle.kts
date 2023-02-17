buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Dependencies.ProjectPlugins.androidGradlePlugin)
        classpath(Dependencies.ProjectPlugins.kotlinGradlePlugin)
    }
}

tasks.register("clean", Delete::class){
    delete(rootProject.buildDir)
}