package lesson19;

public class Country {
	public static final int WIDTH = 10;
	public static final int HEIGHT = 10;
	/**
	 * places is a 2d array representing the places a person could be
	 * each entry can contain either a Person or null
	 */
	public Person[][] places;
	
	public Country() {
		places = new Person[WIDTH][HEIGHT];
	}
	
	public void printCountry() {

		for(int i=0; i<HEIGHT; i++) {
			for(int j=0; j<WIDTH; j++) {
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
