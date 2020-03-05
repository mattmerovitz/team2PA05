package lesson19;
import java.util.Random;

public class Person {
	// here is the position of the person in the country
	static int counter=1;
	int x;
	int y;
	int id = 0;
	Country country;
	private Random random = new Random();

	
	public Person(int x,int y,Country country) {
		this.x=x;
		this.y=y;
		this.id = Person.counter++;
		this.country=country;
	}
	
	public String toString() {
		return ""+this.id;
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
