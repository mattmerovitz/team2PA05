//Team 2 (Matthew Merovitz & Max Melnikas)
//PA05

package lesson19;

public class MoveWeekly extends Person {
  public int daysAtHome = 0;

  public MoveWeekly() {
    super();//calls super
    this.daysAtHome = daysAtHome;//sets daysAtHome

  }

  public void tryToMove() {

    int goOut = random.nextInt(7)+1;//Randomizes number

    if (goOut == 7 || daysAtHome == 7) {//the person goes out if the random number is 7 or they have been home for 7 days

      daysAtHome = 0;//Resets daysAtHome
      super.tryToMove();//moves person

    }

    else {

      daysAtHome++;//counts that they did not go out that day

    }

	}

}
