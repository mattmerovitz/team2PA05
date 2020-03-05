package lesson19;
import java.util.Random;

public class Person {
	// here is the position of the person in the country
	static int counter=1;
	int x;
	int y;
	int id = 0;
	boolean infected = false;
	Country country;
	private Random random = new Random();
	double infectionProb = 0.001;

	

	
	public Person(int x,int y,Country country) {
		this.x=x;
		this.y=y;
		this.id = Person.counter++;
		this.country=country;
	}
	
	public String toString() {
		return (this.infected?"I":" ")+this.id;
	}
	
	/**
	 * this simulates the persons movement in one unit of time.
	 * it will change this.x and this.y
	 * We'll first just randomly try to move one step 
	 */
	public void tick() {
		int dx = random.nextInt(3)-1; // -1,0,1
		int dy = random.nextInt(3)-1; // -1,0,1
		if (isOK(this.x+dx, this.y+dy,this.country)) {
			this.moveTo(this.x+dx, this.y+dy);		
		}	
		if (this.infected) {
			this.infectNeighbors();
		}
	}
	
	private void infect() {
		// possibly become infected if you are near someone infected
		if (Math.random()<=this.infectionProb) {
			this.infected = true;
		}
	}
	
	private void infectNeighbors() {
		for(int i=this.x-1; i<=this.x+1; i++) {
			for(int j=this.y-1; j<this.y+1; j++) {
				if (i>=0 && i<country.WIDTH && j >=0 && j<country.HEIGHT ) {
					Person p = country.places[i][j];
					if (p != null  && this.infected) {
						p.infect();
					}
				}
			}
		}
	}
	
	private void moveTo(int a, int b) {
		this.country.places[this.x][this.y]=null;
		this.country.places[a][b] = this;
		this.x = a;
		this.y = b;
	}
	
	private boolean isOK(int a, int b,Country country) {
		if (a<0 || a>=country.WIDTH || b<0 || b>= country.HEIGHT) {
			return false;
		}else if (country.places[a][b] !=null) {
			return false;
		}else {
			return true;
		}
		
	}

}
