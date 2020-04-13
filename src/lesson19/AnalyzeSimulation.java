//Team 2 (Matthew Merovitz & Max Melnikas)
//PA05

package lesson19;

public class AnalyzeSimulation {

  double numberRuns = 100; //Change this constant to change the number of times to run the simulation.
  double totalNumInfected = 0; //Average stat counter
  double totalPeakInfect = 0;//Average stat counter
  double totalDay = 0;//Average stat counter

  public AnalyzeSimulation(){

    //these set the variables for the class
    this.numberRuns = numberRuns;
    this.totalNumInfected = totalNumInfected;
    this.totalPeakInfect = totalPeakInfect;
    this.totalDay = totalDay;

  }

  public void statistics (double numInfected, double peakInfect, double day){

    day--; //makes the day variable correct
    System.out.println("\nNumber of days: "+day);//prints number of days
    System.out.println("Peak Infection Level: "+peakInfect);//prints most people infected at once
    System.out.println("Number Infected: "+numInfected+ "\n\n--------------------------------------------------------------------------\n"); //prints total number infected
    this.totalNumInfected += numInfected;//Counts total for average stats later
    this.totalPeakInfect += peakInfect;//Counts total for average stats later
    this.totalDay += day;//Counts total for average stats later

  }

  public void finalStats () {

    this.totalPeakInfect = this.totalPeakInfect/this.numberRuns; //Average
    this.totalNumInfected = this.totalNumInfected/this.numberRuns; //Average
    this.totalDay = this.totalDay/this.numberRuns;//Average
    System.out.println("Average Number of Days: "+this.totalDay);//Prints average
    System.out.println("Average Peak Infection Level: "+this.totalPeakInfect);//Prints average
    System.out.println("Average Number Infected: "+this.totalNumInfected);//Prints average

  }

}
