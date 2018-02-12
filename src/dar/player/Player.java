package dar.player;

import dar.entities.Entity;
import dar.gui.Key;

public class Player extends Entity {

	public Player() {
		this.height = 1800;
		this.width = 800;
		this.x = 0;
		this.y = 0;
		this.speedX = 0;
		this.speedY = 0;
	}

	public void jump() {
		if (canJump) {
			speedY += 170;
		}
		canJump = false;
	}

	@Override
	public void tick() {
		int speed = 10;
		if (Key.isShiftDown()) {
			speed = 5;
		} else if (Key.isCtrlDown()) {
			speed = 20;
		}
		if (Key.isADown()) {
			accelX(-speed);
			direction = true;
		}
		if (Key.isDDown()) {
			accelX(speed);
			direction = false;
		}
		if (Key.isWDown()) {
			jump();
		}
		speedY -= 10;

		super.tick();
	}
}
