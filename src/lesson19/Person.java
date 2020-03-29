package lesson19;
import java.util.Random;

public class Person {
  // the persons fate depends on some random variables...
  private Random random = new Random();

  // we use the counter to give each Person a unique id
	static int counter=1;
  int id = 0;

  // Next we need the location of the Person
  // the Country variable allows the user to "look around"
	int x;
	int y;
	Country country;


  // next we record their infection status
	boolean infected = false;
	boolean exposed = false; // after being exposed, one gets infect in next tick
	boolean recovered = false;
	double infectionProb = 0.5;  // probability of being infect when near a sick person
	int age = 0;  // their age in ticks
	int infectionTime = -1;  // -1 means they haven't yet been infected
	int recoveryTime = 21; // they are not infectious after recovery





	public Person(int x,int y,Country country) {
		this.x=x;
		this.y=y;
		this.id = Person.counter++;
		this.country=country;
	}

	public String toString() {
		String r = " ";
		if (this.recovered) {
			r="r";
		} else if (this.infected) {
			r="X";
		} else if (this.exposed) {
			r="E";
		} else {
			r="+";
		}
		return r;
	}

	/**
	 * this simulates the persons movement in one unit of time.
	 * it will change this.x and this.y
	 * We'll first just randomly try to move one step
	 */
	public void tick() {

    this.tryToMove();
    this.checkForInfection();

	}

  void tryToMove(){
    int dx = random.nextInt(3)-1; // -1,0,1
    int dy = random.nextInt(3)-1; // -1,0,1
    if (isOK(this.x+dx, this.y+dy,this.country)) {
      this.moveTo(this.x+dx, this.y+dy);
    }
  }

  void checkForInfection(){
    if (this.exposed && ! this.infected) {
			this.infected = true;
			this.infectionTime = this.age;
		}
		this.age++;
		if (infected && !this.recovered && (this.age - this.infectionTime > this.recoveryTime)) {
			this.recovered = true;
			System.out.printf("recovered: %3d %3d %3d %n",this.id,this.x,this.y);
		}
  }


	void infect(Person p) {
		// possibly become infected if you are near someone infected
		if (Math.random()<=this.infectionProb) {
			if (!this.infected) {
				this.exposed = true;
				System.out.printf("infected! %3d %3d %3d by %3d %3d %3d%n",
						this.id,this.x,this.y,p.id,p.x,p.y);
			}
		}
	}

	void infectNeighbors() {
		if (this.infected && (this.age -this.infectionTime < this.recoveryTime)) {
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

	void moveTo(int a, int b) {
		this.country.places[this.x][this.y]=null;
		this.country.places[a][b] = this;
		this.x = a;
		this.y = b;
	}

	boolean isOK(int a, int b,Country country) {
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
