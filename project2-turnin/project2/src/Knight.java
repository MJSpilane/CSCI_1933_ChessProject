public class Knight {
    int row;
    int col;
    boolean isBlack;
    public Knight(int row, int col, boolean isBlack){
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;
    }
    public boolean isMoveLegal(Board board, int endRow, int endCol){
        if(endRow>7 || endCol>7){
            return false;//out of bounds
        }

        int rowChange = endRow - this.row;
        int colChange = endCol - this.col;
        if(board.getPiece(endRow, endCol) != null){
            if(board.getPiece(endRow, endCol).getIsBlack() == this.isBlack){
                return false;//piece of the same color is in that space
            }
        }
        //case 1: top most right position(up 2, right 1)
            if((rowChange == -2) && (colChange == 1)){
                return true;
            }
        //case 2: right most top position(up 1, right 2)
            if((rowChange== -1) && (colChange == 2)){
                return true;
            }
        //case 3: right most bottom position(down 1, right 2)
            if((rowChange == 1) && (colChange == 2)){
                return true;
            }
        //case 4: bottom most right position(down 2, right 1)
            if((rowChange == 2) && (colChange == 1)){
                return true;
            }
        //case 5: bottom most left position(down 2, left 1)
            if((rowChange == 2) && (colChange == -1)){
                return true;
            }
        //case 6: left most bottom position(down 1, left 2)
            if((rowChange == 1) && (colChange == -2)){
                return true;
            }
        //case 7: left most top position(up 1, left 2)
            if((rowChange == -1) && (colChange == -2)){
                return true;
            }
        //case 8: top most left position(up 2, left 1)
            if((rowChange ==-2) && (colChange == -1)){
                return true;
            }
            return false;
    }
}
