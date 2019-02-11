package dar.world;

public abstract class Block {
	public abstract String getModID();

	public abstract String getName();

	public abstract boolean isSolid();

	public abstract boolean render();

	public final String getFullName() {
		return getModID() + ":" + getName();
	}

	public final int getID() {
		return getFullName().hashCode();
	}
}
