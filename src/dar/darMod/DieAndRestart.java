package dar.darMod;

import dar.darMod.blocks.DARBlocks;
import dar.modding.Mod;
import dar.textures.BlockTextures;
import dar.world.Blocks;
import javafx.scene.image.Image;

public class DieAndRestart implements Mod {
	@Override
	public String getModName() {
		return "Die and restart";
	}

	@Override
	public String getModID() {
		return "dar";
	}

	@Override
	public void load() {
		Blocks.addBlock(DARBlocks.AIR);
		Blocks.addBlock(DARBlocks.GRASS);

		BlockTextures.add(DARBlocks.GRASS, new Image(
				DieAndRestart.class.getResourceAsStream("/resources/textures/blocks/grass.png"), 64, 64, false, false));
	}
}
