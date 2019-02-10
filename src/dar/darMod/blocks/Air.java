package dar.darMod.blocks;

import dar.world.Block;

public class Air extends Block {
	@Override
	public String getModName() {
		return "dar";
	}

	@Override
	public String getName() {
		return "air";
	}

	@Override
	public boolean isAir() {
		return true;
	}

	@Override
	public boolean render() {
		return false;
	}
}
