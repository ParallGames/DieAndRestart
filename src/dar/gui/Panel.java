package dar.gui;

import dar.player.Player;
import dar.textures.Textures;
import dar.world.World;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Panel extends Group {
	public static final double SIZE = Window.HEIGHT / World.HEIGHT;
	public static final double SIZE_FACTOR = SIZE / 1000;

	GraphicsContext gc;

	public Panel() {
		Canvas canvas = new Canvas(Window.WIDTH, Window.HEIGHT);
		this.getChildren().add(canvas);

		gc = canvas.getGraphicsContext2D();
		gc.setFill(Color.rgb(255, 255, 255));
	}

	public void update() {
		double x = Player.getX() * SIZE_FACTOR;
		double y = Window.HEIGHT - (Player.getY() + Player.getHeight()) * SIZE_FACTOR;

		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				gc.clearRect(0, 0, Window.WIDTH, Window.HEIGHT);

				for (int x = 0; x < World.WIDTH; x++) {
					for (int y = 0; y < World.HEIGHT; y++) {
						if (World.get(x, y) != 0) {
							gc.drawImage(Textures.getBlockTexture(World.get(x, y)), x * SIZE,
									Window.HEIGHT - y * SIZE - SIZE);
						}
					}
				}
				if(Player.getDirection()) {
					gc.drawImage(Textures.getPlayerLeftTexture(), x, y);
				} else {
					gc.drawImage(Textures.getPlayerRightTexture(), x, y);
				}
			}
		});
	}
}
