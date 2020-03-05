package lesson19;

import java.util.Random;

public class Simulation {
	private static final int NUM = 40;
	private static final int NUMTICKS=1000;
	
	Person[] population;
	Country country;
	private Random random = new Random();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Simulation s = new Simulation();
		//s.country.printCountry();
		
		System.out.println();
		s.country.printCountry();
		System.out.println();
		s.country.printStats();
		System.out.println("**********");
		
		for(int k=0;k<NUMTICKS; k++) {
			System.out.println("Time = "+k+" ");
			

			for(Person q: s.population) {
				q.tick();
			}
			for(Person q: s.population) {
				q.infectNeighbors();
			}
			//System.out.println();
			//s.country.printCountry();
			System.out.println();
			s.country.printStats();
			//System.out.println("**********");
		}

	}
	
	public Simulation() {
		this.country = new Country(100,20);
		this.population = new Person[NUM];
		for(int p1=0; p1<NUM; p1++) {
			int i = random.nextInt(country.places.length);
			int j = random.nextInt(country.places[i].length);
			while (country.places[i][j] != null) {
				// loop to make sure it is an open space ...
				i = random.nextInt(country.places.length);
				j = random.nextInt(country.places[i].length);
			}
			
			Person p = new Person(i,j,country);
			this.population[p1] = p;	
			this.country.places[i][j] = p;
			this.population[p1] = p;
		}
		Person p = this.population[0];
		p.infected = true;
	}

}
