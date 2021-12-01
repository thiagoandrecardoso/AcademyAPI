package com.example.academy.resources;

import com.example.academy.model.Team;
import com.example.academy.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/teams")
public class TeamResource {

    @Autowired
    TeamRepository teamRepository;

    @GetMapping("/list")
    public List<Team> getTeamLiist() {
        return teamRepository.findAll();
    }

    @GetMapping("/{id}")
    public Team getTeamById(@PathVariable(value = "id") long id){
        return teamRepository.findById(id);
    }

    @PostMapping("/save")
    public Team saveTeam(@RequestBody Team team){
        return teamRepository.save(team);
    }

    @DeleteMapping("/delete")
    public void deleteTeam(@RequestBody Team team){
        teamRepository.delete(team);
    }

    @PutMapping("/update")
    public Team updateTeam(@RequestBody Team team){
        return teamRepository.save(team);
    }

}
