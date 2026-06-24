package com.example.demo.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class PlayerDto {

    private int playerId;

    @NotBlank(message = "Player Name is Required")
    private String playerName;

    @Min(value = 1, message = "Jersey Number must be greater than 0")
    private int jerseyNumber;

    @NotBlank(message = "Role is Required")
    private String role;

    @Min(value = 0, message = "Total Matches cannot be negative")
    private int totalMatches;

    @NotBlank(message = "Team Name is Required")
    private String teamName;

    @NotBlank(message = "Country Name is Required")
    private String countryName;

    private String description;

    public PlayerDto() {
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getJerseyNumber() {
        return jerseyNumber;
    }

    public void setJerseyNumber(int jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getTotalMatches() {
        return totalMatches;
    }

    public void setTotalMatches(int totalMatches) {
        this.totalMatches = totalMatches;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}