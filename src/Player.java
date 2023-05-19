
public class Player {
	
	private String name; //player name
	private int age; //player age
	private double height; //player height
	
	
	public Player(String name,int age,double height) {  //main constructor
		this.name=name;
		this.age=age;
		this.height=height;
	}
	
	// getters that the program use them for class player
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public double getheight() {
		return height;
	}
	
	
}
