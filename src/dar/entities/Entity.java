package dar.entities;

import dar.world.World;

public abstract class Entity {
	protected int height = 0;
	protected int width = 0;

	protected int x = 0;
	protected int y = 0;

	protected int speedX = 0;
	protected int speedY = 0;

	protected boolean onFloor = false;
	protected Side side = Side.RIGHT;

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	public void accelX(int x) {
		speedX += x;
	}

	public void accelY(int y) {
		speedY += y;
	}

	public void moveX(int moveX) {
		while (moveX > 0) {
			int x = (this.x + this.width) / 1000;
			for (int y = 0; y < World.HEIGHT; y++) {
				if (World.get(x, y).isSolid()) {
					if ((this.height + 1000) / 2 > Math.abs((this.y + this.height / 2) - (y * 1000 + 500))) {
						if (this.width + this.x == x * 1000) {
							speedX = 0;
							return;
						}
					}
				}
			}
			this.x++;
			moveX--;
		}

		while (moveX < 0) {
			int x = (this.x - 1) / 1000;
			for (int y = 0; y < World.HEIGHT; y++) {
				if (World.get(x, y).isSolid()) {
					if ((this.height + 1000) / 2 > Math.abs((this.y + this.height / 2) - (y * 1000 + 500))) {
						if (x * 1000 + 1000 == this.x) {
							speedX = 0;
							return;
						}
					}
				}
			}
			this.x--;
			moveX++;
		}

		if (this.x < 0) {
			this.x += World.WIDTH * 1000;
		} else if (this.x >= World.WIDTH * 1000) {
			this.x -= World.WIDTH * 1000;
		}
	}

	public void moveY(int moveY) {
		while (moveY > 0) {
			int y = (this.y + this.height) / 1000;
			for (int x = 0; x < World.WIDTH; x++) {
				if (World.get(x, y).isSolid()) {
					if ((this.width + 1000) / 2 > Math.abs((this.x + this.width / 2) - (x * 1000 + 500))) {
						if (this.height + this.y == y * 1000) {
							speedY = 0;
							return;
						}
					}
				}
			}
			this.y++;
			moveY--;
		}

		while (moveY < 0) {
			int y = (this.y - 1) / 1000;
			for (int x = 0; x < World.WIDTH; x++) {
				if (World.get(x, y).isSolid()) {
					if ((this.width + 1000) / 2 > Math.abs((this.x + this.width / 2) - (x * 1000 + 500))) {
						if (y * 1000 + 1000 == this.y) {
							speedY = 0;
							onFloor = true;
							return;
						}
					}
				}
			}
			this.y--;
			moveY++;
		}

		if (this.y < 0) {
			this.y += World.HEIGHT * 1000;
		} else if (this.y >= World.HEIGHT * 1000) {
			this.y -= World.HEIGHT * 1000;
		}
	}

	public void tick() {
		onFloor = false;

		moveX(speedX);
		moveY(speedY);

		speedX *= 0.9;
		speedY *= 0.99;
	}

	public Side getSide() {
		return side;
	}
}
