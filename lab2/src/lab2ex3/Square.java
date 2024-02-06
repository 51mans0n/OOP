package lab2ex3;

public class Square {
    private Piece piece;
    private Board board;
    private int row;
    private int column;
    private Piece temporaryPiece;

    public Square(Board board, int row, int column) {
        this.board = board;
        this.row = row;
        this.column = column;
        this.piece = null;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
        if (piece != null) {
            piece.setPosition(this);
        }
    }
    public void setTemporaryPiece(Piece piece) {
        this.temporaryPiece = piece;
    }

    public Piece getTemporaryPiece() {
        return this.temporaryPiece;
    }

    public void clearTemporaryPiece() {
        this.temporaryPiece = null;
    }


    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public boolean isEmpty() {
        return piece == null;
    }

    public Board getBoard() {
        return board;
    }

    public String getPosition() {
        return (char) ('a' + column) + Integer.toString(8 - row);
    }
}






