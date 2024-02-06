package lab2ex3;

public class Board {
    private Square[][] squares = new Square[8][8];

    public Board() {
        setUpBoard();
        setUpPieces();
    }

    private void setUpBoard() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                squares[row][col] = new Square(this, row, col);
            }
        }
    }

    private void setUpPieces() {
        for (int i = 0; i < 8; i++) {
            squares[1][i].setPiece(new Pawn("white", squares[1][i]));
        }
        squares[0][0].setPiece(new Rook("white", squares[0][0]));
        squares[0][1].setPiece(new Knight("white", squares[0][1]));
        squares[0][2].setPiece(new Bishop("white", squares[0][2]));
        squares[0][3].setPiece(new Queen("white", squares[0][3]));
        squares[0][4].setPiece(new King("white", squares[0][4]));
        squares[0][5].setPiece(new Bishop("white", squares[0][5]));
        squares[0][6].setPiece(new Knight("white", squares[0][6]));
        squares[0][7].setPiece(new Rook("white", squares[0][7]));

        for (int i = 0; i < 8; i++) {
            squares[6][i].setPiece(new Pawn("black", squares[6][i]));
        }
        squares[7][0].setPiece(new Rook("black", squares[7][0]));
        squares[7][1].setPiece(new Knight("black", squares[7][1]));
        squares[7][2].setPiece(new Bishop("black", squares[7][2]));
        squares[7][3].setPiece(new Queen("black", squares[7][3]));
        squares[7][4].setPiece(new King("black", squares[7][4]));
        squares[7][5].setPiece(new Bishop("black", squares[7][5]));
        squares[7][6].setPiece(new Knight("black", squares[7][6]));
        squares[7][7].setPiece(new Rook("black", squares[7][7]));
    }
    public Square getSquare(int row, int col) {
        if (row >= 0 && row < 8 && col >= 0 && col < 8) {
            return squares[row][col];
        }
        return null;
    }


    public void display() {
        System.out.println(" ・a・b・c・d・e・f・g・h・");
        System.out.println("+-----------------------+");
        for (int row = 7; row >= 0; row--) {
            System.out.print((row + 1) + "|");
            for (int col = 0; col < 8; col++) {
                Square square = getSquare(row, col);
                Piece piece = square.getPiece();
                System.out.print(piece == null ? "・ " : piece.getSymbol() + " ");
            }
            System.out.println("|" + (row + 1));
        }
        System.out.println("+-----------------------+");
        System.out.println(" ・a・b・c・d・e・f・g・h・");
    }

    public boolean movePiece(String start, String end, String playerColor) {
        Square startSquare = parsePosition(start);
        Square endSquare = parsePosition(end);

        if (startSquare != null && endSquare != null) {
            Piece piece = startSquare.getPiece();
            if (piece != null && piece.getColor().equals(playerColor) && piece.isLegalMove(endSquare)) {
                endSquare.setTemporaryPiece(endSquare.getPiece());
                endSquare.setPiece(piece);
                startSquare.setPiece(null);
                piece.setPosition(endSquare);
                if (piece instanceof Pawn) {
                    ((Pawn) piece).promote();
                }
                return true;
            }
        }
        return false;
    }
    public void undoMove(String start, String end) {
        Square startSquare = parsePosition(start);
        Square endSquare = parsePosition(end);

        if (startSquare != null && endSquare != null) {
            Piece movingPiece = endSquare.getPiece();
            Piece capturedPiece = endSquare.getTemporaryPiece();
            if (movingPiece != null) {
                startSquare.setPiece(movingPiece);
                endSquare.setPiece(capturedPiece);
                movingPiece.setPosition(startSquare);
                endSquare.clearTemporaryPiece();
            }
        }
    }

    private Square parsePosition(String position) {
        if (position.length() == 2) {
            int col = position.charAt(0) - 'a';
            int row = position.charAt(1) - '1';
            return getSquare(row, col);
        }
        return null;
    }

    public boolean isCheckmate(String playerColor) {
        if (!isKingInCheck(playerColor)) {
            return false;
        }
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Square square = getSquare(row, col);
                Piece piece = square.getPiece();
                if (piece != null && piece.getColor().equals(playerColor)) {
                    for (int newRow = 0; newRow < 8; newRow++) {
                        for (int newCol = 0; newCol < 8; newCol++) {
                            Square newSquare = getSquare(newRow, newCol);
                            if (piece.isLegalMove(newSquare)) {
                                Piece capturedPiece = newSquare.getPiece();
                                newSquare.setPiece(piece);
                                square.setPiece(null);
                                boolean stillInCheck = isKingInCheck(playerColor);
                                square.setPiece(piece);
                                newSquare.setPiece(capturedPiece);
                                if (!stillInCheck) {
                                    return false;
                                }
                            }
                        }
                    }
                }
            }
        }

        return true;
    }

    public boolean isStalemate(String playerColor) {
        if (isKingInCheck(playerColor)) {
            return false;
        }
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Square square = getSquare(row, col);
                Piece piece = square.getPiece();
                if (piece != null && piece.getColor().equals(playerColor)) {
                    for (int newRow = 0; newRow < 8; newRow++) {
                        for (int newCol = 0; newCol < 8; newCol++) {
                            Square newSquare = getSquare(newRow, newCol);
                            if (piece.isLegalMove(newSquare)) {
                                return false;
                            }
                        }
                    }
                }
            }
        }

        return true;
    }
    public boolean isKingInCheck(String playerColor) {
        Square kingSquare = findKingSquare(playerColor);
        if (kingSquare == null) {
            return false;
        }
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Square square = getSquare(row, col);
                Piece piece = square.getPiece();
                if (piece != null && !piece.getColor().equals(playerColor) && piece.isLegalMove(kingSquare)) {
                    return true;
                }
            }
        }
        return false;
    }

    private Square findKingSquare(String playerColor) {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Square square = getSquare(row, col);
                Piece piece = square.getPiece();
                if (piece != null && piece.getColor().equals(playerColor) && piece instanceof King) {
                    return square;
                }
            }
        }
        return null;
    }
}




