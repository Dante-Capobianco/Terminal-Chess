public class Board {
    //Board where pieces will be located
    public String[][] board = {
        {" ", " ", " ", " ", " ", " ", " ", " "},
        {" ", " ", " ", " ", " ", " ", " ", " "},
        {" ", " ", " ", " ", " ", " ", " ", " "},
        {" ", " ", " ", " ", " ", " ", " ", " "},
        {" ", " ", " ", " ", " ", " ", " ", " "},
        {" ", " ", " ", " ", " ", " ", " ", " "},
        {" ", " ", " ", " ", " ", " ", " ", " "},
        {" ", " ", " ", " ", " ", " ", " ", " "}
    };

    //Reset pieces to original positions
    public void resetBoard(Rook r, Knight k, Bishop b, Queen q, King ki, Pawn p) {
        for (int row = 0; row < board.length; row ++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = " ";
            } 
        }
        
        board[0][0] = r.blackRook;
        board[0][1] = k.blackKnight;
        board[0][2] = b.blackBishop;
        board[0][3] = q.blackQueen;
        board[0][4] = ki.blackKing;
        board[0][5] = b.blackBishop;
        board[0][6] = k.blackKnight;
        board[0][7] = r.blackRook;
        board[1][0] = p.blackPawn;
        board[1][1] = p.blackPawn;
        board[1][2] = p.blackPawn;
        board[1][3] = p.blackPawn;
        board[1][4] = p.blackPawn;
        board[1][5] = p.blackPawn;
        board[1][6] = p.blackPawn;
        board[1][7] = p.blackPawn;

        board[7][0] = r.whiteRook;
        board[7][1] = k.whiteKnight;
        board[7][2] = b.whiteBishop;
        board[7][3] = q.whiteQueen;
        board[7][4] = ki.whiteKing;
        board[7][5] = b.whiteBishop;
        board[7][6] = k.whiteKnight;
        board[7][7] = r.whiteRook;
        board[6][0] = p.whitePawn;
        board[6][1] = p.whitePawn;
        board[6][2] = p.whitePawn;
        board[6][3] = p.whitePawn;
        board[6][4] = p.whitePawn;
        board[6][5] = p.whitePawn;
        board[6][6] = p.whitePawn;
        board[6][7] = p.whitePawn;
    }

    //Print board with row + column numbers
    public String printBoard() {
        String b = "\n" + "  " + "1" + " " + "2" + " " + "3" + " " + "4" + " " + "5" + " " + "6" + " " + "7" + " " + "8" + "\n" +
        "1" + "|" + board[0][0] + "|" + board[0][1] + "|" + board[0][2] + "|" + board[0][3] + "|" + board[0][4] + "|" + board[0][5] + "|" + board[0][6] + "|" + board[0][7] + "|" + "\n" +
        "2" +  "|" + board[1][0] + "|" + board[1][1] + "|" + board[1][2] + "|" + board[1][3] + "|" + board[1][4] + "|" + board[1][5] + "|" + board[1][6] + "|" + board[1][7] + "|" + "\n" +
        "3" +  "|" + board[2][0] + "|" + board[2][1] + "|" + board[2][2] + "|" + board[2][3] + "|" + board[2][4] + "|" + board[2][5] + "|" + board[2][6] + "|" + board[2][7] + "|" + "\n" +
        "4" +  "|" + board[3][0] + "|" + board[3][1] + "|" + board[3][2] + "|" + board[3][3] + "|" + board[3][4] + "|" + board[3][5] + "|" + board[3][6] + "|" + board[3][7] + "|" + "\n" +
        "5" +  "|" + board[4][0] + "|" + board[4][1] + "|" + board[4][2] + "|" + board[4][3] + "|" + board[4][4] + "|" + board[4][5] + "|" + board[4][6] + "|" + board[4][7] + "|" + "\n" +
        "6" +  "|" + board[5][0] + "|" + board[5][1] + "|" + board[5][2] + "|" + board[5][3] + "|" + board[5][4] + "|" + board[5][5] + "|" + board[5][6] + "|" + board[5][7] + "|" + "\n" +
        "7" +  "|" + board[6][0] + "|" + board[6][1] + "|" + board[6][2] + "|" + board[6][3] + "|" + board[6][4] + "|" + board[6][5] + "|" + board[6][6] + "|" + board[6][7] + "|" + "\n" +
        "8" +  "|" + board[7][0] + "|" + board[7][1] + "|" + board[7][2] + "|" + board[7][3] + "|" + board[7][4] + "|" + board[7][5] + "|" + board[7][6] + "|" + board[7][7] + "|" + "\n";
        return b;
    }

    //Move chosen piece from start position to end position
    public void movePiece(int startRow, int startCol, int endRow, int endCol) {
        board[endRow][endCol] = board[startRow][startCol];
        board[startRow][startCol] = " ";
    }
}
