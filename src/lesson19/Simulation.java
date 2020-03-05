package lesson19;

import java.util.Random;

public class Simulation {
	
	Person[] population;
	Country country;
	private Random random = new Random();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Simulation s = new Simulation();
		s.country.printCountry();
		for(int k=0;k<10; k++) {
			System.out.println("Time = "+k);
			
			for(Person q: s.population) {
				q.tick();
			}
			s.country.printCountry();
			System.out.println("\n\n**********\n\n");
		}

	}
	
	public Simulation() {
		this.country = new Country();
		this.population = new Person[10];
		for(int i=0; i<10; i++) {
			int j = random.nextInt(10);
			Person p = new Person(i,j,country);
			this.population[i] = p;	
			this.country.places[i][j] = p;
			this.population[i] = p;
		}
	}

}
