package sample.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import sample.Model.*;

public class Controller {
	@FXML
	private Label infoLabel;
	@FXML
	private Label label00;
	@FXML
	private Label label01;
	@FXML
	private Label label02;
	@FXML
	private Label label10;
	@FXML
	private Label label11;
	@FXML
	private Label label12;
	@FXML
	private Label label20;
	@FXML
	private Label label21;
	@FXML
	private Label label22;

	private Label[] lableTable;
	private Player[] playerTab = new Player[2];
	private boolean gameStarted;
	String[][] tab = new String[3][3];

	/**
	 * Method starts a new game;
	 */
	public void pvp() {
		lableTable = new Label[] { label00, label01, label02, label10, label11, label12, label20, label21, label22 };
		Rand rand = new Rand();
		Style style = new Style();
		style.setTableColor(lableTable);
		style.clearTable(tab);
		style.clearSymbol(lableTable);
		playerTab = rand.whoStarts(playerTab);
		infoLabel.setText(
				playerTab[0].getPlayerName() + " will start\n" + playerTab[0].getPlayerName() + " make a move.");
		gameStarted = true;
	}

	/**
	 * Method responsible for action in field 00
	 */
	public void click00() {
		action(label00, 0, 0);
	}

	/**
	 * Method responsible for action in field 01
	 */
	public void click01() {
		action(label01, 0, 1);
	}

	/**
	 * Method responsible for action in field 02
	 */
	public void click02() {
		action(label02, 0, 2);
	}

	/**
	 * Method responsible for action in field 10
	 */
	public void click10() {
		action(label10, 1, 0);
	}

	/**
	 * Method responsible for action in field 11
	 */
	public void click11() {
		action(label11, 1, 1);
	}

	/**
	 * Method responsible for action in field 12
	 */
	public void click12() {
		action(label12, 1, 2);
	}

	/**
	 * Method responsible for action in field 20
	 */
	public void click20() {
		action(label20, 2, 0);
	}

	/**
	 * Method responsible for action in field 21
	 */
	public void click21() {
		action(label21, 2, 1);
	}

	/**
	 * Method responsible for action in field 22
	 */
	public void click22() {
		action(label22, 2, 2);
	}

	/**
	 * Method responsible for single action in selected field
	 * 
	 * @param label
	 *            Selected field
	 * @param i
	 *            X coordinate of field
	 * @param j
	 *            Y coordinate of field
	 */
	public void action(Label label, int i, int j) {
		Move move = new Move();
		if (gameStarted == true) {
			gameStarted = move.singleMove(label, infoLabel, lableTable, i, j, tab, playerTab);

		} else {
			Sounds sound = new Sounds();
			sound.playSound("error.wav");
		}
	}
}
