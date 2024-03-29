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
public static int mazeWidth;
/**
 * mazeWidth is the number of rows of squares the maze will contian (not to be confused with characters)
 */
public static int mazeHeight;


/**
 * terminalWidth is the number of characters the terminal can fit horisontaly.
 */
public static int terminalWidth;
/**
 * terminalHeight is the number of characters the terminal can fit verticly.
 */
public static int terminalHeight;




/**
 * the Alorithm used to generate the maze
 */
public static Algorithm alg;



/**
 * grid is a two dimensional array of Squares
 */
public static Square[][] grid;

/**
 * Decleration of TileGrid
 * you can get the length of the array by using grid[0].length for the width ro grid[1].length for the y
 */
public static TileGrid tileGrid;


/**
 * [Main runs the class]
 * @param args [description]
 */
public static void Main(String[] args){
        //cetch args here
        if(args.size != 0) {
                for(int i = 0; i < args.size; i++) {
                        if(args[i].compareTo("-h") == 0 || args[i].compareTo("--help") == 0)
                                System.out.println("");

                        /**
                         * try and ceatch me in future!
                         */
                        if(args[i].compareTo("-x") == 0 || args[i].compareTo("-X") == 0)
                                terminalWidth = Integer.parseInt(args[i+1]);

                        if(args[i].compareTo("-y") == 0 || args[i].compareTo("-Y") == 0)
                                terminalHeight = Integer.parseInt(args[i+1]);


                        /**
                         * try and ceatch me in future!
                         */
                        if(args[i].compareTo("-xm") == 0 || args[i].compareTo("-Xm") == 0)
                                mazeWidth = Integer.parseInt(args[i+1]);

                        if(args[i].compareTo("-ym") == 0 || args[i].compareTo("-Ym") == 0)
                                mazeHeight = Integer.parseInt(args[i+1]);
                }
        }

        //define members

        //alg = new WillsonsAlgorithm();
        //grid = new WillsonsSquare()[mazeWidth][mazeHeight];
        tileGrid = new TileGrid();

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
