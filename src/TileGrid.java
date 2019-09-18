
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.Point;


/*
 * @author Isaac Blake
 */
public class TileGrid {

    ArrayList<ArrayList<Tile>> grid;
    ArrayList<ArrayList<String>> gridStringRepresentation;
    HashMap<Tile, Point> stringPositions;

    int w, h;

    // as the grid is generated, we will add x tiles before incrementing y
    // after the grid is generated for the first time, tiles can be set/got
    int nextX, nextY;

    public TileGrid(int w, int h) {
        this.w = w;
        this.h = h;
        grid = new ArrayList<ArrayList<Tile>>();
        gridStringRepresentation = new ArrayList<ArrayList<String>>();
        stringPositions = new HashMap<Tile, Point>();
        nextX = 0;
        nextY = 0;
        for (int y = 0; y < h; y++) {
            grid.add(new ArrayList<Tile>());
        }
    }

    public Tile getTile(int x, int y) {
        return grid.get(y).get(x);
    }

    // NOTE: THIS METHOD IS NOT COMPLETELY FUNCTIONAL YET.
    public void updateTileString(int x, int y, int row) {
        Tile t = grid.get(y).get(x);
        int rowsToUpdate = t.getHeight();
        // avoid getting doubles -- Point is a weird edge case; see
        // https://stackoverflow.com/questions/30219925/should-i-use-point-x-or-point-getx
        int startingX = stringPositions.get(t).x;
        int startingY = stringPositions.get(t).y;
        int updatedRows = 0;
        String newRowString = t.getRowString(row);
        gridStringRepresentation.get(startingY + updatedRows).set(startingX, newRowString);
    }

    /*
    * adds a tile at position (nextX, nextY) and adjusts the stringRepresentation
    * of tiles at (nextX, nextY - 1) and (nextX - 1, nextY) to remove duplicates
    */
    public void add(Tile t) {
        if (nextY > 0) {
            // there exists a block above this one with walls on its bottom
            // side, so remove the top walls of this one
            t.removeRow(0);
        }
        if (nextX > 0) {
            // there exists a block to the left of this one with walls on its right
            // side, so remove the left walls of this one
            t.removeColumn(0);
        }

        // add new rows if we need them. assumes height of tile doesn't change
        // mid-row
        if (nextX == 0) {
            // we need to add the rows to the string grid
            for (int i = 0; i < t.getHeight(); i++) {
                gridStringRepresentation.add(new ArrayList<String>());
            }
        }

        // these are the values in the string grid that this particular tile's
        // string representation beginings at    
        int startingY = 0;
        // the number of rows can theoretically vary.
        int lastFilledRow = 0;
        while (gridStringRepresentation.get(lastFilledRow).size() == w) {
            lastFilledRow++;
        }
        startingY = lastFilledRow; // number of filled rows
        int startingX = nextX;

        stringPositions.put(t, new Point(startingX, startingY));

        int tileRowsToAdd = t.getHeight();
        while (tileRowsToAdd > 0) {
            String newRowString = t.getRowString(tileRowsToAdd - 1);
            gridStringRepresentation.get(startingY + tileRowsToAdd - 1).add(newRowString);
            tileRowsToAdd--;
        }

        grid.get(nextY).add(t);

        nextX++;
        if (nextX == w) {
            nextY++;
            nextX = 0;
        }
    }

    public String toString() {
        // it should be relatively cheap to do this??
        // trying hard to avoid iterating over all tiles and to instead
        // generate and change the String parts as needed.....
        String stringRepresentation = "";
        int printedRows = 0;
        int printedColumns = 0;
        while (printedRows < gridStringRepresentation.size()) {
            stringRepresentation = stringRepresentation + gridStringRepresentation.get(printedRows).get(printedColumns);
            printedColumns++;
            if (printedColumns == w) {
                printedRows++;
                printedColumns = 0;
                stringRepresentation += "\n";
            }
        }
        return stringRepresentation;
    }
}
