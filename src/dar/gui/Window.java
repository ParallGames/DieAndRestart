package dar.gui;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

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

		ScheduledExecutorService gameLoop = Executors.newSingleThreadScheduledExecutor();

		gameLoop.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				World.getPlayer().tick();
				panel.update(scene.getWidth(), scene.getHeight());
				if (!primaryStage.isShowing()) {
					gameLoop.shutdown();
				}
			}
		}, 0, INTERVAL, TimeUnit.NANOSECONDS);
	}
}