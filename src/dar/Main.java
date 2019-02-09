package dar;

import dar.gui.Window;
import dar.textures.Textures;
import dar.world.Block;
import dar.world.Blocks;
import dar.world.blocks.Air;
import dar.world.blocks.Grass;
import javafx.application.Application;
import javafx.scene.image.Image;

public class Main {
	public static void main(String[] args) {
		final Block air = new Air();
		final Block grass = new Grass();

		Blocks.addBlock(air);
		Blocks.addBlock(grass);

		Textures.addBlockTexture(
				new Image(Main.class.getResourceAsStream("/resources/images/blocks/GRASS.png"), 64, 64, false, false),
				grass);

		Application.launch(Window.class);
	}
}