package com.twu.refactoring;

public class ExtDirectionN extends Direction {
    public ExtDirectionN(char arg){
        super(arg);
    }

    public Direction turnRight() {
        return new Direction('E');
    }
    
    public Direction turnLeft() {
        return new Direction('W');
    }
}
