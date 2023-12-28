public class Bishop {
    //Bishop emojis
    public String blackBishop = "\u2657";
    public String whiteBishop = "\u265D";
    Queen queen = new Queen();

    //Check if bishop move is legal; also used in checking if queen move is legal
    public boolean legalMove(int startRow, int startCol, int endRow, int endCol, Board b) {
        boolean legal = true;

        if (b.board[startRow][startCol].equals(whiteBishop) || b.board[startRow][startCol].equals(queen.whiteQueen)) {
            if (b.board[endRow][endCol].equals("\u265F") || b.board[endRow][endCol].equals("\u265C") || b.board[endRow][endCol].equals("\u265B") || b.board[endRow][endCol].equals("\u265E") || b.board[endRow][endCol].equals("\u265A") || b.board[endRow][endCol].equals("\u265D")) {
                legal = false;
            }
        } else if (b.board[startRow][startCol].equals(blackBishop) || b.board[startRow][startCol].equals(queen.blackQueen)) {
            if (b.board[endRow][endCol].equals("\u2659") || b.board[endRow][endCol].equals("\u2656") || b.board[endRow][endCol].equals("\u2655") || b.board[endRow][endCol].equals("\u2658") || b.board[endRow][endCol].equals("\u2654") || b.board[endRow][endCol].equals("\u2657")) {
                legal = false;
            }
        }

        if (endRow < startRow && endCol < startCol) {
            if (startRow - endRow != startCol - endCol) {
                legal = false;
            }
            for (int i = 1; i < startRow - endRow; i ++) {
                if (startRow == endRow || startCol ==endCol) {
                    legal = false;
                    break;
                }
                if (!b.board[endRow + i][endCol + i].equals(" ")) {
                    legal = false;
                }
            }
        } else if (startRow < endRow && startCol < endCol) {
            if (endRow - startRow != endCol - startCol) {
                legal = false;
            }
            for (int i = 1; i < endRow - startRow; i ++) {
                if (startRow == endRow || startCol ==endCol) {
                    legal = false;
                    break;
                }
                if (!b.board[startRow + i][startCol + i].equals(" ")) {
                    legal = false;
                }
            }
        } else if (endRow < startRow && endCol > startCol) {
            if (startRow - endRow != endCol - startCol) {
                legal = false;
            }
            for (int i = 1; i < startRow - endRow; i ++) {
                if (startRow == endRow || startCol ==endCol) {
                    legal = false;
                    break;
                }
                if (!b.board[startRow - i][startCol + i].equals(" ")) {
                    legal = false;
                }
            }
        } else {
            if (endRow - startRow != startCol - endCol) {
                legal = false;
            }
            for (int i = 1; i < endRow - startRow; i ++) {
                if (startRow == endRow || startCol ==endCol) {
                    legal = false;
                    break;
                }
                if (!b.board[startRow + i][startCol - i].equals(" ")) {
                    legal = false;
                }
            }
        }
        
        return legal;
    }
}
