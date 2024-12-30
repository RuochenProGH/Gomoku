public abstract class Piece {
    public enum Color {
        BLACK, WHITE
    }

    private Color colour;
    private int x;
    private int y;

    
    public Piece(Color color) {
        this.colour = color;
    }
    
    public int[] getPosition() {
        return new int[]{x, y};
    }

    public Color getColor() {
        return colour;
    }

    public abstract boolean isValidMove(int x, int y);
}
