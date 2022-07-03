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
					printOption(1);
					break;
				}
				case 2 -> {
					printOption(2);
					break;
				}
				case 3 -> {
					printOption(3);
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
				System.out.println("Please enter an integer value between 1 and " + options.size());
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

}
