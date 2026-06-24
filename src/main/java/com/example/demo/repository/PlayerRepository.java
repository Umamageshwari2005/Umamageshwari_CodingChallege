package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {

	@Query("SELECT p FROM Player p WHERE p.totalMatches = (SELECT MAX(p2.totalMatches) FROM Player p2)")
	Player findPlayerWithHighestMatches();
}