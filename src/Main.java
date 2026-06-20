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
                    System.out.println("These are the seats that are available");
                    show.showSeats();
                    break;
            
                case 2:
                    System.out.print("What is the seat row that you would like to book: ");
                    String row = scanner.next();
                    System.out.print("what is the seat number that you would like to book: ");
                    int number = scanner.nextInt();
                    
                    show.bookSeat(row, number);
                    System.out.println("Have a nice show , your seat number is " + row + "-" +number);
                    break;

                case 3:
                    System.out.println("Good Bye and Have a nice day !!");
                    return;

                default:
                    System.out.println("Invalid Statement");
            }
        }
    }
}
