package com.twu.refactoring;

public class ExtDirectionW extends Direction {
    public ExtDirectionW(char arg){
        super(arg);
    }

    public Direction turnRight() {
        return new Direction('S');
    }

    public Direction turnLeft() {
        return new Direction('S');
    }
}
