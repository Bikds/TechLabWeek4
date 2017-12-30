package spaceInvaders;

import apcs.Window;

public class Bullet {

	int speed;
	String color;
	int x;
	int y;
	int width;
	int height;
	boolean player;

	public Bullet(int x, int y, boolean player) {
		this.x = x;
		this.y = y;
		this.player = player;
		if (player) {
			color = "orange";
			speed = -20;
		}
		else {
			color = "red";
			speed = 20;
		    }
		width = 30;
		height = 20;

	}
	public void draw() {
		Window.out.color(color);
		Window.out.rectangle(x, y, width, height);
	}
	public void move() {
		y += speed;
	}
	public boolean checkBoundaries() {
		if (player && y < -height) {
			return true;
		}
		if (!player && y > Window.height() + height) {
			return true;
		}
		return false;
	}
	
	public boolean checkEnemy(Enemy e) {
		if (Math.abs(x - e.x) <= width / 2 + e.side / 2 && Math.abs(y - e.y) <= height / 2 + e.side / 2) {
			return true;
		}
		return false;
	}
	
	public boolean checkPlayer(Player e) {
		if (Math.abs(x - e.x) <= width / 2 + e.side / 2 && Math.abs(y - e.y) <= height / 2 + e.side / 2) {
			return true;
		}
		return false;
	}
	public boolean checkBullet(Bullet b) {
		if (player != b.player) {
			if (Math.abs(x - b.x) <= width / 2 + b.width / 2 && Math.abs(y - b.y) <= height / 2 + b.height / 2) {
				return true;
			}
		}
		return false;
	}

}
