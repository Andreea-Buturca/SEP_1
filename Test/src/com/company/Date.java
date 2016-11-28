package com.company;

/**
 * Created by Marek on 24-Nov-16.
 */
public class Date {
    private int day;
    private int month;
    private int year;

    // TODO: 27-Nov-16 possibly also time? 
    
    public Date(int day, int month, int year) {
       setDate(day, month, year);
    }

    public void setDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
       // TODO: 24-Nov-16 Exeptions!

    }

    public Date copy(){
        Date obj = new Date(this.day,this.month,this.year);
        return obj;
    }


}
