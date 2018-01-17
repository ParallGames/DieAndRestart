package dar.graphics;

import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Panel extends Group {
	GraphicsContext gc;

	public Panel() {
		Canvas canvas = new Canvas(1280, 720);
		this.getChildren().add(canvas);

		gc = canvas.getGraphicsContext2D();
		gc.setFill(Color.rgb(255, 255, 255));
	}

	public void update() {

	}
}
