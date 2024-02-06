package lab2ex3;

import java.util.Scanner;
public class Pawn extends Piece {
    public Pawn(String color, Square position) {
        super(color, position);
    }

    @Override
    public boolean isLegalMove(Square destination) {
        int rowChange = destination.getRow() - this.position.getRow();
        int colChange = destination.getColumn() - this.position.getColumn();
        int direction = this.color.equals("white") ? 1 : -1;

        if (colChange == 0 && rowChange == direction) {
            return destination.isEmpty();
        }

        else if (this.firstMove && colChange == 0 && rowChange == 2 * direction) {
            Square middleSquare = this.position.getBoard().getSquare(this.position.getRow() + direction, this.position.getColumn());
            return destination.isEmpty() && middleSquare.isEmpty();
        }

        else if (Math.abs(colChange) == 1 && rowChange == direction) {
            return !destination.isEmpty() && !destination.getPiece().getColor().equals(this.color);
        }

        return false;
    }

    public void promote() {
        if ((color.equals("white") && position.getRow() == 7) || (color.equals("black") && position.getRow() == 0)) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Пешка достигла конца доски! Во что вы хотите ее превратить? (Q/R/N/B)");
            String choice = scanner.nextLine().toUpperCase();

            Piece newPiece = null;
            switch (choice) {
                case "Q":
                    newPiece = new Queen(color, position);
                    break;
                case "R":
                    newPiece = new Rook(color, position);
                    break;
                case "N":
                    newPiece = new Knight(color, position);
                    break;
                case "B":
                    newPiece = new Bishop(color, position);
                    break;
                default:
                    System.out.println("Неверный выбор. Пешка превращена в ферзя по умолчанию.");
                    newPiece = new Queen(color, position);
            }
            position.setPiece(newPiece);
        }
    }
    @Override
    public String getSymbol() {
        return this.color.equals("white") ? "♟" : "♙";
    }
}





