import java.awt.color.ICC_ColorSpace;

public class Rook {
    int row;
    int col;
    boolean isBlack;
    public Rook(int row, int col, boolean isBlack){
        this.row = row;
        this.col = col;
        this.isBlack= isBlack;
    }
    public boolean isMoveLegal(Board board, int endRow, int endCol){
        if(endRow>7 || endCol>7){
            return false;//out of bounds
        }
        if (board.getPiece(endRow, endCol) != null){
            if (board.getPiece(endRow, endCol).getIsBlack() == this.isBlack){
                return false;//can't move into a piece of the same color
            }
        }
        //Case 1: rook is moving horizontal
        if(board.verifyHorizontal(this.row, this.col, endRow, endCol)){
            //Case 1a: Rook is moving left
            if(this.col-endCol>0){
                for(int i=1; i<(Math.abs(this.col - endCol));i++){
                    if(board.getPiece(this.row, (this.col-i)) != null){
                        return false; //there is a piece in the way
                    }
                }
                return true; //the move is good!
            }
            //Case 1b: Rook is moving right
            if(this.col-endCol<0){
                for(int i=1; i<(Math.abs(this.col-endCol)); i++){
                    if(board.getPiece(this.row, (this.col+i)) != null){
                        return false; //there is a piece in the way
                    }
                }
                return true; //move is good!
            }
        }
        //Case 2: rook is moving vertical
        if(board.verifyVertical(this.row, this.col, endRow, endCol)){
            //case 2a: Rook is moving up
            if((this.row-endRow) > 0){
                for(int i =1;i<(Math.abs(this.row-endRow));i++){
                    if(board.getPiece((this.row-i),this.col) != null){
                        return false; //There is a piece in the way
                    }
                }
                return true; //move is good!
            }
            //Case 2b: Rook is moving down
            else{
                for(int i =1;i<(Math.abs(this.row-endRow));i++){
                    if(board.getPiece((this.row+i),this.col) != null){
                        return false; //There is a piece in the way
                    }
                }
                return true; //move is good!
            }
        }
        return false;
    }
}
