package dar.world;

import java.util.HashMap;

public class Blocks {
	private static final HashMap<Integer, Block> blocks = new HashMap<>();

	public static void addBlock(Block block) {
		blocks.put(block.getID(), block);
	}

	public static Block get(int id) {
		return blocks.get(id);
	}

	public static Block get(String fullName) {
		return get(fullName.hashCode());
	}
}
