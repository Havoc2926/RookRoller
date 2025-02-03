package Model;
import java.util.ArrayList;
import java.util.List;
import Board.*;
import Piece.*;

public class ChessGame {

    List<Board> allPositions = new ArrayList<Board>();
    Board currentPosition = new Board();

    public ChessGame(){
        allPositions.add(currentPosition);
    }



}
