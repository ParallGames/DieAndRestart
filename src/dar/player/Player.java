package dar.player;

import dar.entities.Entity;
import dar.entities.Side;
import dar.gui.Key;

public class Player extends Entity {

	public Player() {
		this.height = 1800;
		this.width = 800;
		this.x = 1000;
		this.y = 1000;
		this.speedX = 0;
		this.speedY = 0;
	}

	public void jump() {
		if (onFloor) {
			speedY += 160;
		}
	}

	@Override
	public void tick() {
		int speed = 10;
		height = 1800;
		if (Key.isShiftDown()) {
			speed = 5;
			height = 1300;
		} else if (Key.isCtrlDown()) {
			speed = 20;
		}
		if (Key.isADown()) {
			accelX(-speed);
			side = Side.LEFT;
		}
		if (Key.isDDown()) {
			accelX(speed);
			side = Side.RIGHT;
		}
		if (Key.isWDown()) {
			jump();
		}
		speedY -= 10;

		super.tick();
	}
}
