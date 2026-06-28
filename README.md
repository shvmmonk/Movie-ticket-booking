# Movie Ticket Booking System

A console-based movie ticket booking system built in Java. Browse available movies, view seat availability, book seats with pricing, cancel bookings, and track booking history — all from an interactive command-line menu.

## Features

- **Multiple movies/shows** to choose from, each with its own independent seating
- **Seat map display** — view all seats in a row-wise grid (`[O]` = available, `[X]` = booked)
- **Seat booking** with validation (prevents double-booking, handles invalid seat numbers)
- **Seat cancellation** with validation (prevents cancelling an already-free seat)
- **Two seat types** — Regular (₹300) and Premium (₹500) — with automatic price calculation on booking
- **Customer & booking history tracking** — every successful booking is recorded with customer name, seat, movie, and date
- **Case-insensitive input** — seat row letters work whether typed in upper or lower case
- Basic file-based saving of seat status
- Simple, interactive console menu

## Tech Stack

- Java (no external libraries or frameworks)

## How to Run

1. Clone the repository
   ```bash
   git clone https://github.com/shvmmonk/Movie-ticket-booking.git
   cd Movie-ticket-booking
   ```

2. Compile the source files
   ```bash
   javac src/*.java
   ```

3. Run the app
   ```bash
   java src.Main
   ```

## Usage

On launch, you'll see a list of available movies:
```
Avengers - 10:00
Intersteller - 14:00
Conjuring - 20:00
choose a Movie(1-3)
```

After picking a movie, you'll get the main menu:

| Option | Action |
|---|---|
| `1` | Show seats |
| `2` | Book a seat |
| `3` | Cancel your seat |
| `4` | View booking history |
| `5` | Exit |

When booking or cancelling, you'll be asked for a **row** (A–E) and a **seat number** (1–10). Booking also asks for your name, which gets recorded in the booking history.

### Example session

```
1. Show seats
2. Book a seat
3. Cancel your seat
4. View Booking History
5. Exit
2
What is the seat row that you would like to book: b
what is the seat number that you would like to book: 1
Enter your name: Shivam
Thanks for Booking
Your seat is booked
Total amount: ₹300
Have a nice show, your seat number is B-1
```

## Project Structure

```
src/
├── Main.java       # Entry point — movie selection and console menu
├── Show.java       # Represents a movie show: seat generation, booking, cancellation, seat map, booking history, save/load
├── Seat.java       # Represents a single seat (row, number, type, booked status)
├── SeatType.java   # Enum for seat categories with pricing (REGULAR ₹300, PREMIUM ₹500)
└── Booking.java    # Represents a single booking record (customer, movie, seat, date)
```

## Known Limitations

- **Seat status loading is incomplete** — `loadSeats()` reads the saved file but doesn't yet restore booking status on restart. Bookings persist within a single session but reset when the program is run again.
- Input validation handles out-of-range/invalid seat numbers gracefully, but malformed input (e.g. entering text where a number is expected) can still throw an exception.

## Future Improvements

- Complete the seat-loading logic so bookings survive a restart
- Move to a database instead of flat-file storage
- Add stricter input validation (try-catch around numeric input)
- Build a web version with Spring Boot + HTML/CSS frontend