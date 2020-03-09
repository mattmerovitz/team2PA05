package lesson19;

public class StayAtHome extends Person{

	
	public StayAtHome(int x,int y,Country country) {
		super(x,y,country);
	}

	public void tick() {
		// don't move if sick
    if (!this.infected){
      this.tryToMove();
    }

    this.checkForInfection();
	}

}
