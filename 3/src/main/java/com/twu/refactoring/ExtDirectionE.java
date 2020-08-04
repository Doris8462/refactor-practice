package com.twu.refactoring;

public class ExtDirectionE extends Direction {
    public ExtDirectionE(char arg){
        super(arg);
    }
    
    public Direction turnRight() {
        return new Direction('N');
    }
    
    public Direction turnLeft() {
        return new Direction('N');
    }
}
