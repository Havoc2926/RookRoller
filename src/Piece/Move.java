package Piece;

public class Move {

    private int startSquare;
    private int targetSquare;

    public Move(int start, int target){
        this.startSquare = start;
        this.targetSquare = target;
    }

    public int getStartSquare() {
        return this.startSquare;
    }

    public int getTargetSquare(){
        return this.targetSquare;
    }
}
