package com.example.sellinglaptops.service.status;

import com.example.sellinglaptops.model.Status;
import com.example.sellinglaptops.repository.IStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class StatusService implements IStatusService{
    @Autowired
    private IStatusRepository iStatusRepository;
    @Override
    public Iterable<Status> findAll() {
        return iStatusRepository.findAll();
    }

    @Override
    public Optional<Status> findById(long id) {
        return iStatusRepository.findById(id);
    }

    @Override
    public Status save(Status status) {
        return iStatusRepository.save(status);
    }

    @Override
    public void remove(long id) {
        iStatusRepository.deleteById(id);
    }
}
