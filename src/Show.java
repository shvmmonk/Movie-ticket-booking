import java.util.*;

public class Show {
    private String name;
    private String time;
    private List<Seat> seats = new ArrayList<>(); // list is an interface
    private List<Booking> bookingHistory = new ArrayList<>(); // it has the record of the successfull booking

    // we cannot make make list directly as an object so we make arraylist

    public Show(String name, String time) {
        this.name = name;
        this.time = time;
        generateSeat();
    }

    // these are the getter methods
    public String getName() {
        return name;
    }

    public String getTime() {
        return time;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    // these are the setter methods
    public void setName(String name) {
        this.name = name;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setSeat(List<Seat> seats) {
        this.seats = seats;
    }

    public void generateSeat() {
        for (char row = 'A'; row <= 'E'; row++) {
            for (int col = 1; col <= 10; col++) {
                SeatType type;
                if (row == 'B') {
                    type = SeatType.REGULAR;
                } else {
                    type = SeatType.PREMIUM;
                }
                Seat newSeat = new Seat(String.valueOf(row), col, type);
                seats.add(newSeat);
            }
        } // valof se we converted the char into the string
    }

    public void cancelSeat(String row, int number) {
        for (Seat seat : seats) {
            if (seat.getRow().equals(row) && seat.getNumber() == number) {
                if (seat.isBooked() == false) {
                    System.out.println("This seat is not booked till yet");
                    return;
                }

                if (seat.isBooked() == true) {
                    seat.setBooked(false);
                    ;
                    System.out.println(
                            "Your seat is cancelled Successfully . Any debited amount will be credited into your respective account within 3-4 working days");
                    return;
                }

            }

        }

        System.out.println("Seat Not Found");
    }

    public void showSeats() {
        String currentRow = "";
        for (Seat seat : seats) {
            if (!seat.getRow().equals(currentRow)) { // in java we use .eqauls insted of == while dealing with strings
                System.out.println();
                currentRow = seat.getRow();
                System.out.print(seat.getRow() + ": ");
            }
            String status = seat.isBooked() ? "[X]" : "[O]";
            System.out.print(status + " ");
        }
    }

    public void bookSeat(String row, int number, String customerName) {
        for (Seat seat : seats) {
            if (seat.getRow().equals(row) && seat.getNumber() == number) {
                if (seat.isBooked()) {

                    System.out.println("Sorry this seat is already booked");

                    return;
                } else {

                    seat.setBooked(true);
                    Booking book = new Booking(customerName, name, seat.getSeatId());
                    bookingHistory.add(book);
                    System.out.println("Thanks for Booking");
                    System.out.println("Your seat is booked");
                    return;
                }

            }

        }

        System.out.println("Seat is not found : Sorry for the inconvinience");

    }

    public void saveSeat() {
        try {
            java.io.FileWriter writer = new java.io.FileWriter("seats.txt");
            for (Seat seat : seats) {
                writer.write(
                        seat.getRow() + "," + seat.getNumber() + "," + seat.getType() + "," + seat.isBooked() + "\n");

            }
            writer.close();
        } catch (Exception e) {
            System.out.println("Save error:" + e.getMessage());
        }
    }

    // Java mein file padhne ke liye BufferedReader use hota hai — ye line-by-line
    // text padhne ka tool hai.
    public void loadSeats() {
        try {
            java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.FileReader("seats.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                System.out.println(parts[0]);
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("No saved seats found");
        }
    }

    public void showBookingHistory() {
        if(bookingHistory.isEmpty()){
            System.out.println("No bookings yet");
            return;
        }

        for (Booking booking : bookingHistory) {
            System.out.println(booking.getCustomerName() + " booked the seat " + booking.getSeatId() + " for " + booking.getMovieName() + " on " + booking.getBookedAt());
        }

    }

}