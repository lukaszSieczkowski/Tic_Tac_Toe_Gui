package sample.Model;

import javafx.scene.control.Label;

public class Checker {

	/**
	 * Methods checks if fulfilled condition to end a game (three field with one
	 * sign)
	 *
	 * @param tab
	 *            Table of fields
	 * @return gameOver
	 */
	public boolean checkThreeFliedsValue(String[][] tab) {
		boolean isEndOfTheGame = true;
		if ((tab[0][0] == ("X") && tab[0][1] == ("X") && tab[0][2] == ("X")
				|| (tab[0][0] == ("O") && tab[0][1] == ("O") && tab[0][2] == ("O")))) {
			isEndOfTheGame = true;
		} else if ((tab[1][0] == ("X") && tab[1][1] == ("X") && tab[1][2] == ("X"))
				|| (tab[1][0] == ("O") && tab[1][1] == ("O") && tab[1][2] == ("O"))) {
			isEndOfTheGame = true;
		} else if ((tab[2][0] == ("X") && tab[2][1] == ("X") && tab[2][2] == ("X"))
				|| (tab[2][0] == ("O") && tab[2][1] == ("O") && tab[2][2] == ("O"))) {
			isEndOfTheGame = true;
		} else if ((tab[0][0] == ("X") && tab[1][0] == ("X") && tab[2][0] == ("X"))
				|| (tab[0][0] == ("O") && tab[1][0] == ("O") && tab[2][0] == ("O"))) {
			isEndOfTheGame = true;
		} else if ((tab[0][1] == ("X") && tab[1][1] == ("X") && tab[2][1] == ("X"))
				|| (tab[0][1] == ("O") && tab[1][1] == ("O") && tab[2][1] == ("O"))) {
			isEndOfTheGame = true;
		} else if ((tab[0][2] == ("X") && tab[1][2] == ("X") && tab[2][2] == ("X"))
				|| (tab[0][2] == ("O") && tab[1][2] == ("O") && tab[2][2] == ("O"))) {
			isEndOfTheGame = true;
		} else if ((tab[0][0] == ("X") && tab[1][1] == ("X") && tab[2][2] == ("X"))
				|| (tab[0][0] == ("O") && tab[1][1] == ("O") && tab[2][2] == ("O"))) {
			isEndOfTheGame = true;
		} else if ((tab[0][2] == ("X") && tab[1][1] == ("X") && tab[2][0] == ("X"))
				|| (tab[0][2] == ("O") && tab[1][1] == ("O") && tab[2][0] == ("O"))) {
			isEndOfTheGame = true;
		} else {
			isEndOfTheGame = false;
		}
		return isEndOfTheGame;
	}

	/**
	 * Method checks is game over and sets information on Infolable and sets
	 * wining symbol and green color on all game fields
	 *
	 * @param tab
	 *            Game table
	 * @param infoLabel
	 *            Infolabel
	 * @param lableTable
	 *            Table of all gaming fields
	 * @param playerTable
	 *            Table of players
	 * @return game over
	 */
	public boolean checkWin(String[][] tab, Label infoLabel, Label[] lableTable, Player[] playerTable) {

		Checker checker = new Checker();
		boolean win;

		win = checker.checkThreeFliedsValue(tab);
		if (win == true) {
			Sounds sound = new Sounds();
			Style style = new Style();
			sound.playSound("applause.wav");

			infoLabel.setText(playerTable[1].getPlayerName() + " WON !!!!!");
			String symbol = playerTable[1].getSymbol();
			style.setWinStyle(lableTable, symbol);
		}
		return win;
	}

	/**
	 * Method checks are all gaming fields are ocupied
	 *
	 * @param tab
	 *            Game table
	 * @param infoLabel
	 *            Infolabel
	 * @param lableTable
	 *            Table of players
	 * @return game over
	 */
	public boolean checkTableIsFull(String[][] tab, Label infoLabel, Label[] lableTable) {
		int counter = 0;
		boolean fulTable;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (tab[i][j] == null) {
					counter++;
				}
			}
		}
		if (counter == 0) {
			Style style = new Style();
			infoLabel.setText("Nobody Won !!!");
			style.setTableColor(lableTable);
			style.clearTable(tab);
			style.clearSymbol(lableTable);
			fulTable = true;
		} else {
			fulTable = false;
		}
		return fulTable;
	}

}
