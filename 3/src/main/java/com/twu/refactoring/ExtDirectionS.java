package com.twu.refactoring;

public class ExtDirectionS extends Direction {
    public ExtDirectionS(char arg){
        super(arg);
    }
    
    public Direction turnRight() {
        return new Direction('W');
    }
    
    public Direction turnLeft() {
        return new Direction('E');
    }
}
