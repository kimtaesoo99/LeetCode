class Solution {
public boolean isValidSudoku(char[][] board) {
    boolean[] isPresent = new boolean[9];
    char c;
    for(int i = 0; i < 9; i++){ 
        Arrays.fill(isPresent, false);
        for(int j = 0; j < 9; j++){
            if(Character.isDigit(board[i][j])){
                int k = (int)board[i][j] - 49; 
                if(isPresent[k])
                    return false;
                isPresent[k] = true;
            }
        }
    }
    for(int j = 0; j < 9; j++){ 
        Arrays.fill(isPresent, false);
        for(int i = 0; i < 9; i++){
            if(Character.isDigit(board[i][j])){
                int k = (int)board[i][j] - 49;
                if(isPresent[k])
                    return false;
                isPresent[k] = true;
            }
        }
    }
    for(int row = 0; row < 3; row++){
        for(int col = 0; col < 3; col++){
            Arrays.fill(isPresent, false);
            int n1 = (row + 1) * 3;
            int n2 = (col + 1) * 3;
            for(int i = n1 - 3; i < n1; i++){
                for(int j = n2 - 3; j < n2; j++){
                    if(Character.isDigit(board[i][j])){
                        int k = (int)board[i][j] - 49;
                        if(isPresent[k])
                            return false;
                        isPresent[k] = true;
                    }
                }
            }
        }
    }
    return true;
}
}