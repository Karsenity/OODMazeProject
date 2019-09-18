/*
 * A Tile is fundamentally a way to represent Squares in a method more similar
 * to a String than a node-like Square.
 *
 * In this way, they are a middle-ground between Square and String.
 *
 * Tiles can be added to one another to remove duplicate walls, and they can be
 * easily modified to have a char in the center of them, for example.
 *
 * @author Isaac Blake
 */

import java.util.ArrayList;

public class Tile {

    // I've decided to use ArrayLists so that Tiles are easy to add together when
    // they need to be converted to Strings. This might change later.
    // For now, there are y ArrayLists of width w.
    ArrayList<ArrayList<Character>> grid;

    int removedRows, removedColumns;
    int x, y;
    int w, h;

    // use the observer pattern to alert the subscribingGrid so that it can easily
    // update its String representation should this change
    TileGrid subscribingGrid;

    public Tile(TileGrid subscribingGrid, int x, int y, char horizontalChar, char verticalChar, int w, int h) {
        // counterintuively (but more easily in most scenarios), we start addressing
        // with y and then x. Other classes don't need to know this or care, but
        // it makes the program faster in many cases (i.e. x will usually be larger)
        removedRows = 0;
        removedColumns = 0;
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.subscribingGrid = subscribingGrid;
        grid = new ArrayList<ArrayList<Character>>();
        for (int cy = 0; cy < h; cy++) {
            grid.add(new ArrayList<Character>());
            for (int cx = 0; cx < w; cx++) {
                if (cx == 0 || cx == w - 1) { // this is a vertical wall
                    grid.get(cy).add(verticalChar);
                } else if (cy == 0 || cy == h - 1) { // this is a horizontal wall
                    grid.get(cy).add(horizontalChar);
                } else { // this is an empty space
                    grid.get(cy).add(' ');
                }
            }
        }
    }

    public int getHeight() {
        return grid.size();
    }

    public int getWidth() {
        return grid.get(0).size();
    }

    // remove a row. rows start at 0
    public void removeRow(int r) {
        grid.remove(r);
        removedRows++;
    }

    // remove a column. columns start at 0
    public void removeColumn(int c) {
        for (int i = 0; i < grid.size(); i++) {
            grid.get(i).remove(c);
        }
        removedColumns++;
    }

    public void removeWall(int wall) {
        // never eat soggy waffles
        switch (wall) {
            case 0:
                // remove northern wall
                for (int i = 1; i < w - 1; i++) {
                    setCharAt(i, 0, ' ');
                }
                break;
            case 1:
                // remove eastern wall
                for (int i = 1; i < h - 1; i++) {
                    setCharAt(w - 1, i, ' ');
                }
                break;
            case 2:
                // remove southern wall
                for (int i = 1; i < w - 1; i++) {
                    setCharAt(i, h - 1, ' ');
                }
                break;
            case 3:
                // remove western wall
                for (int i = 1; i < h - 1; i++) {
                    setCharAt(0, i, ' ');
                }
                break;
            default:
                break;
        }
    }

    private void setCharAt(int x, int y, char c) {
        // this method accounts for removed columns and rows ONLY in the context
        // of duplication for now
        if (y - removedRows < 0) {
            // tell the one above us to set the char
            Tile neighborTile = subscribingGrid.getTile(this.x, this.y - 1);
            y = neighborTile.getHeight() - Math.abs(y - removedRows);
            neighborTile.setCharAt(x, y, c);
        } else if (x - removedColumns < 0) {
            // tell the one to the left of us to set the char
            Tile neighborTile = subscribingGrid.getTile(this.x - 1, this.y);
            x = neighborTile.getWidth() - Math.abs(x - removedColumns);
            neighborTile.setCharAt(x, y, c);
        } else {
            ArrayList<Character> row = grid.get(y - removedRows);
            row.set(x - removedColumns, c);
            subscribingGrid.updateTileString(this.x, this.y, y - removedRows);
        }
    }

    public String getRowString(int r) {
        ArrayList<Character> row = grid.get(r);
        String rowString = "";
        for (int i = 0; i < row.size(); i++) {
            rowString = rowString + row.get(i);
        }
        return rowString;
    }

    @Override
    public String toString() {
        String stringRepresentation = "";
        for (int i = 0; i < grid.size(); i++) { // grid.size() is y
            for (int j = 0; j < grid.get(i).size(); j++) { // grid.get(i).size() is x
                stringRepresentation = stringRepresentation + grid.get(i).get(j);
            }
            stringRepresentation = stringRepresentation + '\n';
        }
        return stringRepresentation;
    }

}
