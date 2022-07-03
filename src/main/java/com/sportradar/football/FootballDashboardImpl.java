package com.sportradar.football;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FootballDashboardImpl implements FootballDashborad {
	
	private List<MatchDetails> matches = new ArrayList<>();
	
	@Override
	public void startFootballTournament() {
		System.out.println("Hello, Welcome to the sports event");
		List<String> options = Arrays.asList("1 - Start a game", "2 - Finish game", "3 - Update score", "4 - Dashboard", "5 - Exit");
		int optionSelected = 4;
		Scanner in = new Scanner(System.in);
		
		in.close();
	}

}
