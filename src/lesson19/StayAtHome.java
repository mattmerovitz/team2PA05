package lesson19;

public class StayAtHome extends Person{

	public StayAtHome() {
		// TODO Auto-generated constructor stub
		super();
	}

	public void tick() {
		// don't move if sick
    if (!this.infected){
      this.tryToMove();
    }

    this.checkForInfection();
	}

}
