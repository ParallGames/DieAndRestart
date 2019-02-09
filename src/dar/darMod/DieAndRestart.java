package dar.darMod;

import dar.Main;
import dar.modding.Mod;
import dar.textures.Textures;
import dar.world.Block;
import dar.world.Blocks;
import dar.world.blocks.Air;
import dar.world.blocks.Grass;
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
		final Block air = new Air();
		final Block grass = new Grass();

		Blocks.addBlock(air);
		Blocks.addBlock(grass);

		Textures.addBlockTexture(grass,
				new Image(Main.class.getResourceAsStream("/resources/images/blocks/GRASS.png"), 64, 64, false, false));
	}

}
