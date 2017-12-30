package snake;

import apcs.Window;

public class Food {
	
	int side = 10;
	int x = Window.rollDice(Window.width() - side) + side / 2;
	int y = Window.rollDice(Window.height() - side) + side / 2;

	
	public void draw() {
		Window.out.color("yellow");
		Window.out.square(x, y, side);
	}
	
	public void reset() {
		 x = Window.rollDice(Window.width() - side) + side / 2;
		 y = Window.rollDice(Window.height() - side) + side / 2;
	}
}
