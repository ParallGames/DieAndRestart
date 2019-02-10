package dar.gui;

import dar.player.Player;
import dar.textures.BlockTextures;
import dar.textures.Textures;
import dar.world.World;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Panel extends Group {
	public static final double SIZE = Window.HEIGHT / World.HEIGHT;
	public static final double SIZE_FACTOR = SIZE / 1000;

	private final GraphicsContext gc;

	public Panel() {
		Canvas canvas = new Canvas(Window.WIDTH, Window.HEIGHT);
		this.getChildren().add(canvas);

		gc = canvas.getGraphicsContext2D();
		gc.setFill(Color.rgb(255, 255, 255));
	}

	public void update() {
		double x = World.getPlayer().getX() * SIZE_FACTOR;
		double y = Window.HEIGHT - (World.getPlayer().getY() + World.getPlayer().getHeight()) * SIZE_FACTOR;

		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				gc.clearRect(0, 0, Window.WIDTH, Window.HEIGHT);

				for (int x = 0; x < World.WIDTH; x++) {
					for (int y = 0; y < World.HEIGHT; y++) {
						if (World.get(x, y).render()) {
							gc.drawImage(BlockTextures.get(World.get(x, y)), x * SIZE, Window.HEIGHT - y * SIZE - SIZE,
									SIZE, SIZE);
						}
					}
				}

				Player player = World.getPlayer();

				Image playerTexture = Textures.getPlayerTexture(player.getSide());

				gc.drawImage(playerTexture, x, y, World.getPlayer().getWidth() * SIZE_FACTOR,
						World.getPlayer().getHeight() * SIZE_FACTOR);
			}
		});
	}
}
