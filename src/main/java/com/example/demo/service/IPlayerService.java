package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.PlayerDto;
import com.example.demo.entity.Player;

public interface IPlayerService {

    Player addPlayer(PlayerDto dto);

    Player updatePlayer(PlayerDto dto);

    PlayerDto getPlayerById(int playerId);

    List<Player> getAllPlayers();

    void deletePlayer(int playerId);
}