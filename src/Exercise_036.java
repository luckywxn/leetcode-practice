import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Exercise_036 {
    public static void main(String[] args) {
        Exercise_036 exercise_036 = new Exercise_036();
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
//        char [][] board = new char[][]
//                {{'.','.','.','.','5','.','.','1','.'},
//                {'.','4','.','3','.','.','.','.','.'},
//                {'.','.','.','.','.','3','.','.','1'},
//                {'8','.','.','.','.','.','.','2','.'},
//                {'.','.','2','.','7','.','.','.','.'},
//                {'.','1','5','.','.','.','.','.','.'},
//                {'.','.','.','.','.','2','.','.','.'},
//                {'.','2','.','9','.','.','.','.','.'},
//                {'.','.','4','.','.','.','.','.','.'}};


        System.out.println(exercise_036.isValidSudoku(board));
    }

    public boolean isValidSudoku2(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            Map<Character, Integer> map = new HashMap<>();
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.' && !map.containsKey(board[i][j])){
                    map.put(board[i][j], 1);
                }else if (board[i][j] != '.' && map.containsKey(board[i][j])){
                    return false;
                }
            }
            Map<Character, Integer> colMap = new HashMap<>();
            for (int j = 0; j < board[i].length; j++) {
                if (board[j][i] != '.' && !colMap.containsKey(board[j][i])){
                    colMap.put(board[j][i], 1);
                }else if (board[j][i] != '.' && colMap.containsKey(board[j][i])){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rowSet = new HashSet[9];
        Set<Character>[] colSet = new HashSet[9];
        Set<Character>[] blockSet = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rowSet[i] = new HashSet<>();
            colSet[i] = new HashSet<>();
            blockSet[i] = new HashSet<>();
        }

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                char num = board[row][col];
                if (num != '.') {
                    if (rowSet[row].contains(num) || colSet[col].contains(num)) {
                        return false;
                    }
                    rowSet[row].add(num);
                    colSet[col].add(num);

                    // 检查3x3宫格
                    int blockRow = row / 3;
                    int blockCol = col / 3;
                    if (blockSet[blockRow * 3 + blockCol].contains(num)) {
                        return false;
                    }
                    blockSet[blockRow * 3 + blockCol].add(num);
                }
            }
        }
        return true;
    }

    private boolean isValidBlock(char[][] board,int blockRow, int blockCol, char num, Set<Character> blockSet) {
        for (int row = blockRow; row < blockRow + 3; row++) {
            for (int col = blockCol; col < blockCol + 3; col++) {
                char blockNum = board[row][col];
                if (blockNum != '.' && blockSet.add(blockNum)) {
                    if (blockNum == num) {
                        blockSet.remove(blockNum);
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
