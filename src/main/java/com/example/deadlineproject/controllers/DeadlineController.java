package com.example.deadlineproject.controllers;


import com.example.deadlineproject.services.DeadlineService;
import com.example.deadlineproject.entities.Deadline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;


@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping(path="api/deadline")
public class DeadlineController {

    private final DeadlineService deadlineService;

    @Autowired
    public DeadlineController(DeadlineService deadlineService) {
        this.deadlineService = deadlineService;
    }

    @CrossOrigin(origins="*")
    @GetMapping(path="/all")
    public List<Deadline> getDeadlines() {
        return deadlineService.getDeadlines();
    }

    @PostMapping(path="/create", consumes = {"application/json"})
    public Deadline addDeadline(@RequestBody Deadline deadline) {
        if (Objects.equals(deadline.getDescription(), "")) {
            // set default description when user provided none
            deadline.setDescription("Deadline default description.");
        }
        if (Objects.equals(deadline.getTitle(), "")) {
            // set default description when user provided none
            deadline.setTitle("Deadline default title");
        }
        return deadlineService.addNewDeadline(deadline);
    }

    @PatchMapping(path="/update", consumes = {"application/json"})
    public ResponseEntity<String> updateDeadline(@RequestBody Deadline deadline) {
        if (Objects.equals(deadline.getDescription(), "")) {
            deadline.setDescription("Deadline default description.");
        }
        if (Objects.equals(deadline.getTitle(), "")) {
            deadline.setTitle("Deadline default title.");
        }
        if (deadlineService.updateDeadline(deadline) == 1) {
            return ResponseEntity.ok("Deadline updated successfully.");
        }
        else {
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping(path="/delete", consumes = {"application/json"})
    public ResponseEntity<String> deleteDeadline(@RequestBody Long id) {
        if ( deadlineService.deleteDeadlineById(id) == 1) {
            return ResponseEntity.ok("Deleted deadline successfully");
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
