package lesson19;
import java.util.Random;

public class Person {
	// here is the position of the person in the country
	static int counter=1;
	int x;
	int y;
	int id = 0;
	boolean infected = false;
	boolean exposed = false; // after being exposed, one gets infect in next tick
	Country country;
	private Random random = new Random();
	double infectionProb = 1.0;

	

	
	public Person(int x,int y,Country country) {
		this.x=x;
		this.y=y;
		this.id = Person.counter++;
		this.country=country;
	}
	
	public String toString() {
		return (this.infected?"+":" ")+this.id;
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
		if (this.exposed) {
			this.infected = true;
		}
	}

	
	private void infect(Person p) {
		// possibly become infected if you are near someone infected
		if (Math.random()<=this.infectionProb) {
			if (!this.infected) {
				this.exposed = true;
				System.out.printf("infected! %3d %3d %3d by %3d %3d %3d%n",
						this.id,this.x,this.y,p.id,p.x,p.y);
			}
		}
	}
	
	public void infectNeighbors() {
		if (this.infected) {
			for(int i=this.x-1; i<=this.x+1; i++) {
				for(int j=this.y-1; j<this.y+1; j++) {
					if (i>=0 && i<country.places.length 
					 && j >=0 && j<country.places[0].length ) {
						Person p = country.places[i][j];
						if (p != null  && this.infected) {
							p.infect(this);
						}
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
		if (a<0 || a>=country.places.length || b<0 
				|| b>= country.places[0].length) {
			return false;
		}else if (country.places[a][b] !=null) {
			return false;
		}else {
			return true;
		}
		
	}

}
