package dar;

import dar.gui.Window;
import dar.modding.ModLoader;
import dar.textures.Textures;
import javafx.application.Application;

public class Main {
	public static void main(String[] args) {
		ModLoader.loadMods();

		Textures.loadTextures();

		Application.launch(Window.class);
	}
}