package sample.Model;

import javafx.scene.control.TextInputDialog;

import java.util.Optional;

public class Player {

	private String playerName;
	private String symbol;

	public Player() {

	}

	/**
	 * Creates player from input window
	 *
	 * @param playerNumber
	 */
	public Player(String playerNumber) {
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Player Name");
		dialog.setHeaderText("Enter " + playerNumber + "  Name");
		dialog.setContentText("Please enter your name:");

		Optional<String> result = dialog.showAndWait();
		String name = null;
		if (result.isPresent()) {
			name = result.get();
		}
		playerName = name;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	@Override
	public String toString() {
		return "Player" + playerName + " " + symbol;
	}

}
