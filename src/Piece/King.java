package Piece;

import Board.Board;
import java.util.List;

public class King implements Piece{

    boolean isWhite;

    public King(boolean isWhite){
        this.isWhite = isWhite;
    }

    @Override
    public List<Board> generatePossibleMoves(int start, int end, Board position){
        return null;
    }
}
