import java.util.*;

public class Show{
    private String name;
    private String time;
    private List<Seat> seats = new ArrayList<>(); //list is an interface
// we cannot make make list directly as an object so we make arraylist

public Show(String name , String time){
    this.name = name;
    this.time = time;
    generateSeat();
}

// these are the getter methods 
public String getName(){ 
    return name;
}


public String getTime() {
	return time;
}

public List<Seat> getSeats(){
    return seats;
}

//these are the setter methods
public void setName(String name){
    this.name = name;
}

public void setTime(String time){
    this.time = time;
}

public void setSeat(List<Seat> seats){
    this.seats = seats;
}

public void generateSeat(){
    for(char row = 'A' ; row <= 'E' ; row++){
        for(int col = 1 ; col <= 10 ; col++){
            SeatType type;
            if (row == 'B') {
                type = SeatType.REGULAR;
            }else{
                type = SeatType.PREMIUM;
            }
            Seat newSeat = new Seat(String.valueOf(row),col,type);
            seats.add(newSeat);
        }
    } // valof se we converted the char into the string
}

}