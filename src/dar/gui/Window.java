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

	@Override
	public void start(Stage primaryStage) {
		Group root = new Group();

		panel = new Panel();
		root.getChildren().add(panel);

		Scene scene = new Scene(root, 1280, 720);
		scene.setFill(Color.rgb(0, 0, 0));

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
					panel.update(scene.getWidth(), scene.getHeight());

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