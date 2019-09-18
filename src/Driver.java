/*
 * @author Isaac Blake
 */
public class Driver {

    public static void main(String[] args) {
        TileGrid grid = new TileGrid(3, 3);

        for (int i = 0; i < 3; i++) {
            Tile t1 = new Tile(grid, 0, i, '-', '|', 7, 3);
            grid.add(t1);
            Tile t2 = new Tile(grid, 1, i, '-', '|', 7, 3);
            grid.add(t2);
            Tile t3 = new Tile(grid, 2, i, '-', '|', 7, 3);
            grid.add(t3);
        }
        
        grid.getTile(0, 0).removeWall(1);
        
        System.out.print(grid);
    }
}
