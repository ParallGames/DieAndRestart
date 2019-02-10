package dar.textures;

import java.util.HashMap;

import dar.world.Block;
import javafx.scene.image.Image;

public class BlockTextures {
	private static final HashMap<Block, Image> textures = new HashMap<>();

	public static void add(Block target, Image texture) {
		if (!target.render()) {
			throw new RuntimeException(
					"The " + target.getFullName() + " block isn't rendered. it's useless to give it a textre.");
		}

		if (textures.containsKey(target)) {
			throw new RuntimeException("The " + target.getFullName() + " block already has a texture.");
		}

		textures.put(target, texture);
	}

	public static Image get(Block target) {
		Image texture = textures.get(target);

		if (texture == null) {
			throw new RuntimeException("No texture found for " + target.getFullName() + " block.");
		}

		return texture;
	}
}
