package org.infosys;

import repository.HotelRepository;
import repository.HotelRepositoryImpl;
import services.BookingService;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        HotelRepository hotelRepository = new HotelRepositoryImpl();

        // Create an instance of BookingService using the HotelRepository
        BookingService bookingService = new BookingService(hotelRepository);

        // Scanner to read user input
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Hotel Booking App!");

        // Simple loop to interact with the app
        while (true) {
            System.out.println("\n1. Book a Hotel");
            System.out.println("2. Cancel a Booking");
            System.out.println("3. Exit");
            System.out.print("Please select an option: ");

            int option = scanner.nextInt();
            scanner.nextLine();  // Consume the newline left by nextInt()

            switch (option) {
                case 1:
                    // Booking a hotel
                    System.out.print("Enter Hotel ID: ");
                    long hotelId = scanner.nextLong();
                    scanner.nextLine();  // Consume the newline

                    System.out.print("Enter Customer Name: ");
                    String customerName = scanner.nextLine();

                    // Call the booking service
                    String bookingResult = bookingService.bookHotel(hotelId, customerName);
                    System.out.println(bookingResult);
                    break;

                case 2:
                    // Cancelling a booking
                    System.out.print("Enter Hotel ID: ");
                    hotelId = scanner.nextLong();
                    scanner.nextLine();  // Consume the newline

                    System.out.print("Enter Customer Name: ");
                    customerName = scanner.nextLine();

                    // Call the cancel service
                    String cancelResult = bookingService.cancelBooking(hotelId, customerName);
                    System.out.println(cancelResult);
                    break;

                case 3:
                    // Exit the application
                    System.out.println("Thank you for using the Hotel Booking App. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }
}