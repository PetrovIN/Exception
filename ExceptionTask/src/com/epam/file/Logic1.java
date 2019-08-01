package com.epam.file;

public class Logic1 {
    public boolean cigarParty(int cigars, boolean isWeekend) {
        if (isWeekend) {
            return (cigars>=40);
        } else {
            return (cigars>=40 && cigars<=60);
        }
    }
    public int dateFashion(int you, int date) {
        if (date >= 8 && you >= 8 || date >= 8 && you > 2 || date > 2 && you >= 8) {
            return 2;
        } else if (date <= 2 && you >= 8 || date >= 8 && you <= 2 || date <= 2 && you < 8 || date < 8 && you <= 2) {
            return 0;
        } else if (date > 2 && date < 8 && you > 2 && you < 8 || date > 2 && you < 8) {
            return 1;
        }
        return 0;
    }
    public boolean squirrelPlay(int temp, boolean isSummer) {
        if (isSummer) {
            return (temp >= 60 && temp <= 100);
        } else {
            return (temp >= 60 && temp <= 90);
        }
    }
}
