import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
         Show show = new Show("Avengers", "10:00 PM");
        // show.bookSeat("A",1 );
        // show.bookSeat("A",1 );
        // show.bookSeat("Z",99 );
        // show.showSeats();

        Scanner scanner = new Scanner(System.in);
        

       

        while(true){

        System.out.println("1. Show seats");
        System.out.println("2. Book a seat");
        System.out.println("3. Exit");

            int input = scanner.nextInt();

            switch (input) {
                case 1:
                    show.showSeats();
                    break;
            
                case 2:
                    String row = scanner.next();
                    int number = scanner.nextInt();
                    show.bookSeat(row, number);
                    break;

                case 3:
                    System.out.println("Good Bye");
                    return;

                default:
                    System.out.println("Invalid");
            }
        }
    }
}
