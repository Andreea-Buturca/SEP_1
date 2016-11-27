package main.Model;


public class MyDate {
    private int hour;
    private int minute;
    private int day;
    private int month;
    private int year;

    public MyDate(int hour, int minute, int day, int month, int year) {
        set(hour, minute, day, month, year);
    }

    public void set(int hour, int minute, int day, int month, int year) {

        //@TODO make better set with hours and minutes, exceptions if not valid

        this.hour = hour;
        this.minute = minute;


        if (year < 0) {
            year = -year;
        }
        this.year = year;

        if (month < 1) {
            month = 1;
        }
        if (month > 12) {
            month = 12;
        }
        this.month = month;

        if (day < 1) {
            day = 1;
        }
        this.day = day;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public String getMonthName() {
        switch (month) {
            case 1:
                return "January";
            case 2:
                return "February";
            case 3:
                return "March";
            case 4:
                return "April";
            case 5:
                return "May";
            case 6:
                return "June";
            case 7:
                return "July";
            case 8:
                return "August";
            case 9:
                return "September";
            case 10:
                return "October";
            case 11:
                return "November";
            case 12:
                return "December";
            default:
                return "Wrong month";
        }
    }

    public boolean isBefore(MyDate other) {
        int d1 = year * 360 + month * 30 + day;
        int d2 = other.year * 360 + other.month * 30 + other.day;
        return d1 < d2;
    }

    public MyDate copy() {
        return new MyDate(hour, minute, day, month, year);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof MyDate))
            return false;

        MyDate other = (MyDate) obj;

        return day == other.day && month == other.month && year == other.year;
    }

    public String toString() {
        String s = "";
        if (day < 10) {
            s += "0";
        }
        s += day + "/";
        if (month < 10) {
            s += "0";
        }
        s += month + "/" + year;

        return s;
    }

}
