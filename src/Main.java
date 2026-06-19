public class Main {
    public static void main(String[] args) {
        Show show = new Show("Avengers", "10:00 PM");
        show.bookSeat("A",1 );
        show.bookSeat("A",1 );
        show.bookSeat("Z",99 );
        show.showSeats();
        
    }
}
