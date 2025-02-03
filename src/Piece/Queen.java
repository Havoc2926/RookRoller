package Piece;

import Board.Board;
import java.util.List;

public class Queen implements Piece{

    boolean isWhite;
    public Queen(boolean isWhite){
        this.isWhite = isWhite;
    }

    @Override
    public List<Board> generatePossibleMoves(int start, int end, Board position){
        return null;
    }
}
