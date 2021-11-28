package com.example.academy.resources;

import com.example.academy.model.Team;
import com.example.academy.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class TeamResource {

    @Autowired
    TeamRepository teamRepository;

    @GetMapping("/teams")
    public List<Team> getTeamLiist(){
        return teamRepository.findAll();
    }

}
