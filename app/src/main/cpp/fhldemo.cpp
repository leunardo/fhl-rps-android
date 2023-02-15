#include <jni.h>
// #include <RPS.h>

// Write C++ code here.
//
// Do not forget to dynamically load the C++ library into your application.
//
// For instance,
//
// In MainActivity.java:
//    static {
//       System.loadLibrary("fhldemo");
//    }
//
// Or, in MainActivity.kt:
//    companion object {
//      init {
//         System.loadLibrary("fhldemo")
//      }
//    }

// RPS rps;
#include <rpsnative.h>

RPS::Game game;

extern "C"
JNIEXPORT jint JNICALL
Java_com_microsoft_fhldemo_RPSNative_PlayGame(JNIEnv *env, jclass clazz, jint user_choice) {
    int userChoice = reinterpret_cast<int>(user_choice);

    RPS::Play userPlay = static_cast<RPS::Play>(userChoice);

    auto result = game.play(userPlay);

    return static_cast<jint>(result);
}
extern "C"
JNIEXPORT jint JNICALL
Java_com_microsoft_fhldemo_RPSNative_GetLastCPUPlay(JNIEnv *env, jclass clazz) {
    RPS::Play cpuPlay = game.getLastCpuPlay();
    return static_cast<jint>(cpuPlay);
}
