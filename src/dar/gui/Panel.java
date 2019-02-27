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
	private final GraphicsContext gc;
	private final Canvas canvas;

	private static final int VIEW_DISTANCE = 16;

	public Panel() {
		canvas = new Canvas();
		this.getChildren().add(canvas);

		gc = canvas.getGraphicsContext2D();
	}

	public void update(double windowWidth, double windowHeight) {
		final Player player = World.getPlayer();

		final double SIZE = Math.max(windowWidth, windowHeight) / (VIEW_DISTANCE * 2D);
		final double SIZE_FACTOR = SIZE / World.UNIT;

		final double playerX = player.getX() * SIZE_FACTOR;
		final double playerY = windowHeight - (player.getY() + player.getHeight()) * SIZE_FACTOR;

		final int camX = player.getX() + player.getWidth() / 2;
		final int camY = player.getY() + player.getHeight() / 2;

		final int minX = camX / World.UNIT - VIEW_DISTANCE;
		final int minY = camY / World.UNIT - VIEW_DISTANCE;

		final int maxX = minX + VIEW_DISTANCE * 2;
		final int maxY = minY + VIEW_DISTANCE * 2;

		final double translateX = -camX * SIZE_FACTOR + windowWidth / 2;
		final double translateY = camY * SIZE_FACTOR - windowHeight / 2;

		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				canvas.setWidth(windowWidth);
				canvas.setHeight(windowHeight);

				gc.clearRect(0, 0, windowWidth, windowHeight);

				for (int x = minX; x <= maxX; x++) {
					for (int y = minY; y <= maxY; y++) {
						if (World.get(x, y).render()) {
							gc.drawImage(BlockTextures.get(World.get(x, y)), x * SIZE + translateX,
									windowHeight - (y + 1) * SIZE + translateY, SIZE, SIZE);
						}
					}
				}

				Image playerTexture = Textures.getPlayerTexture(player.getSide());

				gc.drawImage(playerTexture, playerX + translateX, playerY + translateY, player.getWidth() * SIZE_FACTOR,
						player.getHeight() * SIZE_FACTOR);
			}
		});
	}
}
