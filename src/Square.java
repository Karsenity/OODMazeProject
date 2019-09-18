/*
 * @author Isaac Blake
 */
public abstract class Square {

    Square[] adjacentSquares;
    int degree;

    public Square() {
        // a square can have at most 4 adjacent squares
        // do not try to add more than 4
        // (i.e. maximum degree of a square is 3)
        adjacentSquares = new Square[4];
        degree = 0;
    }

    public void addAdjacentSquare(Square square) {
        adjacentSquares[degree] = square;
        degree++;
    }

    public Square[] getAdjacentSquares() {
        return adjacentSquares;
    }

    public int getDegree() {
        return degree;
    }
}
