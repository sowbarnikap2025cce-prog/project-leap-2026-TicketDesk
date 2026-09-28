package com.example.ticketdesk.repository;

import com.example.ticketdesk.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}