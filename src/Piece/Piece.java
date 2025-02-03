package Piece;
import Board.Board;
import java.util.List;

public interface Piece {

    List<Board> generatePossibleMoves(int start, int end, Board position);
}
