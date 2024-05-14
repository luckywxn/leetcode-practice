import java.util.ArrayList;
import java.util.List;

public class Exercise_037 {

    char [][] board = new char[][]
            {{'5','3','.','.','7','.','.','.','.'}
                    ,{'6','.','.','1','9','5','.','.','.'}
                    ,{'.','9','8','.','.','.','.','6','.'}
                    ,{'8','.','.','.','6','.','.','.','3'}
                    ,{'4','.','.','8','.','3','.','.','1'}
                    ,{'7','.','.','.','2','.','.','.','6'}
                    ,{'.','6','.','.','.','.','2','8','.'}
                    ,{'.','.','.','4','1','9','.','.','5'}
                    ,{'.','.','.','.','8','.','.','7','9'}};
    private boolean ok;
    private List<Integer> t = new ArrayList<>();
    private boolean[][] row = new boolean[9][9];
    private boolean[][] col = new boolean[9][9];
    private boolean[][][] block = new boolean[3][3][9];
    public static void main(String[] args) {
        Exercise_037 exercise_037 = new Exercise_037();

        exercise_037.solveSudoku(exercise_037.board);
        System.out.println();
    }

    public void solveSudoku(char[][] board) {
        this.board = board;
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] == '.') {
                    t.add(i * 9 + j);
                } else {
                    int v = board[i][j] - '1';
                    row[i][v] = col[j][v] = block[i / 3][j / 3][v] = true;
                }
            }
        }
        dfs(0);
    }

    private void dfs(int k) {
        if (k == t.size()) {
            ok = true;
            return;
        }
        int i = t.get(k) / 9, j = t.get(k) % 9;
        for (int v = 0; v < 9; ++v) {
            if (!row[i][v] && !col[j][v] && !block[i / 3][j / 3][v]) {
                row[i][v] = col[j][v] = block[i / 3][j / 3][v] = true;
                board[i][j] = (char) (v + '1');
                dfs(k + 1);
                row[i][v] = col[j][v] = block[i / 3][j / 3][v] = false;
            }
            if (ok) {
                return;
            }
        }
    }
}
