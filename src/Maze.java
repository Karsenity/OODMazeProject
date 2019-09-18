import java.io.*;

/**
 * @author Hunter Chasens
 * @version 19.09.18
 *
 */

class Maze {

/**
 * This is our main driver class.
 *
 * This class make an array of squares, this class makes a new array that is smaller,
 * it runs it to the tilegrid class, and the tilegrid class returns a string to be displayed
 */

/**
 * mazeHeight is the number of colums of squares the maze will contian (not to be confused with characters)
 */
int mazeWidth;
/**
 * mazeWidth is the number of rows of squares the maze will contian (not to be confused with characters)
 */
int mazeHeight;


/**
 * terminalWidth is the number of characters the terminal can fit horisontaly.
 */
int terminalWidth;
/**
 * terminalHeight is the number of characters the terminal can fit verticly.
 */
int terminalHeight;




/**
 * the Alorithm used to generate the maze
 */
public Algorithm alg;



/**
 * grid is a two dimensional array of Squares
 */
public Square[][] grid;

/**
 * Decleration of TileGrid
 * you can get the length of the array by using grid[0].length for the width ro grid[1].length for the y
 */
public TileGrid tileGrid;


/**
 * [Main runs the class]
 * @param args [description]
 */
public static void Main(String[] args){
        //define members here


        //cetch args here

}









/**
 * [window produces a window, or a croped frame of the grid to display]
 * @param  x [the x coordinates on which the window will be centered, must be within the range of the width of the grid]
 * @param  y [the y coordinates on which the window will be centered, must be within the range of the width of the grid]
 * @throws   [throws IndexOutOfBoundsException]
 * @return   [returns a cropped two dimentional array of squares to be passed to ]
 */
private Square[][] window(int x, int y){
        if(x >= mazeWidth) throw new IndexOutOfBoundsException("Maze.window(): Index " + x + " is out of this maze.");
        if(y >= mazeHeight) throw new IndexOutOfBoundsException("Maze.windows(): Index " + y + " is out of this maze.");

        /**
         * A Square is equivelent to one Tile. A Tile is on average 7x3 .
         * Because Tiles shares walls with its agasent Tiles that becomes 6x2.
         * window() must return a 2d arrray of squares that fits in the terminal.
         */

        /**
         * The number of tils wide the window can be
         */
        int windowWidth = terminalWidth / 6;

        /**
         * The number of tils heigh the window can be
         */
        int windowHeight = terminalHeight / 2;

        /**
         * protects from IndexOutOfBoundsException of temp
         */

        if(windowWidth > mazeWidth)
                windowWidth = mazeWidth;
        if(windowHeight > mazeHeight)
                windowHeight = mazeHeight;


        Square temp[][] = new Square[windowWidth][windowHeight];

        //the location of where to start copying
        int startX;
        //the location of where to start copying
        int startY;


        /**
         * this makes sure that both starts and ends are within the index
         * if window is greater then the generated maze then it just returns the maze
         * if one axis is greater then that axis remains the same
         */


        startX = x - (windowWidth/2);

        startY = y - (windowHeight/2);

        //copy the section of the old array to this one
        for(int i = startX; i < windowWidth; i++) {
                for(int j = startY; j < windowHeight; j++) {
                        temp[i-startX][j-startY] = grid[i][j];
                }
        }

        return temp;
}











/**
 * ----------------- Settings/Menu/Save/Load -----------------
 */





/**
 * [menu displays and runs the main menu]
 */
private menu(){


}


/**
 * [settingsMenu displays and runs the settings menu]
 */
private settingsMenu(){



}



private save(){
        //https://www.tutorialspoint.com/java/java_serialization.htm

}


private load(){
        //https://www.tutorialspoint.com/java/java_serialization.htm

}















}
