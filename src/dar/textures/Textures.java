package dar.textures;

import dar.entities.Side;
import dar.gui.Panel;
import javafx.scene.image.Image;

public class Textures {
	private static final String PATH = "/resources/textures/";

	private static Image playerRightTexture;
	private static Image playerLeftTexture;

	public static void loadTextures() {
		playerRightTexture = new Image(Panel.class.getResourceAsStream(PATH + "playerRight.png"), 13 * 4, 23 * 4, false,
				false);
		playerLeftTexture = new Image(Panel.class.getResourceAsStream(PATH + "playerLeft.png"), 13 * 4, 23 * 4, false,
				false);
	}

	public static Image getPlayerTexture(Side side) {
		if (side == Side.LEFT) {
			return playerLeftTexture;
		} else {
			return playerRightTexture;
		}
	}
}
