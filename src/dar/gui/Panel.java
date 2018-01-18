<<<<<<< HEAD:src/dar/gui/Panel.java
package dar.gui;

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
=======
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
	} //Test

	public void update() {

	}
}
>>>>>>> dbe73064e8c8059c144059dc8def79fe2961698f:src/dar/graphics/Panel.java
