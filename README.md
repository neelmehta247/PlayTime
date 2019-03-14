# PlayTime
PlayTime contains multiple textbased games that can be played on the Java platform. This was made for an ICSE Year 10 project.

Minesweeper - Randomly generated mines on a 5x5 grid. The user enters the coordinates of the block they want to uncover. If the uncovered block has no adjacent mines (labeled 0) all adjacent blocks are checked. Any 0's found are then uncovered and adjacent blocks are recursively checked. In the future, if worked on, I would like to add the ability to drop placeholders, resize the grid, and adjust the number of mines. The minesweeper grid was made by printing text such that it appears as an evenly spaced grid.

SnakesAndLadders - This is a conventional game of Snakes and Ladders for 2 players (or 1 player vs 1 randomized computer). A 2-dimensional array is used to depict the grid and specific integers are used to show the snakes and the ladders. The array is printed such that the user can easily undersatand where all of the snakes and ladders are. A possible improvement for the future is to add the ability to support more than 2 players.

TextRacer - A typing speed calculator that displays words ordered randomly that the user must type. Both the current word, and the next word are displayed at a time. After 1 minute the number of words the user typed in correctly is their typing speed in words per minute. 

