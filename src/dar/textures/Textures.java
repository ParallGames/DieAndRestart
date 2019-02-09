package dar.textures;

import java.util.HashMap;

import dar.gui.Panel;
import dar.world.Block;
import javafx.scene.image.Image;

public class Textures {
	private static final String PATH = "/resources/images/";

	private static Image playerRightTexture;
	private static Image playerLeftTexture;

	private static HashMap<Block, Image> blockTextures = new HashMap<>();

	public static void loadTextures() {
		playerRightTexture = new Image(Panel.class.getResourceAsStream(PATH + "playerRight.png"), 13 * 4, 23 * 4, false,
				false);
		playerLeftTexture = new Image(Panel.class.getResourceAsStream(PATH + "playerLeft.png"), 13 * 4, 23 * 4, false,
				false);
	}

	public static void addBlockTexture(Block target, Image texture) {
		if (!target.render()) {
			throw new RuntimeException(
					"The " + target.getFullName() + " block isn't rendered. it's useless to give it a textre.");
		}

		if (blockTextures.containsKey(target)) {
			throw new RuntimeException("The " + target.getFullName() + " block already has a texture.");
		}

		blockTextures.put(target, texture);
	}

	public static Image getBlockTexture(Block target) {
		Image texture = blockTextures.get(target);

		if (texture == null) {
			throw new RuntimeException("No texture found for " + target.getFullName() + " block.");
		}

		return texture;
	}

	public static Image getPlayerRightTexture() {
		return playerRightTexture;
	}

	public static Image getPlayerLeftTexture() {
		return playerLeftTexture;
	}
}
