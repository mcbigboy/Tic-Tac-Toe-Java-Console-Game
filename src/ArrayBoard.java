public class ArrayBoard {
    int rows = 3;
    int columns = 3;
    char[][] board;

    public ArrayBoard() {
        board = new char[3][3];
        for (int rowIndex = 0; rowIndex < rows; rowIndex++) {
            for (int colIndex = 0; colIndex < columns; colIndex++) {
                board[rowIndex][colIndex] = '-';
            }
        }
    }

    public void printBoard() {
        for (char[] row : this.board) {
            for (int index = 0; index < row.length; index++) {
                System.out.print(row[index]);
            }
            System.out.println();
        }
    }

    public void makeMove(int x, int y, char value) {
        // TODO write method

        if(isLegal(x,y,value)){
            board[x][y] = value;
        }
    }

    public boolean isLegal(int x, int y, char value) {
        // TODO write method

        if(!(x >= 0 && x <= 2 && y >= 0 && y <= 2)) {
            return false;
        } else if (value != 'X' || value != 'O'){
            return false;
        } else if(board[x][y] != ' '){
            return false;
        }

        return true;

    }

}

