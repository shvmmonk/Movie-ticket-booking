public class Booking {
    private String customerName;
    private String movieName;
    private String seatId;
    private String bookedAt;


    public Booking(String customerName , String movieName , String seatId){
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatId = seatId;
        this.bookedAt = java.time.LocalDate.now().toString();
    }

    public String getCustomerName() {
        return customerName;
    }
    public String getMovieName() {
        return movieName;
    }
    public String getSeatId() {
        return seatId;
    }
    public String getBookedAt() {
        return bookedAt;
    }


    
}
