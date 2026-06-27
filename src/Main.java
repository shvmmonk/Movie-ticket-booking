import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Show> shows = new ArrayList<>();
        shows.add(new Show("Avengers", "10:00"));
        shows.add(new Show("Intersteller", "14:00"));
        shows.add(new Show("Conjuring", "20:00"));

        for (Show show2 : shows) {
            System.out.println(show2.getName() + " - " + show2.getTime());
        }

      

        Scanner scanner = new Scanner(System.in);
        System.out.println("choose a Movie(1-3)");
        int movieChoice = scanner.nextInt();
        if (movieChoice < 1 || movieChoice > shows.size()) {
            System.out.println("Invalid Choice : Try again");
            return;
        }
        Show show = shows.get(movieChoice - 1);
        show.loadSeats();

       

        while(true){

        System.out.println("1. Show seats");
        System.out.println("2. Book a seat");
        System.out.println("3. Cancel your seat");
        System.out.println("4. View Booking History");
        System.out.println("5. Exit");
        

            int input = scanner.nextInt();  


            switch (input) {
                case 1:
                    System.out.println("These are the seats that are available");
                    show.showSeats();
                    break;
            
                case 2:
                    System.out.print("What is the seat row that you would like to book: ");
                    String row = scanner.next().toUpperCase();
                    System.out.print("what is the seat number that you would like to book: ");
                    int number = scanner.nextInt();
                    System.out.println("Enter your name: ");
                    String name = scanner.next();
                    
                    show.bookSeat(row , number , name);
                    show.saveSeat();
                    System.out.println("Have a nice show , your seat number is " + row + "-" +number);
                    break;

                case 3:
                     System.out.println("Sorry for the inconvenience");
                     System.out.println("What is the seat row you would like to cancel");
                     String seatRow = scanner.next().toUpperCase();
                     System.out.println("What is the seat number you would like to cancel");
                     int seatNumber = scanner.nextInt();

                     show.cancelSeat(seatRow, seatNumber);
                     show.saveSeat();
                     break;

                case 4:
                    System.out.println("These are the list of seats that are available: ");
                    show.showBookingHistory();
                    break;

                case 5:
                    System.out.println("Good Bye and Have a nice day !!");
                    return;

                default:
                    System.out.println("Invalid Statement");
            }
        }
    }
}
