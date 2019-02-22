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

public class Panel extends Group {

	public static final int VIEW_DISTANCE = 32;
	public static final double SIZE = Window.WIDTH / VIEW_DISTANCE;
	public static final double SIZE_FACTOR = SIZE / World.UNIT;

	private final GraphicsContext gc;

	public Panel() {
		Canvas canvas = new Canvas(Window.WIDTH, Window.HEIGHT);
		this.getChildren().add(canvas);

		gc = canvas.getGraphicsContext2D();
	}

	public void update() {
		Player player = World.getPlayer();

		final double x = player.getX() * SIZE_FACTOR;
		final double y = Window.HEIGHT - (player.getY() + player.getHeight()) * SIZE_FACTOR;

		final int camX = player.getX() + player.getWidth() / 2;
		final int camY = player.getY() + player.getHeight() / 2;

		final int minX = camX / World.UNIT - VIEW_DISTANCE / 2;
		final int minY = camY / World.UNIT - VIEW_DISTANCE / 2;

		final int maxX = minX + VIEW_DISTANCE + 1;
		final int maxY = minY + VIEW_DISTANCE + 1;

		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				gc.clearRect(0, 0, Window.WIDTH, Window.HEIGHT);

				for (int x = minX; x < maxX; x++) {
					for (int y = minY; y < maxY; y++) {
						if (World.get(x, y).render()) {
							gc.drawImage(BlockTextures.get(World.get(x, y)),
									x * SIZE - (camX * SIZE_FACTOR) + Window.WIDTH / 2,
									Window.HEIGHT - y * SIZE - SIZE + (camY * SIZE_FACTOR) - Window.HEIGHT / 2, SIZE,
									SIZE);
						}
					}
				}

				Image playerTexture = Textures.getPlayerTexture(player.getSide());

				gc.drawImage(playerTexture, x - (camX * SIZE_FACTOR) + Window.WIDTH / 2,
						y + (camY * SIZE_FACTOR) - Window.HEIGHT / 2, World.getPlayer().getWidth() * SIZE_FACTOR,
						World.getPlayer().getHeight() * SIZE_FACTOR);
			}
		});
	}
}
