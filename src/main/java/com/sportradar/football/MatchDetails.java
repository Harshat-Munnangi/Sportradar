package com.sportradar.football;

import java.time.LocalDateTime;
import java.util.List;

public class MatchDetails {

	private String homeTeam; 
	private String awayTeam; 
	private int homeTeamPoints; 
	private int awayTeamPoints;
	private LocalDateTime createdTime;
	
	public MatchDetails(String homeTeam, String awayTeam, int homeTeamPoints, int awayTeamPoints) {
		super();
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.homeTeamPoints = homeTeamPoints;
		this.awayTeamPoints = awayTeamPoints;
		this.createdTime = LocalDateTime.now();
	}
	
	public String getHomeTeam() {
		return homeTeam;
	}
	public String getAwayTeam() {
		return awayTeam;
	}
	public int getHomeTeamPoints() {
		return homeTeamPoints;
	}
	public int getAwayTeamPoints() {
		return awayTeamPoints;
	}
	public LocalDateTime getCreatedTime() {
		return createdTime;
	}
	public void setHomeTeam(String homeTeam) {
		this.homeTeam = homeTeam;
	}
	public void setAwayTeam(String awayTeam) {
		this.awayTeam = awayTeam;
	}
	public void setHomeTeamPoints(int homeTeamPoints) {
		this.homeTeamPoints = homeTeamPoints;
	}
	public void setAwayTeamPoints(int awayTeamPoints) {
		this.awayTeamPoints = awayTeamPoints;
	}
	
	public boolean findAnyExistingMatch(List<MatchDetails> matches) {
		return matches.stream().anyMatch(e -> e.homeTeam.equals(this.homeTeam) && e.awayTeam.equals(this.awayTeam));
	}
	
}
