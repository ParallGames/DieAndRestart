package dar.entities;

import dar.world.Blocks;
import dar.world.World;

public abstract class Entity {
	protected int height = 0;
	protected int width = 0;

	protected int x = 0;
	protected int y = 0;

	protected int speedX = 0;
	protected int speedY = 0;

	protected boolean canJump = false;
	protected boolean direction = false;

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
		if (moveX > 0) {
			while (moveX != 0) {
				if (x >= World.WIDTH * 1000 - this.width) {
					speedX = 0;
					return;
				}
				for (int x = 0; x < World.WIDTH; x++) {
					for (int y = 0; y < World.HEIGHT; y++) {
						if (!Blocks.get(World.get(x, y)).isAir()) {
							if ((this.height + 1000) / 2 > Math.abs((this.y + this.height / 2) - (y * 1000 + 500))) {
								if (this.width + this.x == x * 1000) {
									speedX = 0;
									return;
								}
							}
						}
					}
				}
				x++;
				moveX--;
			}
		} else if (moveX < 0) {
			while (moveX != 0) {
				if (x <= 0) {
					speedX = 0;
					return;
				}
				for (int x = 0; x < World.WIDTH; x++) {
					for (int y = 0; y < World.HEIGHT; y++) {
						if (!Blocks.get(World.get(x, y)).isAir()) {
							if ((this.height + 1000) / 2 > Math.abs((this.y + this.height / 2) - (y * 1000 + 500))) {
								if (x * 1000 + 1000 == this.x) {
									speedX = 0;
									return;
								}
							}
						}
					}
				}
				x--;
				moveX++;
			}
		}
	}

	public void moveY(int moveY) {
		if (moveY > 0) {
			while (moveY != 0) {
				if (y >= World.HEIGHT * 1000 - this.height) {
					speedY = 0;
					break;
				}
				for (int x = 0; x < World.WIDTH; x++) {
					for (int y = 0; y < World.HEIGHT; y++) {
						if (!Blocks.get(World.get(x, y)).isAir()) {
							if ((this.width + 1000) / 2 > Math.abs((this.x + this.width / 2) - (x * 1000 + 500))) {
								if (this.height + this.y == y * 1000) {
									speedY = 0;
									return;
								}
							}
						}
					}
				}
				y++;
				moveY--;
			}
		} else if (moveY < 0) {
			while (moveY != 0) {
				if (y <= 0) {
					speedY = 0;
					canJump = true;
					break;
				}
				for (int x = 0; x < World.WIDTH; x++) {
					for (int y = 0; y < World.HEIGHT; y++) {
						if (!Blocks.get(World.get(x, y)).isAir()) {
							if ((this.width + 1000) / 2 > Math.abs((this.x + this.width / 2) - (x * 1000 + 500))) {
								if (y * 1000 + 1000 == this.y) {
									speedY = 0;
									canJump = true;
									return;
								}
							}
						}
					}
				}
				y--;
				moveY++;
			}
		}
	}

	public void tick() {
		moveX(speedX);
		moveY(speedY);

		speedX = (int) (speedX * 0.9);
		speedY = (int) (speedY * 0.99);
	}

	public boolean getDirection() {
		return direction;
	}
}
