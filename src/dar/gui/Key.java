package dar.gui;

import javafx.scene.Group;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Key extends Group {
	private static boolean wDown = false;
	private static boolean aDown = false;
	private static boolean sDown = false;
	private static boolean dDown = false;

	public static boolean isWDown() {
		return wDown;
	}

	public static boolean isADown() {
		return aDown;
	}

	public static boolean isSDown() {
		return sDown;
	}

	public static boolean isDDown() {
		return dDown;
	}

	Key() {
		this.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
			if (key.getCode() == KeyCode.W) {
				wDown = true;
			}
			if (key.getCode() == KeyCode.A) {
				aDown = true;
			}
			if (key.getCode() == KeyCode.S) {
				sDown = true;
			}
			if (key.getCode() == KeyCode.D) {
				dDown = true;
			}
		});

		this.addEventHandler(KeyEvent.KEY_RELEASED, (key) -> {
			if (key.getCode() == KeyCode.W) {
				wDown = false;
			}
			if (key.getCode() == KeyCode.A) {
				aDown = false;
			}
			if (key.getCode() == KeyCode.S) {
				sDown = false;
			}
			if (key.getCode() == KeyCode.D) {
				dDown = false;
			}
		});
	}
}
