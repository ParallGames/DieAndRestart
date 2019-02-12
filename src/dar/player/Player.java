package dar.player;

import dar.entities.Entity;
import dar.entities.Side;
import dar.gui.Key;
import dar.world.World;

public class Player extends Entity {
	public Player() {
		this.height = World.getUnits(1.8);
		this.width = World.getUnits(0.8);
		this.x = World.getUnits(0);
		this.y = World.getUnits(2);
		this.speedX = 0;
		this.speedY = 0;
	}

	public void jump() {
		if (onFloor) {
			speedY += World.getUnits(0.17);
		}
	}

	@Override
	public void tick() {
		int speed = World.getUnits(0.01);
		height = World.getUnits(1.8);
		if (Key.isShiftDown()) {
			speed = World.getUnits(0.005);
			height = World.getUnits(1.3);
		} else if (Key.isCtrlDown()) {
			speed = World.getUnits(0.02);
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

		speedY -= World.getUnits(0.01);

		super.tick();
	}
}
