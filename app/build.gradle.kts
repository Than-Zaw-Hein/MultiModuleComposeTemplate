plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin)
    alias(libs.plugins.jetbrains.kotlin.compose)
    alias(libs.plugins.google.ksp)
    alias(libs.plugins.dagger.hilt)
}

android {
    namespace = "com.tzh.multimoduletemplate"
    compileSdk = ProjectConfig.compileSdk

    defaultConfig {
        applicationId = "com.tzh.multimoduletemplate"
        minSdk = ProjectConfig.minSdk
        targetSdk = ProjectConfig.targetSdk
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
        multiDexEnabled = true
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

    // Compose Navigation
    implementation(libs.androidx.navigation.compose)

    // Splash API
    implementation(libs.androidx.core.splashscreen)
    // Dagger Hilt
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)

    // Desugar JDK
    coreLibraryDesugaring(libs.desugar.jdk.libs)

    implementation(project(":core:ui"))
    implementation(project(":core:util"))

//    implementation(project(":core:ui"))
//    implementation(project(":core:util"))
//    implementation(project(":data:mongo"))
//    implementation(project(":feature:auth"))
//    implementation(project(":feature:home"))
//    implementation(project(":feature:write"))
}