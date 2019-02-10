package dar.world;

import java.util.HashMap;

public class Blocks {
	private static final HashMap<Integer, Block> blocks = new HashMap<>();

	public static void addBlock(Block block) {
		if (blocks.containsKey(block.getID())) {
			throw new RuntimeException("The " + block.getFullName() + " block is already registered.");
		}

		blocks.put(block.getID(), block);
	}

	public static Block get(int id) {
		Block block = blocks.get(id);

		if (block == null) {
			throw new RuntimeException("No block found for the id " + id + ".");
		}

		return block;
	}
}
