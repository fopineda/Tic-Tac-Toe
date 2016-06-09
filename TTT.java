package los_Classes;

import java.util.Scanner;

// Tic-Tac-Toe game
// Author: Felipe Pineda <fopineda95@gmail.com>

public class TTT {

	public boolean gameOver;
	public char[][] board;  //2 Dimensional array
	public boolean firstPlayer;
	
	public TTT(){
		gameOver = false;
		firstPlayer = true;
		board = new char[3][3];
		for(int i=0; i < 3; i++)
			for(int j=0; j<3;j++)
				board[i][j] = '-';
	}

	public void printBoard() {
		for(int i=0; i < 3; i++){
			for(int j=0; j<3;j++)
				System.out.print(board[i][j]+ " ");
			System.out.println();	
		}
	}
	
	public boolean isGameOver(){ //Starts with a false, needs to produce a true
		boolean result = false;
		
		// Rows
		if (this.board[0][0] != '-' && this.board[0][0] == this.board[0][1] && this.board[0][1] == this.board[0][2]){
			result = true;
		}if (this.board[1][0] != '-' && this.board[1][0] == this.board[1][1] && this.board[1][1] == this.board[1][2]){
			result = true;
		}
		if (this.board[2][0] != '-' && this.board[2][0] == this.board[2][1] && this.board[2][1] == this.board[2][2]){
			result = true;
		}
		
		// Columns
		if (this.board[0][0] != '-' && this.board[0][0] == this.board[1][0] && this.board[1][0] == this.board[2][0]){
			result = true;
		}
		if (this.board[0][1] != '-' && this.board[0][1] == this.board[1][1] && this.board[1][1] == this.board[2][1]){
			result = true;
		}
		if (this.board[0][2] != '-' && this.board[0][2] == this.board[1][2] && this.board[1][2] == this.board[2][2]){
			result = true;
		}
		
		// Diagonals
		if (this.board[0][0] != '-' && this.board[0][0] == this.board[1][1] && this.board[1][1] == this.board[2][2]){
			result = true;
		}
		if (this.board[0][2] != '-' && this.board[0][2] == this.board[1][1] && this.board[1][1] == this.board[2][0]){
			result = true;
		}

		return result;
	}
	
	public boolean isDraw(){  // Return true if the game is a draw; Return false if the game is not a draw
		boolean gameDraw = false;
		if (this.board[0][0] != '-' && this.board[0][1] != '-' && this.board[0][2] != '-' && this.board[1][0] != '-' && this.board[1][1] != '-' && this.board[1][2] != '-' && this.board[2][0] != '-' && this.board[2][1] != '-' && this.board[2][2] != '-' && isGameOver() == false){ //Something has to stop the while loop once no one has won.
			gameDraw = true;
		}
		return gameDraw;
	}

		@SuppressWarnings("resource")
		public void play(){
			Scanner console= new Scanner(System.in);

			int r,c;
			while(!isGameOver() && !isDraw()){  // Loop needs to stop when someone has won or it is a draw. True value stops the loop
				do{
					System.out.println("Please give me row and col 0,1,2:");
						r =console.nextInt();
						c =console.nextInt();
				}
				while(  (r< 0 || r > 2) ||  (c< 0 || c > 2) || board[r][c] !='-');
			
				board[r][c] = firstPlayer ?'X': 'O';
				firstPlayer  = !(firstPlayer);
				gameOver = isGameOver();  // Check every turn if the game has been won. (Returns the value to while loop)
				printBoard();
			} //End of while loop
			
			boolean fullOrNot = this.board[0][0] != '-' && this.board[0][1] != '-' && this.board[0][2] != '-' && this.board[1][0] != '-' && this.board[1][1] != '-' && this.board[1][2] != '-' && this.board[2][0] != '-' && this.board[2][1] != '-' && this.board[2][2] != '-';
//			String whoWon = firstPlayer ?"Second Player won":"First Player won";  // If FP is true, then SP won. IF FP is false, then FP won.
//			System.out.println(whoWon);
			
			if (firstPlayer == false && isDraw() != true){
				System.out.println("\nFirst player won");
			}
			else if (firstPlayer != false && isDraw() != true) {
				System.out.println("\nSecond Player won");
			}
			else if (fullOrNot == true && isDraw() == true){
				System.out.println("\nDraw");
			}
			
			//System.out.println("\n------------ Test prints ------------");
			//System.out.println("isGameOver() value is: "+isGameOver());
			//System.out.println("isDraw() value is: "+isDraw());
			//System.out.println("firstPlayer value is: "+firstPlayer);
			//System.out.println("Have all the spaces on the board been taken up: "+fullOrNot);
	
		}	
	
	
 public static void main(String[] args){
 	
 	TTT game = new TTT();
 	game.printBoard();
 	game.play();	
 }

}
