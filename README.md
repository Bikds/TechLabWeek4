# TechLabWeek4
This repository contains the games tag, Snake, and Space Invaders, in addition to a Photo Editor and a Word game 
(in the wordCloudandTag package)

The game tag uses FireBase to show other active players and then the active players can play a game of tag. The program checks to see if 
the user has collided with another user, and if a collision occurs, then the users bounce off of each other

The game Snake contains a snake and food. The user has to use the arrow keys to control their snake and "eat" the food. If the user eats
the food, their snake grows. There is a Snake.java class that contains all the methods of the snake object and a Food.java contains all
the methods for the food object. The driver class is SnakeGame.java

The goal of SpaceInvaders is to avoid the falling objects by moving left or right. The class Star.java creates stars in the background of
the window, just for decoration. Bullet.java is the falling object that the user has to avoid. It checks if the player has been hit by the 
bullet. Player.java contains the controls of the players. Enemy.java controls the "mothership". 

WordCloud.java takes words from a input file and randomly arranges them in a window, in different color, font size, and directions. 

PhotoEditor contains 3 different classes: Photo.java contains methods to get information about the picture, PhotoEditor.java contains the 
window of the photo editor, and PhotoEffect.java contains methods to modify the picture. 
