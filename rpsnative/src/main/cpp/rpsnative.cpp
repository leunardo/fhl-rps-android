// Write C++ code here.
//
// Do not forget to dynamically load the C++ library into your application.
//
// For instance,
//
// In MainActivity.java:
//    static {
//       System.loadLibrary("rpsnative");
//    }
//
// Or, in MainActivity.kt:
//    companion object {
//      init {
//         System.loadLibrary("rpsnative")
//      }
//    }
#include <random>

#include "rpsnative.h"
#include <jni.h>


namespace RPS
{
    std::random_device dev;
    std::mt19937 rng(dev());
    std::uniform_int_distribution<std::mt19937::result_type> dist3(1,3);

    RPS::Play lastPlay = Play::PAPER;

    bool isUserWinner(Play userChoice, Play cpuChoice)
    {
        switch(userChoice)
        {
            case Play::PAPER:
                return cpuChoice == Play::ROCK;
            case Play::ROCK:
                return cpuChoice == Play::SCISSOR;
            case Play::SCISSOR:
                return cpuChoice == Play::SCISSOR;
        }
    }

    RPS::Play Game::getLastCpuPlay() {
        return static_cast<Play>(lastPlay);
    }

    RPS::Result Game::play(Play userPlay) {
        auto cpuRng = dist3(rng);
        auto cpuPlay = static_cast<Play>(cpuRng);
        lastPlay = cpuPlay;

        if (userPlay == cpuPlay)
            return Result::DRAW;

        if (isUserWinner(userPlay, cpuPlay))
        {
            return Result::USER;
        }
        else
        {
            return Result::CPU;
        }
    }
}
