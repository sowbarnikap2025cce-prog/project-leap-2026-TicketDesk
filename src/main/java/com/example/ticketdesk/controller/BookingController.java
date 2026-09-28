package com.example.ticketdesk.controller;

import com.example.ticketdesk.model.Booking;
import com.example.ticketdesk.service.BookingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public Booking addBooking(@RequestBody Booking booking) {
        return bookingService.addBooking(booking);
    }

    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @GetMapping("/{id}")
    public Booking getBookingById(@PathVariable Long id) {
        return bookingService.getBookingById(id);
    }

    @PutMapping("/{id}")
    public Booking updateBooking(@PathVariable Long id, @RequestBody Booking booking) {
        Booking existingBooking = bookingService.getBookingById(id);

        if (existingBooking == null) {
            return null;
        }

        existingBooking.setCustomerName(booking.getCustomerName());
        existingBooking.setMovieName(booking.getMovieName());
        existingBooking.setTheatre(booking.getTheatre());
        existingBooking.setShowTime(booking.getShowTime());
        existingBooking.setNumberOfSeats(booking.getNumberOfSeats());

        return bookingService.addBooking(existingBooking);
    }

    @DeleteMapping("/{id}")
    public String deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
        return "Booking deleted successfully";
    }
}