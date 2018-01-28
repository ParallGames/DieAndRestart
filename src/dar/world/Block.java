package dar.world;

public abstract class Block {
	protected int id;
	protected boolean isAir;

	public int getId() {
		return id;
	}

	public boolean isAir() {
		return isAir;
	}
}
