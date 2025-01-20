package com.scheduler.repositories;

import com.scheduler.models.entities.Scheduler;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISchedulerRepository extends JpaRepository<Scheduler, Integer> {
  
  List<Scheduler> getSchedulerByDate(LocalDate date);
  
}
