package sample.Model;

public enum Symbols {
	X("X"), O("O");

	String c;

	Symbols(String c) {
		this.c = c;
	}

	public String getSymbol() {
		return c;
	}

}
