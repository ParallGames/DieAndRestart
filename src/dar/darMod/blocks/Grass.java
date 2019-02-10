package dar.darMod.blocks;

import dar.world.Block;

public class Grass extends Block {
	@Override
	public String getModName() {
		return "dar";
	}

	@Override
	public String getName() {
		return "grass";
	}

	@Override
	public boolean isAir() {
		return false;
	}

	@Override
	public boolean render() {
		return true;
	}
}
