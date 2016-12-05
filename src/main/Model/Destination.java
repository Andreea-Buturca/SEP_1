package main.Model;

import java.io.Serializable;

/**
 * Created by MartinNtb on 15-Nov-16.
 */
public class Destination implements Serializable {

    private String place;
    private String stopTime;

    public Destination(String place) {
        this.place = place;
    }

    public Destination(String place, String stopTime) {
        this.place = place;
        this.stopTime = stopTime;
    }

    public String getPlace() {
        return place;
    }

    public String getStopString() {
        return place + ", " + stopTime;
    }

    @Override
    public String toString() {
        String time = "";
        if (stopTime != null) {
            time = ", " + stopTime + "min";
        }
        return place + time;
    }


}
