package com.sportradar.football;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
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
		
		while(optionSelected != 5) {
			showMenu(options);
			try {
				optionSelected = in.nextInt();
				switch (optionSelected) {
				case 1 -> {
					startMatch(in);
					break;
				}
				case 2 -> {
					finishMatch(in);
					break;
				}
				case 3 -> {
					updateMatch(in);
					break;
				}
				case 4 -> {
					printOption(4);
					break;
				}
				case 5 -> {
					System.out.println("Application Closed!!");
					System.exit(0);
				}
				default -> {
					System.out.println("Please choose between 1 and " + options.size());
				}
				}
			} catch (InputMismatchException ime) {
				System.out.println("Please enter an integer value from the above available options");
				in.next();
			}
		}
		in.close();
	}
	
	
	private void showMenu(List<String> options) {
		System.out.println("--------------------------------------------------");
		options.forEach(System.out::println);
		System.out.println("Please select an option:");
	}
	
	private void printOption(int i) {
		System.out.println("Selected option "+i);
	}
	
	private void startMatch(Scanner sc) {
		MatchDetails currentMatch = captureNames(sc);
		if (validMatch(currentMatch)) { 
			matches.add(currentMatch); 
			System.out.println("Success! Match started!");
		}
	}
	
	private MatchDetails captureNames(Scanner sc) {
		System.out.println("Enter home team name: ");
		String homeTeam = sc.next();
		System.out.println("Enter away team name: ");
		String awayTeam = sc.next();
		return new MatchDetails(homeTeam, awayTeam, 0, 0);
	}
	
	private boolean validMatch(MatchDetails currentMatch) {
		if (currentMatch.getHomeTeam().equalsIgnoreCase(currentMatch.getAwayTeam())) {
			System.out.println("Both team names should not be same. Please provide different names. Match not started!");
			return false;
		}
		if (currentMatch.findAnyExistingMatch(matches)) {
			System.out.println("Match details already present. Please choose to update match details.");
			return false;
		}
		return true;
	}
	
	private void finishMatch(Scanner sc) {
		if (matchesExist("finish")) {
			int matchSeleted = sc.nextInt() - 1;
			if (matchSeleted < matches.size() && matchSeleted > -1) {
				MatchDetails currentMatch = matches.get(matchSeleted);
				matches.remove(currentMatch);
				System.out.println("Match finished!");
			} else {
				System.out.println("Please select a valid match.");
			}
		} else {
			System.out.println("No Match details found to finish. Please start a match.");
		} 
	}
	
	private boolean matchesExist(String action) {
		if (matches.size() > 0) {
			for (int i = 0; i < matches.size(); i++) {
				System.out.println((i + 1) + ". " + matches.get(i).getHomeTeam() + " - " + matches.get(i).getAwayTeam());
			}
			System.out.println("Enter the match number you want to "+ action+" :");
			return true;
		}
		return false;
	}
	
	private void updateMatch(Scanner sc) {
		if (matchesExist("update")) {
			int matchSeleted = sc.nextInt() - 1;
			if (matchSeleted < matches.size() && matchSeleted > -1) {
				MatchDetails currentMatch = matches.get(matchSeleted);
				currentMatch = capturePoints(sc, currentMatch);
				matches.set(matchSeleted, currentMatch);
			} else {
				System.out.println("Please select a valid match.");
			}
		} else {
			System.out.println("No Match details found to update. Please start a match.");
		} 
	}
	
	private MatchDetails capturePoints(Scanner sc, MatchDetails match) {
		System.out.println("Enter "+ match.getHomeTeam() +" team points: ");
		int homeTeamPoints = sc.nextInt();
		System.out.println("Enter "+ match.getAwayTeam() +" team points: ");
		int awayTeamPoints = sc.nextInt();
		match.setHomeTeamPoints(homeTeamPoints);
		match.setAwayTeamPoints(awayTeamPoints);
		return match;
	}

}
