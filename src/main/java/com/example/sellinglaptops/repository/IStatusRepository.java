package com.example.sellinglaptops.repository;

import com.example.sellinglaptops.model.Status;
import org.springframework.data.repository.CrudRepository;

public interface IStatusRepository extends CrudRepository<Status,Long> {
}
