package sample.Model;

import java.util.Random;

public class Rand {

	/**
	 * Method choosing withc player will start a game
	 *
	 * @param playerTab
	 *            Table of players
	 * @return Table of players
	 */
	public Player[] whoStarts(Player[] playerTab) {
		int player1Number;
		int player2Number;

		Player player1 = new Player("Player 1");
		Player player2 = new Player("Player 2");
		player1Number = createRandomNumber();
		player2Number = createRandomNumber();

		do {
			if (player1Number > player2Number) {
				player1.setSymbol(Symbols.X.getSymbol());
				player2.setSymbol(Symbols.O.getSymbol());
				playerTab[0] = player1;
				playerTab[1] = player2;
			} else {
				player2.setSymbol(Symbols.X.getSymbol());
				player1.setSymbol(Symbols.O.getSymbol());
				playerTab[0] = player2;
				playerTab[1] = player1;
			}
		} while (player1Number == player2Number);
		return playerTab;
	}

	/**
	 * Methods create random number (0-1000)
	 *
	 * @return Random number
	 */
	public int createRandomNumber() {
		Random rand = new Random();
		int number = rand.nextInt(1000);
		return number;
	}
}
