package dar.textures;

import javafx.scene.image.Image;

public class EntityTexture {
	private Image left;
	private Image right;

	public EntityTexture(Image left, Image right) {
		this.left = left;
		this.right = right;
	}

	public Image getLeft() {
		return left;
	}

	public Image getRight() {
		return right;
	}
}
