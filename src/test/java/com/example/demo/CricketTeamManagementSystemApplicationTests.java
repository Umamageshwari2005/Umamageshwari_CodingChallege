package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dto.PlayerDto;
import com.example.demo.entity.Player;
import com.example.demo.service.IPlayerService;

@SpringBootTest
class CricketTeamManagementSystemApplicationTests {

	
	
	
	
	@Autowired
	IPlayerService service;
	
	@Test
	public void testAddPlayer() {
		PlayerDto dto=new PlayerDto();
		
		dto.setPlayerName("Virat Kohli");
        dto.setJerseyNumber(18);
        dto.setRole("Batsman");
        dto.setTotalMatches(500);
        dto.setTeamName("RCB");
        dto.setCountryName("India");
        dto.setDescription("Top Order Batsman");
        
        Player player=service.addPlayer(dto);
        assertNotNull(player);
		
	}
	
	@Test
    public void testGetPlayerById() {

        PlayerDto player = service.getPlayerById(1);

        assertNotNull(player);
    }
	@Test
    public void testGetAllPlayers() {

        List<Player> players = service.getAllPlayers();

        assertNotNull(players);
    }
	@Test
    public void testUpdatePlayer() {

        PlayerDto dto = new PlayerDto();

        dto.setPlayerId(1);
        dto.setPlayerName("Virat Kohli");
        dto.setJerseyNumber(18);
        dto.setRole("Batsman");
        dto.setTotalMatches(550);
        dto.setTeamName("RCB");
        dto.setCountryName("India");
        dto.setDescription("Former Indian Captain");

        Player player = service.updatePlayer(dto);

        assertNotNull(player);
    }
	@Test
    public void testDeletePlayer() {

        service.deletePlayer(1);

        List<Player> players = service.getAllPlayers();

        assertFalse(players.isEmpty());
    }
}
