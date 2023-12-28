public class Rook {
    //Rook emojis
    public String blackRook = "\u2656";
    public String whiteRook = "\u265c";
    Queen queen = new Queen();

    //Check if rook move is legal; also used in checking if queen move is legal
    public boolean legalMove(int startRow, int startCol, int endRow, int endCol, Board b) {
        boolean legal = true;
        
        if (startRow != endRow && startCol != endCol) {
            legal = false;
        }
        if (b.board[startRow][startCol].equals(whiteRook) || b.board[startRow][startCol].equals(queen.whiteQueen)) {
            if (b.board[endRow][endCol].equals("\u265F") || b.board[endRow][endCol].equals("\u265C") || b.board[endRow][endCol].equals("\u265B") || b.board[endRow][endCol].equals("\u265E") || b.board[endRow][endCol].equals("\u265A") || b.board[endRow][endCol].equals("\u265D")) {
                legal = false;
            }
        } else if (b.board[startRow][startCol].equals(blackRook) || b.board[startRow][startCol].equals(queen.blackQueen)) {
            if (b.board[endRow][endCol].equals("\u2659") || b.board[endRow][endCol].equals("\u2656") || b.board[endRow][endCol].equals("\u2655") || b.board[endRow][endCol].equals("\u2658") || b.board[endRow][endCol].equals("\u2654") || b.board[endRow][endCol].equals("\u2657")) {
                legal = false;
            }
        }
        if (startRow != endRow && endRow < startRow) {
            for (int row = endRow + 1; row < startRow; row ++) {
                if (!b.board[row][endCol].equals(" ")) {
                    legal = false;
                }
            }
        } else if (startRow != endRow && startRow < endRow) {
            for (int row = startRow + 1; row < endRow; row ++) {
                if (!b.board[row][endCol].equals(" ")) {
                     legal = false;
                }
            }
        } else if (startCol != endCol && startCol < endCol) {
            for (int col = startCol + 1; col < endCol; col ++) {
                if (!b.board[endRow][col].equals(" ")) {
                    legal = false;
                }
            }
        } else {
            for (int col = endCol + 1; col < startCol; col ++) {
                if (!b.board[endRow][col].equals(" ")) {
                    legal = false;
                }
            }
        }

        return legal;
    }
}