package snake;

import apcs.Window;

public class Snake {

	static final int RIGHT = 0;
	static final int LEFT = 180;
	static final int UP = 90;
	static final int DOWN = 270;


	int x; 
	int y;
	String color;
	int side;

	int direction;
	Snake next;

	public Snake() {
		x = Window.width() / 2;
		y = Window.height() / 2;
		color = "blue";
		side = 10;
		direction = RIGHT;
	}

	public Snake(int x, int y) {
		this.x = x;
		this.y = y;
		color = "purple";
		side = 10;
	}

	public void draw() {
		Window.out.color(color);
		Window.out.square(x, y, side);

		if (next != null) {
			next.draw();
			//next.direction = direction;
		}
	}

	public void move() {
		switch (direction) {
		case UP:
			y -= side;
			break;
		case DOWN:
			y += side;
			break;
		case RIGHT:
			x += side;
			break;
		case LEFT:
			x -= side;
			break;
		}

		if (next != null) {
			next.move();
			next.direction = direction;
		}

	}

	public void changeDirection() {
		if (next ==null) {


			if (Window.key.pressed("up")) {
				direction = UP;
			}
			else if (Window.key.pressed("down")) {
				direction = DOWN;
			}
			else if (Window.key.pressed("right")) {
				direction = RIGHT;
			}
			else if (Window.key.pressed("left")) {
				direction = LEFT;
			}
		}
		else {
			if (Window.key.pressed("up") && direction != DOWN) {
				direction = UP;
			}
			else if (Window.key.pressed("down") && direction != UP) {
				direction = DOWN;
			}
			else if (Window.key.pressed("right") && direction != LEFT) {
				direction = RIGHT;
			}
			else if (Window.key.pressed("left") && direction != RIGHT) {
				direction = LEFT;
			}
		}
	}
	public boolean checkBoundaries() {
		if (x < side|| y < side || x > Window.width() - side || y > Window.height() - side) {
			return true;
		}
		return false;
	}

	public boolean checkFood(Food f) {
		if (Math.abs(x - f.x) <= side && Math.abs(y - f.y) <= side) {
			return true;
		}
		return false;
	}

	public void grow() {

		if (next == null) {
			switch(direction){
			case UP:
				next = new Snake(x, y + side);
				break;
			case DOWN	:
				next = new Snake(x, y - side);
				break;
			case LEFT:
				next = new Snake(x + side, y);
				break;
			case RIGHT	:
				next = new Snake(x - side, y);
				break;
			}
			next.direction = direction;
		}
		else {
			next.grow();
		}
	}
	public boolean checkBody(Snake head) {
		if(next == null) {
			return false;
		}
		
		else if (Math.abs(next.x - head.x) < side && Math.abs(next.y - head.y) < side) {
			return true;
		}
		return next.checkBody(head);

	}


}
