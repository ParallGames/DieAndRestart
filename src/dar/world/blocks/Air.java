package dar.world.blocks;

import dar.world.Block;
import dar.world.BlockID;

public class Air extends Block {
	@Override
	public BlockID getID() {
		return BlockID.AIR;
	}

	@Override
	public boolean isAir() {
		return true;
	}
}
