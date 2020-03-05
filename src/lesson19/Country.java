package lesson19;

public class Country {

	/**
	 * places is a 2d array representing the places a person could be
	 * each entry can contain either a Person or null
	 */
	public Person[][] places;
	
	public Country(int height, int width) {
		this.places = new Person[height][width];
	}
	public Country() {
		this(10,20);
	}
	
	public void printStats() {
		// count number of infected and print
		int count = 0;
		for(int i=0; i<places.length; i++) {
			for(int j=0; j<places[i].length; j++) {
				if (places[i][j] != null && places[i][j].infected) {
				  count++;	
				}
			}
		}
		System.out.println("infected: "+ count);
	}
	
	public void printCountry() {

		for(int i=0; i<places.length; i++) {
			for(int j=0; j<places[i].length; j++) {
				Person p = places[i][j];
				String s = "-";
				if (p!=null) {
					s = p.toString();
				}
				System.out.printf("%4s ",s);
			}
			System.out.println();
		}
	}

}
