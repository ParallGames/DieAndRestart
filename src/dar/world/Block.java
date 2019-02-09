package dar.world;

public abstract class Block {
	public abstract String getModName();

	public abstract String getName();

	public abstract boolean isAir();

	public abstract boolean render();

	public final String getFullName() {
		return getModName() + ":" + getName();
	}

	public final int getID() {
		return getFullName().hashCode();
	}
}
