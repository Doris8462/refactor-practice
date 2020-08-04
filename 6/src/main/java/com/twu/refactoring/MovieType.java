package com.twu.refactoring;

public enum MovieType{

    Regular{
        public double getAmount(int daysRented){
            double thisAmount=0;
            thisAmount += 2;
            if (daysRented > 2)
                thisAmount += (daysRented - 2) * 1.5;
            return thisAmount;
        }
    },
    NewRelease{

        public double getAmount(int daysRented){
            double thisAmount=0;
            thisAmount += daysRented * 3;
            return thisAmount;
        }
    },
    Children{
        public double getAmount(int daysRented){
            double thisAmount=0;
            thisAmount += 1.5;
            if (daysRented > 3)
                thisAmount += (daysRented - 3) * 1.5;
            return thisAmount;
        }
    };
    public abstract double getAmount(int daysRented);
    }
