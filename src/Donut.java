import java.util.ArrayList;

public class Donut {

	private String id;
	private String type;
	private String name;
	ArrayList<Batter> batters = new ArrayList<>();
	ArrayList<Topping> toppings = new ArrayList<>();

	public Donut(String id, String type, String name, ArrayList<Batter> batters, ArrayList<Topping> toppings) {
		super();
		this.id = id;
		this.type = type;
		this.name = name;
		this.batters = batters;
		this.toppings = toppings;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Batter> getBatters() {
		return batters;
	}

	public void setBatters(ArrayList<Batter> batters) {
		this.batters = batters;
	}

	public ArrayList<Topping> getToppings() {
		return toppings;
	}

	public void setToppings(ArrayList<Topping> toppings) {
		this.toppings = toppings;
	}

	@Override
	public String toString() {
		String text = "";
		text += "Donut: \nid:" + id + ", type: " + type + ", name: " + name + "\nbatters:";
		for (Batter batter : batters) {
			text += batter + " ";
		}
		text += "\ntoppings: ";
		for (Topping topping : toppings) {
			text += topping + " ";
		}

		return text;
	}

}
