plugins {
    id("com.android.application")
}

android {
    namespace = "vesit.ajayk57.mc.practical8"
    compileSdk = 34

    defaultConfig {
        applicationId = "vesit.ajayk57.mc.practical8"
        minSdk = 24
        //noinspection EditedTargetSdkVersion
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation ("androidx.core:core:1.12.0")
    implementation ("androidx.media:media:1.6.0")
    implementation("com.google.android.material:material:1.10.0")
    implementation("com.google.android.gms:play-services-location:21.0.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}

allprojects{
    gradle.projectsEvaluated{
        tasks.withType<JavaCompile> {options.compilerArgs.add("-Xlint:deprecation")}
    }
}