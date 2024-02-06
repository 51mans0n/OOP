package lab2ex3;

import java.util.Scanner;

public class ChessGame {
    private Board board;
    private String currentPlayer;
    private boolean gameRunning;

    public ChessGame() {
        board = new Board();
        currentPlayer = "white";
        gameRunning = true;
    }
    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (gameRunning) {
            board.display();
            System.out.println("Ходят " + (currentPlayer.equals("white") ? "белые" : "черные") + ". Введите ход (например, e2 e4):");
            String move = scanner.nextLine();
            if (move.equals("exit")) {
                gameRunning = false;
            }
            else {
                makeMove(move);
            }
        }

        scanner.close();
        System.out.println("Игра окончена.");
    }

    private void makeMove(String move) {
        String[] positions = move.split(" ");
        if (positions.length == 2) {
            String start = positions[0];
            String end = positions[1];
            if (board.movePiece(start, end, currentPlayer)) {
                if (board.isKingInCheck(currentPlayer)) {
                    System.out.println("Шах! Вы должны предотвратить шах королю.");
                    board.undoMove(start, end);
                }
                else {
                    switchPlayer();
                    if (board.isCheckmate(currentPlayer)) {
                        System.out.println("Шах и мат! " + opponentColor() + " выиграл!");
                        gameRunning = false;
                    }
                    else if (board.isStalemate(currentPlayer)) {
                        System.out.println("Пат! Игра окончена вничью.");
                        gameRunning = false;
                    }
                }
            }
            else {
                System.out.println("Невозможный ход. Попробуйте снова.");
            }
        }
        else {
            System.out.println("Неверный формат ввода. Пожалуйста, используйте формат 'e2 e4'.");
        }
    }
    private String opponentColor() {
        return currentPlayer.equals("white") ? "black" : "white";
    }

    private void switchPlayer() {
        currentPlayer = currentPlayer.equals("white") ? "black" : "white";
    }
    public static void main(String[] args) {
        ChessGame game = new ChessGame();
        game.start();
    }
}




