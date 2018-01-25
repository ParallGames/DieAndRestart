package dar.gui;

import dar.player.Player;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Panel extends Group {
	private static final double SIZE = 80;
	private static final double SIZE_FACTOR = SIZE / 1000;

	GraphicsContext gc;

	public Panel() {
		Canvas canvas = new Canvas(Window.WIDTH, Window.HEIGHT);
		this.getChildren().add(canvas);

		gc = canvas.getGraphicsContext2D();
		gc.setFill(Color.rgb(255, 255, 255));
	}

	public void update() {
		double x = Player.getX() * SIZE_FACTOR;
		double y = 720 - (Player.getY() + Player.getHeight()) * SIZE_FACTOR;

		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				gc.clearRect(0, 0, Window.WIDTH, Window.HEIGHT);
				gc.fillRect(x, y, Player.getWidth() * SIZE_FACTOR, Player.getHeight() * SIZE_FACTOR);
			}
		});
	}
}
