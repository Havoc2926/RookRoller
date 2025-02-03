package Piece;

import Board.Board;
import java.util.List;

public class Rook implements Piece{

    boolean isWhite;

    public Rook(boolean isWhite){
        this.isWhite = isWhite;
    }

    @Override
    public List<Board> generatePossibleMoves(int start, int end, Board position){
        return null;
    }

}
