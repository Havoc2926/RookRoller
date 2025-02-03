package Piece;

import Board.Board;
import java.util.List;

public class Bishop implements Piece{

    boolean isWhite;

    public Bishop(boolean white){
        this.isWhite = white;
    }

    @Override
    public List<Board> generatePossibleMoves(int start, int end, Board position) {
        return null;
    }
}
