plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
//    kotlin("kapt") version "2.0.0"
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
//    id("hilt-android-gradle-plugin")

//    id("com.google.dagger.hilt.android") version "2.51.1" apply false
//    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.example.jetpackcomposepokedex"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.jetpackcomposepokedex"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    configurations { implementation.get().exclude(mapOf("group" to "org.jetbrains", "module" to "annotations")) }

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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
//    kapt("groupId:artifactId:version")
    // Retrofit
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    implementation(libs.okhttp)
    implementation(libs.logging.interceptor)

    //Timber
    implementation(libs.timber)

    // Coroutines
    implementation(libs.kotlinx.coroutines.core)

    // Coroutines LifeCycle Scopes
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx.v284)

    // Coil
    implementation(libs.coil)
    implementation(libs.accompanist.coil)
    implementation(libs.coil.compose)

    // ViewModel Compose
    implementation(libs.androidx.lifecycle.viewmodel.compose)

    // Dagger - Hilt
    implementation("com.google.dagger:hilt-android:2.51.1")
    kapt("com.google.dagger:hilt-android-compiler:2.51.1")
    kapt("androidx.hilt:hilt-compiler:1.2.0")

    // Dagger Core
    implementation(libs.dagger)
    kapt(libs.dagger.compiler)

    // Dagger Android
//    api(libs.dagger.android)
//    api(libs.dagger.android.support)
//    kapt(libs.dagger.android.processor)
//    implementation(libs.dagger.hilt.android.gradle.plugin)
//    kapt("com.google.dagger:hilt-android-compiler:2.44")
//    implementation(libs.hilt.android)
//    implementation(libs.hilt.android)
//    implementation(libs.hilt.android.v244)
//    kapt(libs.hilt.android.compiler.v244)
//    implementation(libs.androidx.hilt.work)
//    kapt(libs.hilt.android.compiler)
//    implementation(libs.androidx.hilt.lifecycle.viewmodel)
//    kapt(libs.androidx.hilt.compiler)
//    implementation(libs.androidx.hilt.navigation.compose)

    // Use to determine dominant colors of an image
    implementation(libs.palette.v7)

    implementation(libs.androidx.hilt.navigation.compose)
    implementation(libs.androidx.navigation.compose)


    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.material.icons.core)
    implementation(libs.androidx.material.icons.extended)

    implementation(libs.androidx.constraintlayout.compose)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}