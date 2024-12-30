import java.util.Scanner;

public class GameStart {
    public static void main(String[] args) {
        System.out.println("Starting Gomoku game...");
        // Initialize game board and other necessary components
        // GameBoard board = new GameBoard();
        // board.initialize();
        // Add more game initialization logic here
        Gomoku game = new Gomoku();
        game.printBoard();
        // Add game loop and input handling here
        Scanner scanner = new Scanner(System.in);
        while (!game.checkWin()) {
            System.out.println("Enter your move (row and column): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            if (game.placeMove(row, col)) {
            game.printBoard();
            if (game.checkWin()) {
                System.out.println("We have a winner!");
                break;
            }
            } else {
                System.out.println("Invalid move. Try again.");
            }
            game.switchPlayer();
        }
        scanner.close();
        System.out.println("Game over.");
    }
}
