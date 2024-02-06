package lab2ex3;

public class Rook extends Piece {
    public Rook(String color, Square position) {
        super(color, position);
    }

    @Override
    public boolean isLegalMove(Square destination) {
        return ((this.position.getRow() == destination.getRow() || this.position.getColumn() == destination.getColumn()) &&
                isPathClear(destination)) && (!destination.isEmpty() ? !destination.getPiece().getColor().equals(this.color) : true);
    }

    @Override
    public String getSymbol() {
        return this.color.equals("white") ? "♜" : "♖";
    }
}



