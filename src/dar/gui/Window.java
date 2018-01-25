package dar.gui;

import dar.player.Player;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Window extends Application {

	public static final int WIDTH = 1280;
	public static final int HEIGHT = 720;

	private Panel panel = new Panel();

	private static final int fps = 60;
	private static final long interval = 1_000_000_000 / fps;
	private static long time = System.nanoTime();

	@Override
	public void start(Stage primaryStage) {
		Group root = new Group();
		root.getChildren().add(panel);

		Scene scene = new Scene(root, WIDTH, HEIGHT);
		scene.setFill(Color.rgb(0, 0, 0));

		panel.update();

		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.setTitle("Die And Restart");
		primaryStage.show();

		Key key = new Key();
		root.getChildren().add(key);
		key.requestFocus();

		new Thread() {
			@Override
			public void run() {
				while (primaryStage.isShowing()) {
					Player.tick();
					panel.update();

					long sleep = time - System.nanoTime() + interval;

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