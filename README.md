# Movie Ticket Booking System

A console-based movie ticket booking system built in Java. Browse available movies, view seat availability, book seats, and cancel bookings — all from an interactive command-line menu.

## Features

- **Multiple movies/shows** to choose from, each with its own independent seating
- **Seat map display** — view all seats in a row-wise grid (`[O]` = available, `[X]` = booked)
- **Seat booking** with validation (prevents double-booking, handles invalid seat numbers)
- **Seat cancellation** with validation (prevents cancelling an already-free seat)
- Two seat types — Regular and Premium
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
| `4` | Exit |

When booking or cancelling, you'll be asked for a **row** (A–E) and a **seat number** (1–10).

### Example session

```
choose a Movie(1-3)
1
1. Show seats
2. Book a seat
3. Cancel your seat
4. Exit
2
What is the seat row that you would like to book: A
what is the seat number that you would like to book: 1
Thanks for Booking
Have a nice show, your seat number is A-1
```

## Project Structure

```
src/
├── Main.java       # Entry point — movie selection and console menu
├── Show.java       # Represents a movie show: seat generation, booking, cancellation, seat map display
├── Seat.java       # Represents a single seat (row, number, type, booked status)
└── SeatType.java   # Enum for seat categories (REGULAR, PREMIUM)
```

## Future Improvements

- File persistence — currently all bookings reset when the program restarts
- Booking history — track which customer booked which seats and when
- Pricing logic based on seat type
- Input validation for malformed input (e.g. text instead of numbers)