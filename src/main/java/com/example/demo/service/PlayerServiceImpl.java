package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.PlayerDto;
import com.example.demo.entity.Player;
import com.example.demo.exception.PlayerNotFoundException;
import com.example.demo.repository.PlayerRepository;

@Service
public class PlayerServiceImpl implements IPlayerService {

    @Autowired
    private PlayerRepository repo;

    @Override
    public Player addPlayer(PlayerDto dto) {

        Player player = new Player();

        player.setPlayerName(dto.getPlayerName());
        player.setJerseyNumber(dto.getJerseyNumber());
        player.setRole(dto.getRole());
        player.setTotalMatches(dto.getTotalMatches());
        player.setTeamName(dto.getTeamName());
        player.setCountryName(dto.getCountryName());
        player.setDescription(dto.getDescription());

        return repo.save(player);
    }

    @Override
    public Player updatePlayer(PlayerDto dto) {

        Player player = repo.findById(dto.getPlayerId())
                .orElseThrow(() ->
                new PlayerNotFoundException(
                        "Player Id " + dto.getPlayerId() + " Not Found"));

        player.setPlayerName(dto.getPlayerName());
        player.setJerseyNumber(dto.getJerseyNumber());
        player.setRole(dto.getRole());
        player.setTotalMatches(dto.getTotalMatches());
        player.setTeamName(dto.getTeamName());
        player.setCountryName(dto.getCountryName());
        player.setDescription(dto.getDescription());

        return repo.save(player);
    }

    @Override
    public PlayerDto getPlayerById(int playerId) {

        Player player = repo.findById(playerId)
                .orElseThrow(() ->
                new PlayerNotFoundException(
                        "Player Id " + playerId + " Not Found"));

        PlayerDto dto = new PlayerDto();

        dto.setPlayerId(player.getPlayerId());
        dto.setPlayerName(player.getPlayerName());
        dto.setJerseyNumber(player.getJerseyNumber());
        dto.setRole(player.getRole());
        dto.setTotalMatches(player.getTotalMatches());
        dto.setTeamName(player.getTeamName());
        dto.setCountryName(player.getCountryName());
        dto.setDescription(player.getDescription());

        return dto;
    }

    @Override
    public List<Player> getAllPlayers() {

        return repo.findAll();
    }

    @Override
    public void deletePlayer(int playerId) {

        Player player = repo.findById(playerId)
                .orElseThrow(() ->
                new PlayerNotFoundException(
                        "Player Id " + playerId + " Not Found"));

        repo.delete(player);
    }
    
    @Override
    public Player findPlayerWithHighestMatches() {

        return repo.findPlayerWithHighestMatches();
    }
}