<<<<<<< HEAD:src/dar/gui/Window.java
package dar.gui;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Window extends Application {

	private Panel panel = new Panel();

	private static final int fps = 60;
	private static final long interval = 1_000_000_000 / fps;
	private static long time = System.nanoTime();

	@Override
	public void start(Stage primaryStage) {
		Group root = new Group();
		root.getChildren().add(panel);
		Scene scene = new Scene(root, 1280, 720);
		scene.setFill(Color.rgb(0, 0, 0));

		panel.update();

		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.setTitle("Die And Restart");
		primaryStage.show();

		new Thread() {
			@Override
			public void run() {
				while (primaryStage.isShowing()) {
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
=======
package dar.graphics;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Window extends Application {

	private Panel panel = new Panel();

	private static final int fps = 60;
	private static final long interval = 1_000_000_000 / fps;
	private static long time = System.nanoTime();

	@Override
	public void start(Stage primaryStage) {
		Group root = new Group();
		root.getChildren().add(panel);
		Scene scene = new Scene(root, 1280, 720);
		scene.setFill(Color.rgb(0, 0, 0));

		panel.update();

		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.setTitle("Die And Restart");
		primaryStage.show();

		new Thread() {
			@Override
			public void run() {
				while (primaryStage.isShowing()) {
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
>>>>>>> dbe73064e8c8059c144059dc8def79fe2961698f:src/dar/graphics/Window.java
