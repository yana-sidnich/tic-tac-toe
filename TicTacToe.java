package TicTacToe;
import java.util.Scanner;

class TicTacToe {

    private char board[][];
    private int ROWS = 3;
    private int COLS = 3;

    public TicTacToe() {
        board = new char[ROWS][COLS];
    }

    public void initializeBoard() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public void printBoard() {
        System.out.println("--+-+--");
        for (int i = 0; i < ROWS; i++) {
            System.out.print('|');;
            for (int j = 0; j < COLS; j++) {
                System.out.print(board[i][j]);
                System.out.print('|');
            }
            System.out.println();
            System.out.println("--+-+--");
        }
    }

    public boolean placeOnBoard(char player, int destRow, int destCol) {
        if(this.board[destRow][destCol] == ' ') {
            this.board[destRow][destCol] = player;
            return true;
        }
        return false;
    }

    public boolean isWinner(char player, int row, int col) {
        boolean isWinner = true;

        // check the row
        for (int i = 0; i < this.COLS; i++) {
           if(this.board[row][i] != player) {
               isWinner = false;
               break;
           }
       }
       if(isWinner){
           return isWinner;
       }

        isWinner = true;
        // check the col
       for (int i = 0; i < this.ROWS; i++) {
            if(this.board[i][col] != player) {
                isWinner = false;
                break;
            }

        }
        if(isWinner) {
            return isWinner;
        }

        isWinner = true;
        // check main cross
        for (int i = 0; i < this.ROWS; i++) {
            if(this.board[i][i] != player) {
                isWinner = false;
            }
        }
        if(isWinner) {
            return isWinner;
        }

        isWinner = true;
        // check sec cross
        for (int i = 0; i < this.ROWS; i++) {
            for (int j = this.COLS - 1; j >= 0; j--) {
                if(this.board[i][j] != player) {
                    isWinner = false;
                } 
            } 
        }
        
        return isWinner;
    }
    
    
    
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        Scanner input = new Scanner(System.in);
        boolean islegal = true;
        boolean isOver = false;
        boolean isXsTurn = true;
        char X = 'X';
        char O = 'O';
        game.initializeBoard();
        game.printBoard();
        

        while (true) {
            System.out.println("please enter the wanted place row (1-3): ");
            int rowNum = input.nextInt();
            System.out.println("please enter the wanted place col (1-3): ");
            int colNum = input.nextInt();
            if (isXsTurn) {
                islegal = game.placeOnBoard(X, rowNum - 1, colNum - 1);
            }
            else {
                islegal = game.placeOnBoard(O, rowNum - 1, colNum - 1);
            }

            if (!islegal) {
                System.out.println("place is taken, try again!");
                islegal = true;
                continue;
            }

            game.printBoard();

            if(isXsTurn)
            {
                isOver = game.isWinner(X, rowNum - 1, colNum - 1);
                if(isOver) {
                    System.out.println("X is winner");
                    break;
                }
            }
            else {
                isOver = game.isWinner(O, rowNum - 1, colNum - 1);
                if(isOver) {
                    System.out.println("O is winner");
                    break;
                }
            }

            isXsTurn = !isXsTurn;
        }

        input.close();
    }
}