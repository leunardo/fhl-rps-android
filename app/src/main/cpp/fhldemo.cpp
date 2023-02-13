#include <jni.h>

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

namespace FHLDemo
{
    void PlayGame() {

    }
}

extern "C"
JNIEXPORT jint JNICALL
Java_com_microsoft_fhldemo_RPSNative_PlayGame(JNIEnv *env, jclass clazz, jint user_choice) {
    int userChoice = reinterpret_cast<int>(user_choice);

    return userChoice;
}