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
		canvas = new Canvas(Window.getWidth(), Window.getHeight());
		this.getChildren().add(canvas);

		gc = canvas.getGraphicsContext2D();
	}

	public void update() {
		Player player = World.getPlayer();

		final double SIZE = Math.max(Window.getHeight(), Window.getWidth()) / VIEW_DISTANCE;
		final double SIZE_FACTOR = SIZE / World.UNIT;

		final double x = player.getX() * SIZE_FACTOR;
		final double y = Window.getHeight() - (player.getY() + player.getHeight()) * SIZE_FACTOR;

		final int camX = player.getX() + player.getWidth() / 2;
		final int camY = player.getY() + player.getHeight() / 2;

		final int minX = camX / World.UNIT - VIEW_DISTANCE / 2;
		final int minY = camY / World.UNIT - VIEW_DISTANCE / 2;

		final int maxX = minX + VIEW_DISTANCE;
		final int maxY = minY + VIEW_DISTANCE;

		final double translateX = -camX * SIZE_FACTOR + Window.getWidth() / 2;
		final double translateY = camY * SIZE_FACTOR - Window.getHeight() / 2;

		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				canvas.setWidth(Window.getWidth());
				canvas.setHeight(Window.getHeight());

				gc.clearRect(0, 0, Window.getWidth(), Window.getHeight());

				for (int x = minX; x <= maxX; x++) {
					for (int y = minY; y <= maxY; y++) {
						if (World.get(x, y).render()) {
							gc.drawImage(BlockTextures.get(World.get(x, y)), x * SIZE + translateX,
									Window.getHeight() - y * SIZE - SIZE + translateY, SIZE, SIZE);
						}
					}
				}

				Image playerTexture = Textures.getPlayerTexture(player.getSide());

				gc.drawImage(playerTexture, x + translateX, y + translateY, player.getWidth() * SIZE_FACTOR,
						player.getHeight() * SIZE_FACTOR);
			}
		});
	}
}
