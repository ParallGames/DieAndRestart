package dar.textures;

import java.util.Vector;

import dar.gui.Panel;
import dar.player.Player;
import dar.world.Block;
import dar.world.Blocks;
import javafx.scene.image.Image;

public class Textures {
	private static Image playerTexture;

	private static Vector<Image> blocTextures = new Vector<Image>();

	public static void loadTextures() {
		playerTexture = new Image(Panel.class.getResource("/resources/images/player.png").toString(),
				Player.getWidth() * Panel.SIZE_FACTOR, Player.getHeight() * Panel.SIZE_FACTOR, false, true);
		for (Block block : Blocks.getBlocks()) {
			blocTextures.add(new Image(Textures.class
					.getResource("/resources/images/block" + String.valueOf(block.getId()) + ".png").toString(),
					Panel.SIZE, Panel.SIZE, false, true));
		}
	}

	public static Image getBlockTexture(int id) {
		return blocTextures.get(id);
	}

	public static Image getPlayerTexture() {
		return playerTexture;
	}
}
