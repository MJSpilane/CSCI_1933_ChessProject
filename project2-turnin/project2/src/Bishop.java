import java.awt.color.ICC_ColorSpace;

public class Bishop {
    int row;
    int col;
    boolean isBlack;
    public Bishop(int row, int col, boolean isBlack){
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;
    }
    public boolean isMoveLegal(Board board, int endRow,int endCol){
        if(endRow>7 || endCol>7){
            return false;//out of bounds
        }
        if(board.getPiece(endRow, endCol) != null){
            if(board.getPiece(endRow, endCol).getIsBlack() == this.isBlack){
                return false;
            }
        }
        //case 1: bishop is moving up and to the right
        if(((this.row-endRow) > 0) && (this.col-endCol) < 0){
            for(int i =1; i<(Math.abs(this.row-endRow));i++){
                if(board.getPiece((this.row-i),(this.col+i)) != null){
                    return false;//there is a piece in the way
                }
            }
            return true; //move is good!
        }
        //case 2: bishop is moving down and to the right
        if(((this.row-endRow) < 0) && (this.col-endCol) < 0){
            for(int i =1; i<(Math.abs(this.row-endRow));i++){
                if(board.getPiece((this.row+i),(this.col+i)) != null){
                    return false;//there is a piece in the way
                }
            }
            return true; //move is good!
        }
        //case 3: bishop is moving down and to the left
        if(((this.row-endRow) < 0) && (this.col-endCol) > 0){
            for(int i =1; i<(Math.abs(this.row-endRow));i++){
                if(board.getPiece((this.row+i),(this.col-i)) != null){
                    return false;//there is a piece in the way
                }
            }
            return true; //move is good!
        }
        //case 4: bishop is moving up and to the right
        if(((this.row-endRow) > 0) && (this.col-endCol) > 0){
            for(int i =1; i<(Math.abs(this.row-endRow));i++){
                if(board.getPiece((this.row-i),(this.col-i)) != null){
                    return false;//there is a piece in the way
                }
            }
            return true; //move is good!
        }
        return false;
    }
}
