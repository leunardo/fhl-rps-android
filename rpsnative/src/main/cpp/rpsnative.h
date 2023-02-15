//
// Created by lealves on 14/02/2023.
//

#ifndef FHL_DEMO_RPSNATIVE_H
#define FHL_DEMO_RPSNATIVE_H

namespace RPS
{
    enum class Play
    {
        ROCK = 0,
        PAPER = 1,
        SCISSOR = 2
    };

    enum class Result
    {
        DRAW = 0,
        USER = 1,
        CPU = 2
    };

    class Game
    {
    public:
        Result play(Play userPlay);
        Play getLastCpuPlay();
    };
}

#endif //FHL_DEMO_RPSNATIVE_H
