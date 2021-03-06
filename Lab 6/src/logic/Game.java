package logic;

public class Game {
	
	public static final int MAX_SHOTS = 4;
	private static final int INITIAL_SCORE = 1000;
	int score;
	int shots;
	private Board board; 
	private boolean invaderFound;
	
	public Board getBoard() {
		return board;
	}

	public Game(){
		initialize();
	}
	
	public void initialize(){
		board = new Board();
		score = INITIAL_SCORE;
		shots = 0;
	}

	public void shoot(int i){
		shots --;
		if (board.getCells()[i] instanceof Invader) {
			((Invader)board.getCells()[i]).setErased(true);
			invaderFound = true;
		}
		score = score + board.getCells()[i].getScore();
	}
	
	public boolean isGameOver() {
		return (invaderFound || shots == 0);
	}

	public int getScore() {
		return score;
	}

	public void launch() {
		setShots(Dice.launch());	
	}
	
	public int getShots() {
		return shots;
	}

	private void setShots(int shots) {
		this.shots = shots;
	}
}
