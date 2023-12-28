public class King {
    //King emojis
    public String blackKing = "\u2654";
    public String whiteKing = "\u265A";

    //Check if king move is legal
    public boolean legalMove(int startRow, int startCol, int endRow, int endCol, Board b) {
        boolean legal = true;
        
        if (b.board[startRow][startCol].equals(whiteKing)) {
            if (b.board[endRow][endCol].equals("\u265F") || b.board[endRow][endCol].equals("\u265C") || b.board[endRow][endCol].equals("\u265B") || b.board[endRow][endCol].equals("\u265E") || b.board[endRow][endCol].equals("\u265A") || b.board[endRow][endCol].equals("\u265D")) {
                legal = false;
            }
        } else if (b.board[startRow][startCol].equals(blackKing)) {
            if (b.board[endRow][endCol].equals("\u2659") || b.board[endRow][endCol].equals("\u2656") || b.board[endRow][endCol].equals("\u2655") || b.board[endRow][endCol].equals("\u2658") || b.board[endRow][endCol].equals("\u2654") || b.board[endRow][endCol].equals("\u2657")) {
                legal = false;
            }
        }
        if (endRow - startRow > 1 || startRow - endRow > 1 || endCol - startCol > 1 || startCol - endCol > 1) {
            legal = false;
        }

        return legal;
    }
}
