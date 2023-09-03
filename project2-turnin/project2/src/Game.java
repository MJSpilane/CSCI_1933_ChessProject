import java.util.Scanner;
public class Game {
    public static void main(String[] args) {
        Board board = new Board();
        Fen.load("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR", board);
        Scanner s = new Scanner(System.in);
        while (true) {
            System.out.println(board);
            if (board.isWhiteTurn) {
                System.out.println("White's turn. What is your move? (format:[start row],[start col],[end row],[end col])");
                try {
                    String move = s.next();
                    String[] splitMove = move.split(",");
                    board.movePiece(Integer.parseInt(splitMove[0]), Integer.parseInt(splitMove[1]), Integer.parseInt(splitMove[2]), Integer.parseInt(splitMove[3]));
                    for(int i=0; i<8;i++){
                        if(board.getPiece(0,i).getCharacter() == '\u2659'){
                            while(true) {
                                System.out.println("White pawn promoted! Please input which piece you would like it to be (r,k,q,b,p)");
                                String choice = s.next();
                                if(choice.equals("r") || choice.equals("k") || choice.equals("q") || choice.equals("b") || choice.equals("p")) {
                                    board.getPiece(0, i).pawnPromotion(board, choice);
                                    break;
                                }
                                else{
                                    System.out.println("invalid input, try again");
                                    continue;
                                }
                            }
                        }
                        if(board.getPiece(0,i).getCharacter() == '\u265f'){
                            while(true) {
                                System.out.println("Black pawn promoted! Please input which piece you would like it to be (r,k,q,b,p)");
                                String choice = s.next();
                                if(choice.equals("r") || choice.equals("k") || choice.equals("q") || choice.equals("b") || choice.equals("p")) {
                                    board.getPiece(0, i).pawnPromotion(board, choice);
                                    break;
                                }
                                else{
                                    System.out.println("invalid input, try again");
                                    continue;
                                }
                            }
                        }
                    }
                    if (board.isGameOver()) {
                        System.out.println("Game is Over! White wins!");
                        break;
                    }
                    board.isWhiteTurn = false;
                } catch (Exception e) {
                    System.out.println("Invalid Input, try again. Format:[start row],[start col],[end row],[end col]");
                    continue;
                }
            } else {
                System.out.println(board);
                System.out.println("Black's turn. What is your move? (format:[start row],[start col],[end row], [end col])");
                try {
                    String move = s.next();
                    String[] splitMove = move.split(",");
                    board.movePiece(Integer.parseInt(splitMove[0]), Integer.parseInt(splitMove[1]), Integer.parseInt(splitMove[2]), Integer.parseInt(splitMove[3]));
                    for(int i=0; i<8;i++){
                        if(board.getPiece(0,i).getCharacter() == '\u2659'){
                            while(true) {
                                System.out.println("White pawn promoted! Please input which piece you would like it to be (r,k,q,b,p)");
                                String choice = s.next();
                                if(choice.equals("r") || choice.equals("k") || choice.equals("q") || choice.equals("b") || choice.equals("p")) {
                                    board.getPiece(0, i).pawnPromotion(board, choice);
                                    break;
                                }
                                else{
                                    System.out.println("invalid input, try again");
                                    continue;
                                }
                            }
                        }
                        if(board.getPiece(0,i).getCharacter() == '\u265f'){
                            while(true) {
                                System.out.println("Black pawn promoted! Please input which piece you would like it to be (r,k,q,b,p)");
                                String choice = s.next();
                                if(choice.equals("r") || choice.equals("k") || choice.equals("q") || choice.equals("b") || choice.equals("p")) {
                                    board.getPiece(0, i).pawnPromotion(board, choice);
                                    break;
                                }
                                else{
                                    System.out.println("invalid input, try again");
                                    continue;
                                }
                            }
                        }
                    }
                    if (board.isGameOver()) {
                        System.out.println("Game is Over! Black Wins!");
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("Invalid Input, try again. Format:[start row],[start col],[end row],[end col]");
                    continue;
                }
            }
        }
    }
}
