public class King {
    int row;
    int col;
    boolean isBlack;
    public King(int row, int col, boolean isBlack){
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;
    }
    public boolean isMoveLegal(Board board, int endRow, int endCol){
        if(endRow>7 || endCol>7){
            return false;//out of bounds
        }
        //Move must be adjacent
        if(board.getPiece(endRow, endCol) != null){
            if(this.isBlack == board.getPiece(endRow, endCol).getIsBlack()){
                return false;//can't move into a piece of the same color
            }
        }
        if( board.verifyAdjacent(this.row, this.col, endRow, endCol)){
            return true;//move is good!
        }
        return false;// move is not adjacent
    }
}
