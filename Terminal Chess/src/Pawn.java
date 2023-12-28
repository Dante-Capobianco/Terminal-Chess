public class Pawn {
    //Pawn emojis
    public String blackPawn = "\u2659";
    public String whitePawn = "\u265F";
    Queen queen = new Queen();

    //Check if pawn move is legal
    public boolean legalMove(int startRow, int startCol, int endRow, int endCol, Board b) {
        boolean legal = true;

        if (b.board[startRow][startCol].equals(blackPawn) && startRow + 1 != endRow) {
            if (startRow != 1 || startRow + 2 != endRow || startCol != endCol) {
                legal = false;
            }
        }
        if (b.board[startRow][startCol].equals(whitePawn) && startRow - 1 != endRow) {
            if (startRow != 6 || startRow - 2 != endRow || startCol != endCol) {
                legal = false;
            }
        }
        if (startCol != endCol) {
            if (startCol + 1 != endCol && startCol - 1 != endCol) {
                legal = false;
            }
        }
        if (startCol - 1 == endCol || startCol + 1 == endCol) {
            if (b.board[endRow][endCol].equals(" ")) {
                    legal = false;
            }
            if (b.board[startRow][startCol].equals(whitePawn)) {
                if (b.board[endRow][endCol].equals("\u265F") || b.board[endRow][endCol].equals("\u265C") || b.board[endRow][endCol].equals("\u265B") || b.board[endRow][endCol].equals("\u265E") || b.board[endRow][endCol].equals("\u265A") || b.board[endRow][endCol].equals("\u265D")) {
                    legal = false;
                }
            } else if (b.board[startRow][startCol].equals(blackPawn)) {
                if (b.board[endRow][endCol].equals("\u2659") || b.board[endRow][endCol].equals("\u2656") || b.board[endRow][endCol].equals("\u2655") || b.board[endRow][endCol].equals("\u2658") || b.board[endRow][endCol].equals("\u2654") || b.board[endRow][endCol].equals("\u2657")) {
                    legal = false;
                }
            }
        }
        if (startCol == endCol && !b.board[endRow][endCol].equals(" ")) {
            legal = false;
        }
        
        return legal;
    }
}