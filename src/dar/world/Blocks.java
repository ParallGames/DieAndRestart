package dar.world;

import java.util.ArrayList;
import java.util.List;

import dar.world.blocks.Air;
import dar.world.blocks.Grass;

public class Blocks {
	private static final ArrayList<Block> blocks = new ArrayList<>();

	public static void loadBlocks() {
		blocks.add(new Air());

		blocks.add(new Grass());
	}

	public static List<Block> getBlocks() {
		return blocks;
	}

	public static Block get(BlockID id) {
		return blocks.get(id.getID());
	}
}
