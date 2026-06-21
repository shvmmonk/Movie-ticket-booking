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

public void cancelSeat(String row , int number){
     for (Seat seat : seats) {
        if(seat.getRow().equals(row) && seat.getNumber() == number){
            if(seat.isBooked() == false){
                System.out.println("This seat is not booked till yet");
                return;
            }

            if(seat.isBooked() == true){
                seat.setBooked(false);;
                System.out.println("Your seat is cancelled Successfully . Any debited amount will be credited into your respective account within 3-4 working days");
                return;
            }


        }

     }
       
        System.out.println("Seat Not Found");
}

public void showSeats(){
    String currentRow = "";
    for(Seat seat : seats){
        if (!seat.getRow().equals(currentRow)) { // in java we use .eqauls insted of == while dealing with strings
            System.out.println();
            currentRow = seat.getRow();
            System.out.print(seat.getRow() + ": ");
        }
        String status = seat.isBooked() ? "[X]" : "[O]";
        System.out.print(status + " ");
    }
    }

    public void bookSeat(String row , int number){
        for(Seat seat: seats){
           if(seat.getRow().equals(row) && seat.getNumber() == number){
            if (seat.isBooked()) {
               
                System.out.println("Sorry this seat is already booked");

                return;
            }else{
                seat.setBooked(true);
                System.out.println("Thanks for Booking");
                System.out.println("Your seat is booked");
                return;
            }


           }
           
            
        }

                    System.out.println("Seat is not found : Sorry for the inconvinience");


        


}

}