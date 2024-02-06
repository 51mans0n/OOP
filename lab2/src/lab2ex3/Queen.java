package lab2ex3;

public class Queen extends Piece {
    public Queen(String color, Square position) {
        super(color, position);
    }

    @Override
    public boolean isLegalMove(Square destination) {
        return isValidStraightMove(destination) || isValidDiagonalMove(destination);
    }

    @Override
    public String getSymbol() {
        return this.color.equals("white") ? "♛" : "♕";
    }

    private boolean isValidStraightMove(Square destination) {
        return ((this.position.getRow() == destination.getRow() || this.position.getColumn() == destination.getColumn()) &&
                isPathClear(destination)) && (!destination.isEmpty() ? !destination.getPiece().getColor().equals(this.color) : true);
    }

    private boolean isValidDiagonalMove(Square destination) {
        int rowChange = Math.abs(destination.getRow() - this.position.getRow());
        int colChange = Math.abs(destination.getColumn() - this.position.getColumn());
        return (rowChange == colChange && isPathClear(destination)) &&
                (!destination.isEmpty() ? !destination.getPiece().getColor().equals(this.color) : true);
    }
}





