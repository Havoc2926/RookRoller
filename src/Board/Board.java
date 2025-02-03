package Board;

import java.util.Arrays;

public class Board {

    /*
    piece notation: WHITE/black
    Pawns: P/p
    Rooks: R/r
    Knights: N/n
    Bishops: B/b
    Queen: Q/q
    King: K/k
     */


    public static long whitePawns, whiteRooks, whiteBishops, whiteKnights, whiteQueens, whiteKing;
    public static long blackPawns, blackRooks, blackBishops, blackKnights, blackQueens, blackKing;


    public static long[] initializeBoard(){

        String[][] chessBoard = {
                {"r", "n", "b", "q", "k", "b", "n", "r"},
                {"p", "p", "p", "p", "p", "p", "p", "p"},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {"P", "P", "P", "P", "P", "P", "P", "P"},
                {"R", "N", "B", "Q", "K", "B", "N", "R"}
        };

        generateBitboardsFromBoard(chessBoard);
        return new long[]{whitePawns, whiteRooks, whiteKnights, whiteBishops,  whiteQueens, whiteKing, blackPawns, blackRooks, blackKnights, blackBishops, blackQueens, blackKing};

    }

    public static void generateBitboardsFromBoard(String[][] board){

        for(int row = 0; row < 8; row++){
            for(int col = 0; col < 8; col++){

                int index = (7-row) * 8 + col;

                String piece = board[row][col];

                switch(piece){

                    case "P":
                        whitePawns |= (1L << index);
                        break;
                    case "p":
                        blackPawns |= (1L << index);
                        break;
                    case "R":
                        whiteRooks |= (1L << index);
                        break;
                    case "r":
                        blackRooks |= (1L << index);
                        break;
                    case "N":
                        whiteKnights |= (1L << index);
                        break;
                    case "n":
                        blackKnights |= (1L << index);
                        break;
                    case "B":
                        whiteBishops |= (1L << index);
                        break;
                    case "b":
                        blackBishops |= (1L << index);
                        break;
                    case "Q":
                        whiteQueens |= (1L << index);
                        break;
                    case "q":
                        blackQueens |= (1L << index);
                        break;
                    case "K":
                        whiteKing |= (1L << index);
                        break;
                    case "k":
                        blackKing |= (1L << index);
                        break;
                }
            }
        }

    }


    public void DrawBoard(){
        String[][] chessBoard = new String[8][8];

        for(int i = 0; i< 64;i++){
            chessBoard[i/8][i%8] = " ";
        }
        for(int i = 0;i<64;i++) {

            if (((whitePawns >> i) & 1) == 1) { chessBoard[i / 8][i % 8] = "p";}
            if (((whiteRooks >> i) & 1) == 1) { chessBoard[i / 8][i % 8] = "r";}
            if (((whiteBishops >> i) & 1) == 1) { chessBoard[i / 8][i % 8] = "b";}
            if (((whiteKnights >> i) & 1) == 1) { chessBoard[i / 8][i % 8] = "n";}
            if (((whiteQueens >> i) & 1) == 1) { chessBoard[i / 8][i % 8] = "q";}
            if (((whiteKing >> i) & 1) == 1) { chessBoard[i / 8][i % 8] = "k";}
            if (((blackPawns >> i) & 1) == 1) { chessBoard[i / 8][i % 8] = "P";}
            if (((blackRooks >> i) & 1) == 1) { chessBoard[i / 8][i % 8] = "R";}
            if (((blackBishops >> i) & 1) == 1) { chessBoard[i / 8][i % 8] = "B";}
            if (((blackKnights >> i) & 1) == 1) { chessBoard[i / 8][i % 8] = "N";}
            if (((blackQueens >> i) & 1) == 1) { chessBoard[i / 8][i % 8] = "Q";}
            if (((blackKing >> i) & 1) == 1) { chessBoard[i / 8][i % 8] = "K";}

        }

        for(int i = 0; i< 8;i++){
            System.out.println(Arrays.toString(chessBoard[i]));
        }
    }

    public static void main(String[] args) {
        Board board = new Board();
        board.initializeBoard();
        board.DrawBoard();
    }

}
