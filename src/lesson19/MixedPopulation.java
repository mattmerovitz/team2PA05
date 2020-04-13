//Team 2 (Matthew Merovitz & Max Melnikas)
//PA05

package lesson19;

public class MixedPopulation extends Population{
  //Sets integers
  int numShelterInPlace;
  int numEssential;
  int numOthers;
  int freqFlier;
  int moveWeekly;

  public MixedPopulation(int numShelterInPlace, int numEssential, int numOthers, int freqFlier, int moveWeekly){
    //Calls on super and sets integers to the number of people of different classes
    super(numShelterInPlace + numEssential + numOthers + freqFlier + moveWeekly);
    this.numShelterInPlace = numShelterInPlace;
    this.numEssential = numEssential;
    this.numOthers = numOthers;
    this.freqFlier = freqFlier;
    this.moveWeekly = moveWeekly;

  }

  public void createPeople(){
    //adds people to the person class
    for(int i=0; i<this.numShelterInPlace; i++){
      this.addPerson(new StayAtHome());
    }
    for(int i=0; i<this.numEssential; i++){
      this.addPerson(new StayAtHomeIfSick());
    }
    for(int i=0; i<this.numOthers; i++){
      this.addPerson(new Person());
    }
    for(int i=0; i<this.freqFlier; i++){
      this.addPerson(new FrequentFlier());
    }
    for(int i=0; i<this.moveWeekly; i++){
      this.addPerson(new MoveWeekly());
    }
  }
}
