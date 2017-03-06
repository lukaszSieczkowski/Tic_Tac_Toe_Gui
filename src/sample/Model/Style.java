package sample.Model;

import javafx.scene.control.Label;

public class Style {
	/**
	 * Method set information about game on Info label
	 */
	public void setLabel(Player player, Label label) {
		label.setText("Your move " + player.getPlayerName());
	}

	/**
	 * Method cleans color on all game fields
	 *
	 * @param labelTable
	 */
	public void setTableColor(Label[] labelTable) {
		for (int i = 0; i < 9; i++) {
			labelTable[i].setStyle("-fx-background-color: #ebeef4");
		}
	}

	/**
	 * Method sets green color and winner symbol on all fields
	 *
	 * @param labelTable
	 *            Table of labels
	 * @param symbol
	 */
	public void setWinStyle(Label[] labelTable, String symbol) {
		for (int i = 0; i < 9; i++) {
			labelTable[i].setText(symbol);
			labelTable[i].setStyle("-fx-background-color: #c8e6c9");
		}
	}

	/**
	 * Method clears all fields from symbol
	 *
	 * @param labelTable
	 */
	public void clearSymbol(Label[] labelTable) {
		for (int i = 0; i < 9; i++) {
			labelTable[i].setText(" ");
		}

	}

	/**
	 * Method clears game table
	 *
	 * @param tab
	 *            Game table
	 */
	public void clearTable(String[][] tab) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				tab[i][j] = null;
			}
		}
	}
}
