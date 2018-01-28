package dar;

import dar.gui.Window;
import dar.world.Blocks;
import dar.world.World;
import javafx.application.Application;

public class Main {
	public static void main(String args[]) {
		World.set(5, 0, 1);
		World.set(5, 3, 1);
		Blocks.loadBlocks();
		Application.launch(Window.class, args);
	}
}