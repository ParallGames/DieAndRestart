package dar.gui;

import dar.world.World;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Window extends Application {
	private Panel panel;

	private static final int FPS = 60;
	private static final long INTERVAL = 1_000_000_000 / FPS;
	private static long time = System.nanoTime();

	private static Stage primaryStage;

	public static double getHeight() {
		return primaryStage.getHeight();
	}

	public static double getWidth() {
		return primaryStage.getWidth();
	}

	@Override
	public void start(Stage p) {
		primaryStage = p;
		Group root = new Group();

		panel = new Panel();
		root.getChildren().add(panel);

		Scene scene = new Scene(root, 1280, 720);
		scene.setFill(Color.rgb(0, 0, 0));

		panel.update();

		primaryStage.setScene(scene);
		primaryStage.setResizable(true);
		primaryStage.setTitle("Die And Restart");
		primaryStage.show();

		Key key = new Key();
		root.getChildren().add(key);
		key.requestFocus();

		new Thread() {
			@Override
			public void run() {
				while (primaryStage.isShowing()) {
					World.getPlayer().tick();
					panel.update();

					long sleep = time - System.nanoTime() + INTERVAL;

					if (sleep > 0) {
						try {
							Thread.sleep(sleep / 1000000, (int) (sleep % 1000000));
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					time = System.nanoTime();
				}
			}
		}.start();
	}
}