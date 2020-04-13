//Team 2 (Matthew Merovitz & Max Melnikas)
//PA05

package lesson19;

public class StayAtHomeIfSick extends Person{


	public StayAtHomeIfSick() {
		super();
	}

	public void tryToMove() {

    if (!this.infected){
      super.tryToMove();//move only if not infected
    }
	}

}
