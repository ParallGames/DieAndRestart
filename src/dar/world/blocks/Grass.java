package dar.world.blocks;

import dar.world.Block;
import dar.world.BlockID;

public class Grass extends Block {
	public BlockID getID() {
		return BlockID.GRASS;
	}

	public boolean isAir() {
		return false;
	}
}
