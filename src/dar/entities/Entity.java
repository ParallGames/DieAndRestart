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

	protected boolean canRight() {
		int blockX = (this.x + this.width) / World.UNIT;

		int startY = this.y / World.UNIT;
		int endY = (this.y + this.height - 1) / World.UNIT;

		for (int y = startY; y <= endY; y++) {
			if (World.get(blockX, y).isSolid() && blockX * World.UNIT == this.width + this.x) {
				return false;
			}
		}

		return true;
	}

	protected boolean canLeft() {
		int blockX = this.x / World.UNIT - 1;

		int startY = this.y / World.UNIT;
		int endY = (this.y + this.height - 1) / World.UNIT;

		for (int y = startY; y <= endY; y++) {
			if (World.get(blockX, y).isSolid() && (blockX + 1) * World.UNIT == this.x) {
				return false;
			}
		}

		return true;
	}

	protected boolean canUp() {
		int blockY = (this.y + this.height) / World.UNIT;

		int startX = this.x / World.UNIT;
		int endX = (this.x + this.width - 1) / World.UNIT;

		for (int x = startX; x <= endX; x++) {
			if (World.get(x, blockY).isSolid() && blockY * World.UNIT == this.height + this.y) {
				return false;
			}
		}

		return true;
	}

	protected boolean canDown() {
		int blockY = this.y / World.UNIT - 1;

		int startX = this.x / World.UNIT;
		int endX = (this.x + this.width - 1) / World.UNIT;

		for (int x = startX; x <= endX; x++) {
			if (World.get(x, blockY).isSolid() && (blockY + 1) * World.UNIT == this.y) {
				return false;
			}
		}

		return true;
	}

	public void moveX(int moveX) {
		while (moveX > 0) {
			if (canRight()) {
				this.x++;
				moveX--;
			} else {
				speedX = 0;
				break;
			}
		}

		while (moveX < 0) {
			if (canLeft()) {
				this.x--;
				moveX++;
			} else {
				speedX = 0;
				break;
			}
		}

		if (this.x < 0) {
			this.x += World.UNIT_WIDTH;
		} else if (this.x >= World.UNIT_WIDTH) {
			this.x -= World.UNIT_WIDTH;
		}
	}

	public void moveY(int moveY) {
		while (moveY > 0) {
			if (canUp()) {
				this.y++;
				moveY--;
			} else {
				speedY = 0;
				break;
			}
		}

		while (moveY < 0) {
			if (canDown()) {
				this.y--;
				moveY++;
			} else {
				speedY = 0;
				onFloor = true;
				break;
			}
		}

		if (this.y < 0) {
			this.y += World.UNIT_HEIGHT;
		} else if (this.y >= World.UNIT_HEIGHT) {
			this.y -= World.UNIT_HEIGHT;
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
