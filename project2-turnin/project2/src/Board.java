public class Board {

    // Instance variables
    private Piece[][] board;
    public boolean isWhiteTurn;

    //TODO:
    // Construct an object of type Board using given arguments.
    public Board() {
        board = new Piece[8][8];
        isWhiteTurn = true;
    }

    // Accessor Methods

    //TODO:
    // Return the Piece object stored at a given row and column
    public Piece getPiece(int row, int col) {
        return board[row][col];
    }

    //TODO:
    // Update a single cell of the board to the new piece.
    public void setPiece(int row, int col, Piece piece) {
        board[row][col] = piece;
    }

    // Game functionality methods

    //TODO:
    // Moves a Piece object from one cell in the board to another, provided that
    // this movement is legal. Returns a boolean to signify success or failure.
    public boolean movePiece(int startRow, int startCol, int endRow, int endCol) {
        if (board[startRow][startCol] != null){
            if (board[startRow][startCol].isMoveLegal(this, endRow, endCol)){
                board[endRow][endCol] = board[startRow][startCol];
                board[startRow][startCol] = null;
                board[endRow][endCol].setPosition(endRow, endCol);
                return true;
            }
        }
        return false;
    }

    //TODO:
    // Determines whether the game has been ended, i.e., if one player's King
    // has been captured.
    public boolean isGameOver() {
        for(int i =0 ; i < 8; i++){
            for(int j=0; j<8; j++){
                if (board[i][j] == null){
                    continue;
                }
                if(board[i][j].getCharacter() == '\u2654'){
                    for(int x=0;x<8;x++){
                        for(int y =0; y<8; y++){
                            if(board[x][y] == null){
                                continue;
                            }
                            if (board[x][y].getCharacter() == '\u265a'){
                                return false;
                            }
                            else{
                                continue;
                            }
                        }
                    }
                }
                if (board[i][j].getCharacter() == '\u265a'){
                    for (int x =0;x<8;x++){
                        for(int y=0;y<8;y++){
                            if(board[x][y] == null){
                                continue;
                            }
                            if (board[x][y].getCharacter() == '\u2654'){
                                return false;
                            }
                            else{continue;}
                        }
                    }
                }
            }
        }
        return true;
    }

    //TODO:
    // Construct a String that represents the Board object's 2D array. Return
    // the fully constructed String.
    public String toString() {
        Piece currentPiece;
        String str = "\u2001"+"\u2001" + "\uFF10" + "\u2001" + "\uFF11" + "\u2001" + "\uFF12" + "\u2001" + "\uFF13" + "\u2001" + "\uFF14" + "\u2001"  + "\uFF15" + "\u2001"  + "\uFF16" + "\u2001"  + "\uFF17" + "\n";
        for(int i =0;i <8; i++){
            str += (i + " |");
            for(int j=0; j<8;j++){
                if(board[i][j] == null){
                    str += '\u2001' + "|";
                }
                else{
                    currentPiece = new Piece(board[i][j].getCharacter(), i, j, board[i][j].getIsBlack());
                    str += currentPiece + "|";
                }
            }
            str += "\n";
        }
        return str;
    }

    //TODO:
    // Sets every cell of the array to null. For debugging and grading purposes.
    public void clear() {
        for(int i =0;i<8;i++){
            for(int j =0; j<8;j++){
                board[i][j] = null;
            }
        }
    }

    // Movement helper functions

    //TODO:
    // Ensure that the player's chosen move is even remotely legal.
    // Returns a boolean to signify whether:
    // - 'start' and 'end' fall within the array's bounds.
    // - 'start' contains a Piece object, i.e., not null.
    // - Player's color and color of 'start' Piece match.
    // - 'end' contains either no Piece or a Piece of the opposite color.
    public boolean verifySourceAndDestination(int startRow, int startCol, int endRow, int endCol, boolean isBlack) {
        if (isBlack == false){
            if (board[startRow][startCol] != null){
                if (board[endRow][endCol].getIsBlack() == true){
                    return true;
                }
            }
        }
        if (isBlack == true){
            if (board[startRow][startCol] != null){
                if(board[endRow][endCol].getIsBlack() == false){
                    return true;
                }
            }
        }
        return false;
    }

    //TODO:
    // Check whether the 'start' position and 'end' position are adjacent to each other
    public boolean verifyAdjacent(int startRow, int startCol, int endRow, int endCol) {
        if (startRow+1 == endRow || startRow-1 == endRow || startRow == endRow){
            return startCol + 1 == endCol || startCol - 1 == endCol || startCol == endCol;
        }
        return false;
    }

    //TODO:
    // Checks whether a given 'start' and 'end' position are a valid horizontal move.
    // Returns a boolean to signify whether:
    // - The entire move takes place on one row.
    // - All spaces directly between 'start' and 'end' are empty, i.e., null.
    public boolean verifyHorizontal(int startRow, int startCol, int endRow, int endCol) {
        return startRow == endRow;
    }

    //TODO:
    // Checks whether a given 'start' and 'end' position are a valid vertical move.
    // Returns a boolean to signify whether:
    // - The entire move takes place on one column.
    // - All spaces directly between 'start' and 'end' are empty, i.e., null.
    public boolean verifyVertical(int startRow, int startCol, int endRow, int endCol) {
        return startCol == endCol;
    }

    //TODO:
    // Checks whether a given 'start' and 'end' position are a valid diagonal move.
    // Returns a boolean to signify whether:
    // - The path from 'start' to 'end' is diagonal... change in row and col.
    // - All spaces directly between 'start' and 'end' are empty, i.e., null.
    public boolean verifyDiagonal(int startRow, int startCol, int endRow, int endCol) {
        if (startRow+startCol == endRow+endCol){
            return true;
        }
        if (Math.abs(startRow-startCol) == Math.abs(endRow-endCol)){
            return true;
        }
        return false;
    }
}
