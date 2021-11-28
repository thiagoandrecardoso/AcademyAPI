package com.example.academy.repository;

import com.example.academy.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
    Team findById(long id);
}
