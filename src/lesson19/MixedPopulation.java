package lesson19;

public class MixedPopulation extends Population{
  int numShelterInPlace;
  int numEssential;
  int numOthers;
  int freqFlier;

  public MixedPopulation(int numShelterInPlace, int numEssential, int numOthers, int freqFlier){
    super(numShelterInPlace + numEssential + numOthers + freqFlier);
    this.numShelterInPlace = numShelterInPlace;
    this.numEssential = numEssential;
    this.numOthers = numOthers;
    this.freqFlier = freqFlier;

  }

  public void createPeople(){
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
  }
}
