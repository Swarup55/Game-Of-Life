public class Cell {
	enum state {
		LIFE, DEAD;
	}

	private int life;
	private String cellname;

	public Cell() {

	}

	public Cell(int life, String cellname) {
		super();
		this.life = life;
		this.cellname = cellname;
	}

	@Override
	public String toString() {
		return "Cell [life=" + life + ", cellname=" + cellname + "]";
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	public String getCellname() {
		return cellname;
	}

	public void setCellname(String cellname) {
		this.cellname = cellname;
	}

}