public class Item {
	private int value;
	private String name;
	private double weight;
	private int rarity;

	public Item() {
		name = "dirt";
		value = 0;
		weight = 1;
		rarity = 0;
	}

	public Item(String n, int v, double w, int r) {
		name = n;
		value = v;
		weight = w;
		rarity = r;
	}

	public int getValue() {
		return value;
	}

	public String getName() {
		return name;
	}

	public double getWeight() {
		return weight;
	}

	public int getRarity() {
		return rarity;
	}


}