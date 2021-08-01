public class GameOfLIfe {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Number Of Rows and Cols In Your Board");
		int r = sc.nextInt();
		int c = sc.nextInt();

		Cell[][] board = new Cell[r][c];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.println("Enter Cell State And Cell Name for Post " + i + j);
				board[i][j] = new Cell(sc.nextInt(), sc.next());

			}
		}

		printBoard(board);
		for (int i = 0; i < 4; i++) {
			System.out.println();
			board = getNextBoard(board);

		}
		printBoard(board);
		System.out.println();
	}

	public static void printBoard(Cell[][] b) {

		for (int i = 0, e = b.length; i < e; i++) {

			for (int j = 0, f = b[i].length; j < f; j++) {
				System.out.print(b[i][j] + ",");
			}
			System.out.println();
		}
	}

	public static Cell[][] getNextBoard(Cell[][] b) {

		if (b.length == 0 || b[0].length == 0) {

		}

		int nrRows = b.length;
		int nrCols = b[0].length;

		Cell[][] buf = new Cell[nrRows][nrCols];

		for (int row = 0; row < nrRows; row++) {

			for (int col = 0; col < nrCols; col++) {
				int state = getNewCellState(b[row][col].getLife(), getLiveNeighbours(row, col, b));
				buf[row][col] = new Cell(state, b[row][col].getCellname());
			}
		}
		return buf;
	}

	public static int getLiveNeighbours(int cellRow, int cellCol, Cell[][] b) {

		int liveNeighbours = 0;
		int rowEnd = Math.min(b.length, cellRow + 2);
		int colEnd = Math.min(b[0].length, cellCol + 2);

		for (int row = Math.max(0, cellRow - 1); row < rowEnd; row++) {

			for (int col = Math.max(0, cellCol - 1); col < colEnd; col++) {

				if ((row != cellRow || col != cellCol) && b[row][col].getLife() == 1) {
					liveNeighbours++;
				}
			}
		}
		return liveNeighbours;
	}

	public static int getNewCellState(int curState, int liveNeighbours) {

		int newState = curState;

		switch (curState) {
		case 1:

			if (liveNeighbours < 2)
				newState = 1;

			if (liveNeighbours == 2 || liveNeighbours == 3)
				newState = 1;

			if (liveNeighbours > 3)
				newState = 0;

			break;
		case 0:

			if (liveNeighbours == 3) {
				newState = 1;
			}

		}
		return newState;
	}

}
 