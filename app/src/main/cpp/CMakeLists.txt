
# For more information about using CMake with Android Studio, read the
# documentation: https://d.android.com/studio/projects/add-native-code.html

# Sets the minimum version of CMake required to build the native library.

cmake_minimum_required(VERSION 3.22.1)

# Declares and names the project.

project("fhldemo")

# Creates and names a library, sets it as either STATIC
# or SHARED, and provides the relative paths to its source code.
# You can define multiple libraries, and CMake builds them for you.
# Gradle automatically packages shared libraries with your APK.
#set(RPS_CPP_PATH C:/Users/lealves/dev/Personal/FHLDemo/rps/RPS)
#include_directories(${RPS_CPP_PATH}/RPS)
#
#add_library(libRPS SHARED IMPORTED)
#set_target_properties(libRPS PROPERTIES
#        IMPORTED_LOCATION "${RPS_CPP_PATH}/${ANDROID_ABI}/Debug/libRPS.so"
#        IMPORTED_LOCATION_Release "${RPS_CPP_PATH}/${ANDROID_ABI}/Release/libRPS.so")

set(P)
include_directories(${CMAKE_CURRENT_SOURCE_DIR}/../../../../rpsnative/src/main/cpp/)
add_library(rpsnative SHARED IMPORTED)
set_target_properties(rpsnative PROPERTIES
        IMPORTED_LOCATION "${CMAKE_CURRENT_SOURCE_DIR}/../../../../rpsnative/build/intermediates/cmake/debug/obj/${CMAKE_ANDROID_ARCH_ABI}/librpsnative.so"
        IMPORTED_LOCATION_Release "${CMAKE_CURRENT_SOURCE_DIR}/../../../../rpsnative/build/intermediates/cmake/debug/obj/${CMAKE_ANDROID_ARCH_ABI}/librpsnative.so")


add_library( # Sets the name of the library.
             fhldemo

             # Sets the library as a shared library.
             SHARED

             # Provides a relative path to your source file(s).
             fhldemo.cpp )

# Searches for a specified prebuilt library and stores the path as a
# variable. Because CMake includes system libraries in the search path by
# default, you only need to specify the name of the public NDK library
# you want to add. CMake verifies that the library exists before
# completing its build.

find_library( # Sets the name of the path variable.
              log-lib

              # Specifies the name of the NDK library that
              # you want CMake to locate.
              log )

# Specifies libraries CMake should link to your target library. You
# can link multiple libraries, such as libraries you define in this
# build script, prebuilt third-party libraries, or system libraries.

target_link_libraries( # Specifies the target library.
                       fhldemo
                       rpsnative
                       #libRPS
                       # Links the target library to the log library
                       # included in the NDK.
                       ${log-lib} )
