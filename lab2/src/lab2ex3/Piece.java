package lab2ex3;

public abstract class Piece {
    protected String color;
    protected Square position;
    protected boolean firstMove = true;

    public Piece(String color, Square position) {
        this.color = color;
        this.position = position;
        this.firstMove = true;
    }

    public abstract boolean isLegalMove(Square destination);

    public String getColor() {
        return this.color;
    }

    public Square getPosition() {
        return this.position;
    }

    public void setPosition(Square position) {
        this.position = position;
    }

    protected boolean isPathClear(Square destination) {
        int currentRow = this.position.getRow();
        int currentColumn = this.position.getColumn();
        int destinationRow = destination.getRow();
        int destinationColumn = destination.getColumn();

        int rowStep = Integer.compare(destinationRow, currentRow);
        int columnStep = Integer.compare(destinationColumn, currentColumn);

        currentRow += rowStep;
        currentColumn += columnStep;

        Board board = this.position.getBoard();

        while (currentRow != destinationRow || currentColumn != destinationColumn) {
            if (!board.getSquare(currentRow, currentColumn).isEmpty()) {
                return false;
            }
            currentRow += rowStep;
            currentColumn += columnStep;
        }

        return true;
    }


    public abstract String getSymbol();
}






