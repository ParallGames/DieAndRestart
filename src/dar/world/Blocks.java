package dar.world;

import java.util.Vector;

import dar.world.blocks.Air;
import dar.world.blocks.Grass;

public class Blocks {
	private static final Vector<Block> blocks = new Vector<Block>();

	public static void loadBlocks() {
		blocks.add(new Air());

		blocks.add(new Grass());
	}

	public static Vector<Block> getBlocks() {
		return blocks;
	}

	public static Block get(BlockID id) {
		return blocks.get(id.getID());
	}
}
