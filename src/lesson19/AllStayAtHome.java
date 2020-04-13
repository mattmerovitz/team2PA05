//Team 2 (Matthew Merovitz & Max Melnikas)
//PA05

package lesson19;

public class AllStayAtHome extends Population{

  public AllStayAtHome(int n){
    super(n);//calls super
  }

  public void createPeople(){
    for(int i=0; i<this.people.length; i++){
      this.addPerson(new StayAtHome()); //stays at home no matter what by order
    }
  }
}
