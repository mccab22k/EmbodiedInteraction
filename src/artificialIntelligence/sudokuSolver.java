package artificialIntelligence;
import java.io.File;
import java.util.Scanner;
/**
 * Code for Sudoku Assignment 
 * @author mccab
 *
 */
public class sudokuSolver {
	int grid[][] = new int[9][3]; //[size of the big grid] [size of the smaller one] 
	
	/**
	 * Constructor passes in the starting file test cases
	 * testCase1.text, testCase2.txt, testCase3.txt
	 * @param filename
	 */
	public sudokuSolver(String filename) {
		loadPuzzle(filename);
	}
	
	/**
	 * loadPuzzle opens the file passed in, reads input, and
	 * stores the numbers (0-9) in the 2D array 'grid'.
	 * @param filename
	 */
	private void loadPuzzle(String filename) {
		int row = 0, col = 0;
		try {
			File f = new File(filename);
			Scanner input = new Scanner(f);
			while (input.hasNext()) {
				grid[row][col] = Integer.parseInt(input.next());
				if (col < 8) {
					col++;
				} else {
					col = 0;
					row++;
				}
			}
			input.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean solvePuzzle() {
		if(!emptySpots())
			return true;
		
		for(int i=0; i<8; i++){
			for(int j=0; j<8; j++){
				if(grid[i][j] == 0) {
					for(int value = 1; value < 10; value++) {
						if(isMoveValid(i,j,value)){
							grid[i][j] = value;
							if(!solvePuzzle()) {
								grid[i][j] = 0;
							}
							else {
								return true;
							}
						}
					}
					return false;
				}
			}
		}
		return false;
		
	}
	
	/**
	 * @author sujin
	 */
	public void printGrid() {
		int row =0;
		int col=0;
		while(row!=8 && col!= 8){
			System.out.print(grid[row][col]+" ");
			col++;
			if(col==3||col==6)
				System.out.print("| ");
			if(col==8){
				System.out.println();
				row++;
				col=0;
			}
			if((row==3&&col==0)||(row==6 &&col==0))
				System.out.println("------+-------+------");
		}
		System.out.println();
	}
	
	/**
	 * @param row,col - coordinate to check
	 * @param testValue - potential value to test in specified location
	 * @return
	 */
	private boolean isMoveValid(int row, int col, int testValue) {
	      int thisRow = row-row%3;
	      int thisCol = col-col%3;

	      for(int i=0; i<8; i++){
	         if(grid[row][i]==testValue){
	            return false;
	         }
	      }

	      for(int i=0; i<8; i++){
	         if(grid[i][col]==testValue){
	            return false;
	         }
	      }

	      for(int i=thisRow; i<(thisRow+3); i++){
	         for(int j=thisCol; j<(thisCol+3); j++){
	            if(grid[i][j]==testValue){
	               return false;
	            }                          
	         }
	      }return true;
	   }
	
	/**
	 * TO COMPLETE FOR HOMEWORK
	 * @return
	 */
	private boolean emptySpots() {
		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				if(grid[i][j]==0)
					return true;
			}
		}
		return false; // change me (dummy return value)
	}
	
	/**
	 * main creates a new Sudoku object, prints the initial grid, 
	 * calls solvePuzzle, and prints the resulting grid.
	 * usage: java Sudoku test-input.txt
	 * @param args - expects one argument, name of input file
	 */
	public static void main(String[] args) {
		sudokuSolver s = new sudokuSolver(args[0]);
			
		System.out.println("Starting grid:");
		s.printGrid();
		
		
		System.out.println(s.emptySpots());
		// solve the puzzle
		s.solvePuzzle();
		
		System.out.println("Completed puzzle:");
		s.printGrid();
	}
}
