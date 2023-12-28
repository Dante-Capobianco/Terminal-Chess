import java.util.Scanner;

public class Main 
{ 
  public static void main(String[] args) {
    boolean exitProgram = false;
    boolean gameEnd = false;
    boolean whiteWins = false;
    boolean legalStatus = false;

    //Location of piece that will be moved + destination
    int whiteStartRow = 0;
    int whiteStartCol = 0;
    int whiteEndRow = 0;
    int whiteEndCol = 0;
    int blackStartRow = 0;
    int blackStartCol = 0;
    int blackEndRow = 0;
    int blackEndCol = 0;

    //Create board + pieces
    Board b = new Board();
    Rook rook = new Rook();
    Knight knight = new Knight();
    Bishop bishop = new Bishop();
    Queen queen = new Queen();
    King king = new King();
    Pawn pawn = new Pawn();
    Scanner scanner = new Scanner(System.in);

    while (! exitProgram) {
      //Reset pieces to original positions + introduce teams
      b.resetBoard(rook, knight, bishop, queen, king, pawn);
      System.out.println("\nGood luck Team White and Team Black! Have fun!");
      
      while (! gameEnd) {
        //Print new board after each move
        System.out.println(b.printBoard());

        while (! legalStatus) {
          //Get location of piece that will be moved + destination
          System.out.print("White, enter the row & column of the piece you want to move <row/col>: ");
          String whiteStart = scanner.next();
          whiteStartRow = Integer.parseInt(whiteStart.substring(0, 1)) - 1;
          whiteStartCol = Integer.parseInt(whiteStart.substring(2)) - 1;
          
          System.out.print("White, enter the row & column of where you want the piece to go <row/col>: ");
          String whiteEnd = scanner.next();
          whiteEndRow = Integer.parseInt(whiteEnd.substring(0, 1)) - 1;
          whiteEndCol = Integer.parseInt(whiteEnd.substring(2)) - 1;

          //Check if move is legal; if not, tell user to re-enter a move
          if (whiteStartRow < 0 || whiteStartRow > 7 || whiteStartCol < 0 || whiteStartCol > 7 || whiteEndRow < 0 || whiteEndRow > 7 || whiteEndCol < 0 || whiteEndCol > 7) {
            System.out.println("\nIllegal move. Try again.\n");
          } else if (whiteStartRow == whiteEndRow && whiteStartCol == whiteEndCol) {
            System.out.println("\nIllegal move. Try again.\n");
          } else if (b.board[whiteStartRow][whiteStartCol].equals(" ")) {
            System.out.println("\nIllegal move. Try again.\n");
          } else if (b.board[whiteStartRow][whiteStartCol].equals(pawn.blackPawn) || b.board[whiteStartRow][whiteStartCol].equals(rook.blackRook) || b.board[whiteStartRow][whiteStartCol].equals(queen.blackQueen) || b.board[whiteStartRow][whiteStartCol].equals(knight.blackKnight) || b.board[whiteStartRow][whiteStartCol].equals(king.blackKing) || b.board[whiteStartRow][whiteStartCol].equals(bishop.blackBishop)) {
            System.out.println("\nIllegal move. Try again.\n");
          } else if (b.board[whiteStartRow][whiteStartCol].equals(pawn.whitePawn)) {
            if (pawn.legalMove(whiteStartRow, whiteStartCol, whiteEndRow, whiteEndCol, b)) {
              legalStatus = true;
              if (b.board[whiteStartRow][whiteStartCol].equals(pawn.whitePawn) && whiteEndRow == 0) {
                b.board[whiteStartRow][whiteStartCol] = "\u265B";
              }
            } else {
              System.out.println("\nIllegal move. Try again.\n");
            }
          } else if (b.board[whiteStartRow][whiteStartCol].equals(rook.whiteRook)) {
            if (rook.legalMove(whiteStartRow, whiteStartCol, whiteEndRow, whiteEndCol, b)) {
              legalStatus = true;
            } else {
              System.out.println("\nIllegal move. Try again.\n");
            }
          } else if (b.board[whiteStartRow][whiteStartCol].equals(knight.whiteKnight)) {
            if (knight.legalMove(whiteStartRow, whiteStartCol, whiteEndRow, whiteEndCol, b)) {
              legalStatus = true;
            } else {
              System.out.println("\nIllegal move. Try again.\n");
            }
          } else if (b.board[whiteStartRow][whiteStartCol].equals(bishop.whiteBishop)) {
            if (bishop.legalMove(whiteStartRow, whiteStartCol, whiteEndRow, whiteEndCol, b)) {
              legalStatus = true;
            } else {
              System.out.println("\nIllegal move. Try again.\n");
            }
          } else if (b.board[whiteStartRow][whiteStartCol].equals(queen.whiteQueen)) {
            if (bishop.legalMove(whiteStartRow, whiteStartCol, whiteEndRow, whiteEndCol, b) || rook.legalMove(whiteStartRow, whiteStartCol, whiteEndRow, whiteEndCol, b)) {
              legalStatus = true;
            } else {
              System.out.println("\nIllegal move. Try again.\n");
            }
          } else {
            if (king.legalMove(whiteStartRow, whiteStartCol, whiteEndRow, whiteEndCol, b)) {
              legalStatus = true;
            } else {
              System.out.println("\nIllegal move. Try again.\n");
            }
          }
        }
        
        legalStatus = false;

        //Move the desired piece and print the new board
        b.movePiece(whiteStartRow, whiteStartCol, whiteEndRow, whiteEndCol);
        System.out.println(b.printBoard());

        //Check if any of the kings were killed; if so, game ends
        if (! b.printBoard().contains("\u2654")) {
          whiteWins = true;
          gameEnd = true;
          break;
        } else if (! b.printBoard().contains("\u265A")) {
          gameEnd = true;
          break;
        }
        
        while (! legalStatus) {
          System.out.print("Black, enter the row & column of the piece you want to move <row/col>: ");
          String blackStart = scanner.next();
          blackStartRow = Integer.parseInt(blackStart.substring(0, 1)) - 1;
          blackStartCol = Integer.parseInt(blackStart.substring(2)) - 1;
        
          System.out.print("Black, enter the row & column of where you want the piece to go <row/col>: ");
          String blackEnd = scanner.next();
          blackEndRow = Integer.parseInt(blackEnd.substring(0, 1)) - 1;
          blackEndCol = Integer.parseInt(blackEnd.substring(2)) - 1;

          if (blackStartRow < 0 || blackStartRow > 7 || blackStartCol < 0 || blackStartCol > 7 || blackEndRow < 0 || blackEndRow > 7 || blackEndCol < 0 || blackEndCol > 7) {
            System.out.println("\nIllegal move. Try again.\n");
          } else if (blackStartRow == blackEndRow && blackStartCol == blackEndCol) {
            System.out.println("\nIllegal move. Try again.\n");
          } else if (b.board[blackStartRow][blackStartCol].equals(" ")) {
            System.out.println("\nIllegal move. Try again.\n");
          } else if (b.board[blackStartRow][blackStartCol].equals(pawn.whitePawn) || b.board[blackStartRow][blackStartCol].equals(rook.whiteRook) || b.board[blackStartRow][blackStartCol].equals(queen.whiteQueen) || b.board[blackStartRow][blackStartCol].equals(knight.whiteKnight) || b.board[blackStartRow][blackStartCol].equals(king.whiteKing) || b.board[blackStartRow][blackStartCol].equals(bishop.whiteBishop)) {
            System.out.println("\nIllegal move. Try again.\n");
          } else if (b.board[blackStartRow][blackStartCol].equals(pawn.blackPawn)) {
            if (pawn.legalMove(blackStartRow, blackStartCol, blackEndRow, blackEndCol, b)) {
              legalStatus = true;
              if (b.board[blackStartRow][blackStartCol].equals(pawn.blackPawn) && blackEndRow == 7) {
                b.board[blackStartRow][blackStartCol] = "\u2655";
              }
            } else {
              System.out.println("\nIllegal move. Try again.\n");
            }
          } else if (b.board[blackStartRow][blackStartCol].equals(rook.blackRook)) {
            if (rook.legalMove(blackStartRow, blackStartCol, blackEndRow, blackEndCol, b)) {
              legalStatus = true;
            } else {
              System.out.println("\nIllegal move. Try again.\n");
            }
          } else if (b.board[blackStartRow][blackStartCol].equals(knight.blackKnight)) {
            if (knight.legalMove(blackStartRow, blackStartCol, blackEndRow, blackEndCol, b)) {
              legalStatus = true;
            } else {
              System.out.println("\nIllegal move. Try again.\n");
            }
          } else if (b.board[blackStartRow][blackStartCol].equals(bishop.blackBishop)) {
            if (bishop.legalMove(blackStartRow, blackStartCol, blackEndRow, blackEndCol, b)) {
              legalStatus = true;
            } else {
              System.out.println("\nIllegal move. Try again.\n");
            }
          } else if (b.board[blackStartRow][blackStartCol].equals(queen.blackQueen)) {
            if (bishop.legalMove(blackStartRow, blackStartCol, blackEndRow, blackEndCol, b) || rook.legalMove(blackStartRow, blackStartCol, blackEndRow, blackEndCol, b)) {
              legalStatus = true;
            } else {
              System.out.println("\nIllegal move. Try again.\n");
            }
          } else {
            if (king.legalMove(blackStartRow, blackStartCol, blackEndRow, blackEndCol, b)) {
              legalStatus = true;
            } else {
              System.out.println("\nIllegal move. Try again.\n");
            }
          }
        }

        legalStatus = false;

        b.movePiece(blackStartRow, blackStartCol, blackEndRow, blackEndCol);
        
        if (! b.printBoard().contains("\u2654")) {
          whiteWins = true;
          gameEnd = true;
        } else if (! b.printBoard().contains("\u265A")) {
          gameEnd = true;
        }
      }

      //Print final board where a king is killed + winner message
      if (whiteWins) {
        System.out.println("Congratulations, Team White. You win!\n");
      } else {
        System.out.println(b.printBoard());
        System.out.println("Congratulations, Team Black. You win!\n");
      } 

      //Check if user wants to play again
      System.out.print("Would you like to play again? <Y/N> ");
      String input = scanner.next();
      if (input.equals("N")) {
        exitProgram = true;
        scanner.close();
      } else {
        whiteWins = false;
        gameEnd = false;
      }
    }
  } 
}