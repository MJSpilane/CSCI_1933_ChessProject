public class Queen {
    int row;
    int col;
    boolean isBlack;
    public Queen(int row, int col, boolean isBlack){
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;
    }
    public boolean isMoveLegal(Board board, int endRow, int endCol) {
        int currentRow = this.row;
        int currentCol = this.col;
        if(endRow>7 || endCol>7){
            return false;//out of bounds
        }
        if (board.getPiece(endRow, endCol) != null) {
            if (this.isBlack == board.getPiece(endRow, endCol).getIsBlack()) {
                return false;
            }
        }
        if (this.row == endRow && this.col == endCol) {
            return false;
        }
        //Case 1: Queen is moving horizontal
        if(board.verifyHorizontal(this.row, this.col, endRow, endCol)){
            //Case 1a: Queen is moving left
            if(this.col-endCol>0){
                for(int i=1; i<(Math.abs(this.col - endCol));i++){
                    if(board.getPiece(this.row, (this.col-i)) != null){
                        return false; //there is a piece in the way
                    }
                }
                return true; //the move is good!
            }
            //Case 1b: Queen is moving right
            if(this.col-endCol<0){
                for(int i=1; i<(Math.abs(this.col-endCol)); i++){
                    if(board.getPiece(this.row, (this.col+i)) != null){
                        return false; //there is a piece in the way
                    }
                }
                return true; //move is good!
            }
        }
        //Case 2:Queen is moving vertical
        if(board.verifyVertical(this.row, this.col, endRow, endCol)){
            //case 2a: Queen is moving up
            if((this.row-endRow) > 0){
                for(int i =1;i<(Math.abs(this.row-endRow));i++){
                    if(board.getPiece((this.row-i),this.col) != null){
                        return false; //There is a piece in the way
                    }
                }
                return true; //move is good!
            }
            //Case 2b: Queen is moving down
            else{
                for(int i =1;i<(Math.abs(this.row-endRow));i++){
                    if(board.getPiece((this.row+i),this.col) != null){
                        return false; //There is a piece in the way
                    }
                }
                return true; //move is good!
            }
        }
        //Case 3: Queen is moving diagonal
        if(board.verifyDiagonal(this.row, this.col, endRow, endCol)){
            //Case 3a:Queen is moving up and to the right
            if(((this.row-endRow) > 0) && (this.col-endCol) < 0){
                for(int i =1; i<(Math.abs(this.row-endRow));i++){
                    if(board.getPiece((this.row-i),(this.col+i)) != null){
                        return false;//there is a piece in the way
                    }
                }
                return true; //move is good!
            }
            //Case 3b: Queen is moving down and to the right
            if(((this.row-endRow) < 0) && (this.col-endCol) < 0){
                for(int i =1; i<(Math.abs(this.row-endRow));i++){
                    if(board.getPiece((this.row+i),(this.col+i)) != null){
                        return false;//there is a piece in the way
                    }
                }
                return true; //move is good!
            }
            //Case 3c: Queen is moving down and to the left
            if(((this.row-endRow) < 0) && (this.col-endCol) > 0){
                for(int i =1; i<(Math.abs(this.row-endRow));i++){
                    if(board.getPiece((this.row+i),(this.col-i)) != null){
                        return false;//there is a piece in the way
                    }
                }
                return true; //move is good!
            }
            //Case 3d: Queen is moving up and to the left
            if(((this.row-endRow) > 0) && (this.col-endCol) > 0){
                for(int i =1; i<(Math.abs(this.row-endRow));i++){
                    if(board.getPiece((this.row-i),(this.col-i)) != null){
                        return false;//there is a piece in the way
                    }
                }
                return true; //move is good!
            }
        }
        return false;
    }
}
