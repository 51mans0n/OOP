package lab2ex3;

public class Bishop extends Piece {
    public Bishop(String color, Square position) {
        super(color, position);
    }

    @Override
    public boolean isLegalMove(Square destination) {
        int rowChange = Math.abs(destination.getRow() - this.position.getRow());
        int colChange = Math.abs(destination.getColumn() - this.position.getColumn());
        return (rowChange == colChange && isPathClear(destination)) &&
                (!destination.isEmpty() ? !destination.getPiece().getColor().equals(this.color) : true);
    }

    @Override
    public String getSymbol() {
        return this.color.equals("white") ? "♝" : "♗";
    }
}


