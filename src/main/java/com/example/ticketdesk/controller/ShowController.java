package com.example.ticketdesk.controller;

import com.example.ticketdesk.model.Show;
import com.example.ticketdesk.service.ShowService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shows")
public class ShowController {

    private final ShowService showService;

    public ShowController(ShowService showService) {
        this.showService = showService;
    }

    @PostMapping
    public Show addShow(@RequestBody Show show) {
        return showService.addShow(show);
    }

    @GetMapping
    public List<Show> getAllShows() {
        return showService.getAllShows();
    }

    @GetMapping("/{id}")
    public Show getShowById(@PathVariable Long id) {
        return showService.getShowById(id);
    }

    @PutMapping("/{id}")
    public Show updateShow(@PathVariable Long id, @RequestBody Show show) {
        Show existingShow = showService.getShowById(id);

        if (existingShow == null) {
            return null;
        }

        existingShow.setMovieName(show.getMovieName());
        existingShow.setTheatre(show.getTheatre());
        existingShow.setShowTime(show.getShowTime());
        existingShow.setAvailableSeats(show.getAvailableSeats());

        return showService.addShow(existingShow);
    }

    @DeleteMapping("/{id}")
    public String deleteShow(@PathVariable Long id) {
        showService.deleteShow(id);
        return "Show deleted successfully";
    }
}