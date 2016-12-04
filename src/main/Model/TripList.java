package main.Model;

import javax.lang.model.util.TypeKindVisitor7;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Created by Marek on 04-Dec-16.
 */
public class TripList implements Serializable {

    private ArrayList<Trip> trips;

    public TripList() {
        this.trips = new ArrayList<>();
    }

    public void add(Trip trip){
        trips.add(trip);
    }

    public int getSize(){
        return trips.size();
    }

    public void remove(Trip trip){
        trips.remove(trip);
    }

    public Trip get(int index){
        return trips.get(index);
    }

    public TripList findAllByDate(LocalDate date){
        TripList result = new TripList();
        for (int i=0;i<trips.size();i++){
            if ((trips.get(i).getTimeStart().getYear()==date.getYear())
                    &&(trips.get(i).getTimeStart().getMonth()==date.getMonthValue())
                    &&(trips.get(i).getTimeStart().getDay()==date.getDayOfMonth())){
                result.add(trips.get(i));
            }
        }
        return result;
    }

    public TripList findAllByDeparture(String departure) {
        TripList result = new TripList();
        for (int i = 0; i < trips.size(); i++) {
            if (trips.get(i).getPickUpPoint().getPlace().equals(departure)) {
                result.add(trips.get(i));
            }
        }
        return result;
    }

    public TripList findAllByDestination(String destination) {
        TripList result = new TripList();
        for (int i = 0; i < trips.size(); i++) {
            if (trips.get(i).getDestination().getPlace().equals(destination)) {
                result.add(trips.get(i));
            }
        }
        return result;
    }
}
