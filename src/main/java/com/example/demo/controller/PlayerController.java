package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.PlayerDto;
import com.example.demo.entity.Player;
import com.example.demo.service.IPlayerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/players")
public class PlayerController {
                  @Autowired 
                  IPlayerService service;
                  
                  
                  
                  @PostMapping("/add")
                  public Player addPlayer(@Valid @RequestBody PlayerDto dto) {
                	  return service.addPlayer(dto);
                  }
                  
                  
                  @GetMapping("/getById/{playerId}")
                  public PlayerDto getPlayerById(@PathVariable int playerId) {
                	  return service.getPlayerById(playerId);
                  }
                  
                  @PutMapping("/update")
                  public Player updatePlayer(@Valid @RequestBody PlayerDto dto) {
                	  return service.updatePlayer(dto);
                  }
                  
                  @DeleteMapping("/delete/{playerId}")
                  public String deletePlayer(@PathVariable int playerId) {
                	 service.deletePlayer(playerId);
                	 return "player deleted successfully";
                  }
                  
                  @GetMapping("/getall")
                  public List<Player> getAllPlayers(){
                	  return service.getAllPlayers();
                  }
}

