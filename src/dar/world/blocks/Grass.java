package dar.world.blocks;

import dar.world.Block;
import dar.world.BlockID;

public class Grass extends Block {
	@Override
	public BlockID getID() {
		return BlockID.GRASS;
	}

	@Override
	public boolean isAir() {
		return false;
	}
}
