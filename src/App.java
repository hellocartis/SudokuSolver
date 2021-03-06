
public class App {

    
    public static void main(String[] args) {

        SudokuGame game2 = setupGame2();
        game2.displayGame();
        SudokuSolver solved = new SudokuSolver(game2);
        solved.print();
        solved.solve().displayGame();

    }

    static SudokuGame setupGame2() {
        int[][] matrix = 
            {
                {0,0,0,2,6,0,7,0,1}, // Row 0
                {6,8,0,0,7,0,0,9,0}, // Row 1
                {1,9,0,0,0,4,5,0,0}, // Row 2
                {8,2,0,1,0,0,0,4,0}, // Row 3
                {0,0,4,6,0,2,9,0,0}, // Row 4
                {0,5,0,0,0,3,0,2,8}, // Row 5
                {0,0,9,3,0,0,0,7,4}, // Row 6
                {0,4,0,0,5,0,0,3,6}, // Row 7
                {7,0,3,0,1,8,0,0,0}, // Row 8

            };
        return new SudokuGame(matrix);
    }
}
