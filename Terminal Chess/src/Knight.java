public class Knight {
    //Knight emojis
    public String blackKnight = "\u2658";
    public String whiteKnight = "\u265E";

    //Check if knight move is legal
    public boolean legalMove(int startRow, int startCol, int endRow, int endCol, Board b) {
        boolean legal = false;
        
        if (startRow - 2 == endRow && startCol - 1 == endCol) {
            legal = true;
        }
        if (startRow - 2 == endRow && startCol + 1 == endCol) {
            legal = true;
        }
        if (startRow + 2 == endRow && startCol - 1 == endCol) {
            legal = true;
        }
        if (startRow + 2 == endRow && startCol + 1 == endCol) {
            legal = true;
        }
        if (startCol - 2 == endCol && startRow - 1 == endRow) {
            legal = true;
        }
        if (startCol - 2 == endCol && startRow + 1 == endRow) {
            legal = true;
        }
        if (startCol + 2 == endCol && startRow - 1 == endRow) {
            legal = true;
        }
        if (startCol + 2 == endCol && startRow + 1 == endRow) {
            legal = true;
        }

        if (b.board[startRow][startCol].equals(whiteKnight)) {
            if (b.board[endRow][endCol].equals("\u265F") || b.board[endRow][endCol].equals("\u265C") || b.board[endRow][endCol].equals("\u265B") || b.board[endRow][endCol].equals("\u265E") || b.board[endRow][endCol].equals("\u265A") || b.board[endRow][endCol].equals("\u265D")) {
                legal = false;
            }
        } else if (b.board[startRow][startCol].equals(blackKnight)) {
            if (b.board[endRow][endCol].equals("\u2659") || b.board[endRow][endCol].equals("\u2656") || b.board[endRow][endCol].equals("\u2655") || b.board[endRow][endCol].equals("\u2658") || b.board[endRow][endCol].equals("\u2654") || b.board[endRow][endCol].equals("\u2657")) {
                legal = false;
            }
        }

        return legal;
    }
}
