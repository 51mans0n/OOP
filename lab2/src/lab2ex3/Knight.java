package lab2ex3;

public class Knight extends Piece {
    public Knight(String color, Square position) {
        super(color, position);
    }

    @Override
    public boolean isLegalMove(Square destination) {
        int rowChange = Math.abs(destination.getRow() - this.position.getRow());
        int colChange = Math.abs(destination.getColumn() - this.position.getColumn());
        return ((rowChange == 2 && colChange == 1) || (rowChange == 1 && colChange == 2)) &&
                (!destination.isEmpty() ? !destination.getPiece().getColor().equals(this.color) : true);
    }

    @Override
    public String getSymbol() {
        return this.color.equals("white") ? "♞" : "♘";
    }
}





