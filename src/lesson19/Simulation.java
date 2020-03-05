package lesson19;

import java.util.Random;

public class Simulation {
	private static final int NUM = 30;
	private static final int NUMTICKS=100;
	
	Person[] population;
	Country country;
	private Random random = new Random();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Simulation s = new Simulation();
		s.country.printCountry();
		for(int k=0;k<NUMTICKS; k++) {
			System.out.print("Time = "+k+" ");
			
			for(Person q: s.population) {
				q.tick();
			}
			//s.country.printCountry();
			s.country.printStats();
			//System.out.println("\n\n**********\n\n");
		}

	}
	
	public Simulation() {
		this.country = new Country();
		this.population = new Person[NUM];
		for(int p1=0; p1<NUM; p1++) {
			int i = random.nextInt(country.HEIGHT);
			int j = random.nextInt(country.WIDTH);
			// really want a loop to make sure it is an open space ...
			Person p = new Person(i,j,country);
			this.population[p1] = p;	
			this.country.places[i][j] = p;
			this.population[p1] = p;
		}
		Person p = this.population[0];
		p.infected = true;
	}

}
