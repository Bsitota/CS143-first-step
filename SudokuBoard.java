
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class SudokuBoard {
    private char[][] board;
    
    public SudokuBoard(String filename) {
        board = new char[9][9];
        try (Scanner keyboard = new Scanner(new File(filename))) {
           for (int r = 0; r < 9; r++) {
              if (keyboard.hasNextLine()) {
                  String line = keyboard.nextLine();
                  if (line.length() == 9) {
                    for (int c = 0; c < 9; c++) {
                        board[r][c] = line.charAt(c);
                    }
                  }
                }            
             }
        } catch (IOException e) {
            System.err.println("Error reading file " );
              for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    board[i][j] = ' ';
                }
            }
        }
    }

   
    public String toString() {
    StringBuilder build = new StringBuilder();
    build.append("---------------------\n");
    for (int r = 0; r < board.length; r++) {
        if (r % 3 == 0 && r != 0) {
            build.append("|-------------------|\n");
        }
        build.append("| ");
        for (int c = 0; c < board[0].length; c++) {
            if (c % 3 == 0 && c != 0) {
                build.append("| ");
            }
            String spot = board[r][c] == '.' ? "*" : "" + board[r][c]; 
            build.append(spot).append(" ");
        }
        build.append("|\n");
    }
    build.append("---------------------\n");
    return build.toString();
}
}