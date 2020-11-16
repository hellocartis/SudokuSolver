
public class App {

    
    public static void main(String[] args) throws Exception {
        SudokuGame game = new SudokuGame();
        
        setupGame1(game);
        game.displayGame();

        while (game.getCompleted() == false) {
            // do nothing
        }

        
    }

    static void setupGame1(SudokuGame g) {
        g.setNode(0, 3, 2);
        g.setNode(0, 4, 6);
        g.setNode(0, 6, 7);
        g.setNode(0, 8, 1);

        g.setNode(1, 0, 6);
        g.setNode(1, 1, 8);
        g.setNode(1, 4, 7);
        g.setNode(1, 7, 9);

        g.setNode(2, 0, 1);
        g.setNode(2, 1, 9);
        g.setNode(2, 5, 4);
        g.setNode(2, 6, 5);

        g.setNode(3, 0, 8);
        g.setNode(3, 1, 2);
        g.setNode(3, 3, 1);
        g.setNode(3, 7, 4);
     
        g.setNode(4, 2, 4);
        g.setNode(4, 3, 6);
        g.setNode(4, 5, 2);
        g.setNode(4, 6, 9);

        g.setNode(5, 1, 5);
        g.setNode(5, 5, 3);
        g.setNode(5, 7, 2);
        g.setNode(5, 8, 8);

        g.setNode(6, 2, 9);
        g.setNode(6, 3, 3);
        g.setNode(6, 7, 7);
        g.setNode(6, 8, 4);

        g.setNode(7, 1, 4);
        g.setNode(7, 5, 5);
        g.setNode(7, 7, 3);
        g.setNode(7, 8, 6);

        g.setNode(8, 0, 7);
        g.setNode(8, 2, 3);
        g.setNode(8, 4, 1);
        g.setNode(8, 5, 8);

        
    }
}
