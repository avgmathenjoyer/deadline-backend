package com.example.deadlineproject.services;

import com.example.deadlineproject.entities.Deadline;
import com.example.deadlineproject.repositories.DeadlineRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeadlineService {

    private final DeadlineRepository deadlineRepository;

    public DeadlineService(DeadlineRepository deadlineRepository) {
        this.deadlineRepository = deadlineRepository;
    }

    public List<Deadline> getDeadlines() {
        return deadlineRepository.findAll();
    }

    public Optional<Deadline> getDeadlineById(long id) {
        return deadlineRepository.findById(id);
    }

    public Integer updateDeadline(Deadline deadline) {
        return deadlineRepository.updateByDeadlineId(deadline.getId(), deadline);
    }

    public Integer deleteDeadlineById(long id) {
        return deadlineRepository.deleteByDeadlineId(id);
    }

    public Deadline addNewDeadline(Deadline deadline) {
        return deadlineRepository.save(deadline);
    }
}
