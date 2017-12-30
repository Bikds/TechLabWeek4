package snake;

import apcs.Window;

public class SnakeGame {

	public static void main(String[] args) {
		Snake head = new Snake();
		Food f = new Food();
			
		while (true) {
			f.draw();
			head.draw();
			head.changeDirection();
			head.move();
			
			//reset the snake
			if (head.checkBoundaries()) {
				head = new Snake();
			}
			if (head.checkBody(head)) {
				head = new Snake();
			}
			
			if (head.checkFood(f)) {
				f.reset();
				head.grow();
			}
			
			
			Window.frame(40);
		}
		
	}
	
	

}
