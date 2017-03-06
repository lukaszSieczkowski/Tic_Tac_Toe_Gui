package sample.Model;

import javafx.scene.control.Label;

public class Move {

	/**
	 * Method responsible for single human move
	 *
	 * @param label
	 *            Selected field
	 * @param infoLabel
	 *            Info label
	 * @param labelTable
	 *            Table of game labels
	 * @param i
	 *            X coordinate of field
	 * @param j
	 *            Y coordinate of field
	 * @param tab
	 *            Game table
	 * @param playerTab
	 *            Table of players
	 */
	public void playHumanMove(Label label, Label infoLabel, Label[] labelTable, int i, int j, String[][] tab,
			Player[] playerTab) {
		Sounds sound = new Sounds();
		Style style = new Style();
		String symbol;
		style.setTableColor(labelTable);
		if (tab[i][j] != "X" && tab[i][j] != "O") {
			symbol = playerTab[0].getSymbol();
			tab[i][j] = symbol;
			setSymbolOnBoard(labelTable, tab);
			sound.playSound("click.wav");
			switchPlayersAfterMove(playerTab);
			style.setLabel(playerTab[0], infoLabel);

		} else {
			sound.playSound("error.wav");
			label.setStyle("-fx-background-color: #ffab91");
		}
	}

	/**
	 * Method responsible for move execution and confirm condition should game
	 * be continued
	 *
	 * @param label
	 *            Selected field
	 * @param infoLabel
	 *            Info lable
	 * @param labelTable
	 *            Table of game labels
	 * @param i
	 *            X coordinate of field
	 * @param j
	 *            Y coordinate of field
	 * @param tab
	 *            Game table
	 * @param playerTab
	 *            Table of players
	 * @return ggame over
	 */
	public boolean singleMove(Label label, Label infoLabel, Label[] labelTable, int i, int j, String[][] tab,
			Player[] playerTab) {
		Checker checker = new Checker();
		boolean gameIsInProgress = true;
		boolean win;
		boolean fullTabb = true;
		playHumanMove(label, infoLabel, labelTable, i, j, tab, playerTab);
		win = checker.checkWin(tab, infoLabel, labelTable, playerTab);
		if (win != true) {
			fullTabb = checker.checkTableIsFull(tab, infoLabel, labelTable);
			if (fullTabb == true) {
				gameIsInProgress = false;
			}
		} else if (win == true) {
			gameIsInProgress = false;
		}
		return gameIsInProgress;
	}

	/**
	 * Methods sets symbols on lables from game table
	 *
	 * @param labels
	 *            table of lables
	 * @param tab
	 *            Game table
	 */
	public void setSymbolOnBoard(Label[] labels, String[][] tab) {
		labels[0].setText(tab[0][0]);
		labels[1].setText(tab[0][1]);
		labels[2].setText(tab[0][2]);
		labels[3].setText(tab[1][0]);
		labels[4].setText(tab[1][1]);
		labels[5].setText(tab[1][2]);
		labels[6].setText(tab[2][0]);
		labels[7].setText(tab[2][1]);
		labels[8].setText(tab[2][2]);
	}

	/**
	 * Method switch players
	 *
	 * @param playerTab
	 *            Table of players
	 */

	public void switchPlayersAfterMove(Player[] playerTab) {
		Player switcher = new Player();
		switcher = playerTab[0];
		playerTab[0] = playerTab[1];
		playerTab[1] = switcher;
	}
}
