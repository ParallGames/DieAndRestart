package dar.world.blocks;

import dar.world.Block;
import dar.world.BlockID;

public class Air extends Block {
	public BlockID getID() {
		return BlockID.AIR;
	}

	public boolean isAir() {
		return true;
	}
}
