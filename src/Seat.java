public class Seat {
    private String row;
    private int number;
    private SeatType type;
    private boolean isBooked;


//make a constructor 
public Seat(String row , int number , SeatType type){
    this.row = row;
    this.number = number;
    this.isBooked = false;
    this.type = type;
}


public String getRow() {
    return row;
}


public void setBooked(boolean isBooked) {
    this.isBooked = isBooked;
}


public int getNumber() {
    return number;
}


public SeatType getType() {
    return type;
}


public boolean isBooked() {
    return isBooked;
}

public String getSeatId(){
    return row + "-" + number;
}

@Override
public String toString() {
    return getSeatId();
}


    

}
