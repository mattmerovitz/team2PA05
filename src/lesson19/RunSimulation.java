//Team 2 (Matthew Merovitz & Max Melnikas)
//PA05

package lesson19;

import java.util.Random;
/**
 *
 * @author tim
 *
 */

public class RunSimulation {
	// the maximum number of days the simulation will run
	private static int MAX_TICKS=1000;

	private Random random = new Random();

	public static void main(String[] args) {
		// first we get the simulation parameters
		// from the command line

		int width = Integer.parseInt(args[0]);
		int height = Integer.parseInt(args[1]);
		int numStayHome = Integer.parseInt(args[2]);
		int numEssential = Integer.parseInt(args[3]);
		int numSkeptic = Integer.parseInt(args[4]);
		int numFrequentFlier = Integer.parseInt(args[5]);
		int numMoveWeekly = Integer.parseInt(args[6]);
		int day = 0;

		// next we create the population and the country

		AnalyzeSimulation analyze = new AnalyzeSimulation();
		double numberRuns = analyze.numberRuns;

		for (int i = 0; i < numberRuns; i++){//for loop for AnalyzeSimulation; change the number of times it runs it AnalyzeSimulation.numberRuns

			//Nothing from lines 37-57 was changed from given code
			Population population;
			population = new MixedPopulation(numStayHome, numEssential, numSkeptic, numFrequentFlier, numMoveWeekly);
			population.createPeople();
			Country country = new Country(width,height);
			country.population = population;
			population.placePeople(country);

			System.out.println("Initial State of the Country");
			country.printCountry();

			System.out.println("\nTracking the Infection");
			for(int k=0;k<MAX_TICKS; k++) {
				country.simulateOneStep();
				country.printState(k);
				day++;

				if (country.numInfected==0) {
					break;
				}
			}

		System.out.println("\nFinal State of the Country");//
		country.printCountry();
		analyze.statistics(country.totalInfected, country.finalCounter, day);
		country.totalInfected = 0;
		country.finalCounter = 0;
		day = 0;
		}
		analyze.finalStats();
	}

}
