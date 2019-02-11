package dar.darMod.blocks;

import dar.world.Block;

public class Grass extends Block {
	@Override
	public String getModID() {
		return "dar";
	}

	@Override
	public String getName() {
		return "grass";
	}

	@Override
	public boolean isSolid() {
		return true;
	}

	@Override
	public boolean render() {
		return true;
	}
}
