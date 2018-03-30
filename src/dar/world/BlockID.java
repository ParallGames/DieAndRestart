package dar.world;

public enum BlockID {
	AIR(0), GRASS(1);

	private int id;

	BlockID(int id) {
		this.id = id;
	}

	public int getID() {
		return id;
	}
}
