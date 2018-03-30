package dar.textures;

import java.util.Vector;

import dar.gui.Panel;
import dar.world.Block;
import dar.world.BlockID;
import dar.world.Blocks;
import dar.world.World;
import javafx.scene.image.Image;

public class Textures {
	private static final String PATH = "/resources/images/";

	private static Image playerRightTexture;
	private static Image playerLeftTexture;

	private static Vector<Image> blocTextures = new Vector<Image>();

	public static void loadTextures() {
		playerRightTexture = new Image(Panel.class.getResource(PATH + "playerRight.png").toString(),
				World.getPlayer().getWidth() * Panel.SIZE_FACTOR, World.getPlayer().getHeight() * Panel.SIZE_FACTOR,
				false, true);
		playerLeftTexture = new Image(Panel.class.getResource(PATH + "playerLeft.png").toString(),
				World.getPlayer().getWidth() * Panel.SIZE_FACTOR, World.getPlayer().getHeight() * Panel.SIZE_FACTOR,
				false, true);
		for (Block block : Blocks.getBlocks()) {
			blocTextures.add(new Image(
					Textures.class.getResource(PATH + "blocks/" + String.valueOf(block.getID()) + ".png").toString(),
					Panel.SIZE, Panel.SIZE, false, true));
		}
	}

	public static Image getBlockTexture(BlockID id) {
		return blocTextures.get(id.getID());
	}

	public static Image getPlayerRightTexture() {
		return playerRightTexture;
	}

	public static Image getPlayerLeftTexture() {
		return playerLeftTexture;
	}
}
