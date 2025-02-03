package Piece;

import Board.Board;
import java.util.List;

public class Pawn implements Piece{

    public boolean isWhite;

    public Pawn(boolean isWhite){
        this.isWhite = isWhite;
    }


    @Override
    public List<Board> generatePossibleMoves(int start, int end, Board position) {
        return null;
    }
}
