package dar;

import dar.gui.Window;
import dar.modding.ModLoader;
import javafx.application.Application;

public class Main {
	public static void main(String[] args) {
		ModLoader.loadMods();

		Application.launch(Window.class);
	}
}