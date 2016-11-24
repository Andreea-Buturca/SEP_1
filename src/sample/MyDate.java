package sample;


public class MyDate  {
    private int hour;
    private int minute;
    private int day;
    private int month;
    private int year;

    public MyDate(int hour, int minute, int day, int month, int year) throws DateException {
        set(hour, minute, day, month, year);
    }

    public void set(int hour, int minute, int day, int month, int year) throws DateException {

        //@TODO make better set with hours and minutes, exceptions if not valid

        if (hour < 0 && hour>24) {
            throw new DateException("Wrong hour input...");
        }else
        this.hour = hour;

        if (minute < 0 && minute>59) {
            throw new DateException("Wrong minute input...");
        }else
        this.minute = minute;


        if (year < 0) {
            throw new DateException("Wrong year input...");
        }else
        this.year=year;

        if (month < 1 && month>12) {
            throw new DateException("Wrong month input");
        }else
        this.month=month;

        if (day < 1) {
            throw new DateException("Wrong day input");
        }else
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

    public MyDate copy() throws DateException {
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
