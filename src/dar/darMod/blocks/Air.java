package dar.darMod.blocks;

import dar.world.Block;

public class Air extends Block {
	@Override
	public String getModID() {
		return "dar";
	}

	@Override
	public String getName() {
		return "air";
	}

	@Override
	public boolean isSolid() {
		return false;
	}

	@Override
	public boolean render() {
		return false;
	}
}
