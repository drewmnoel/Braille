package simulator;

import java.util.Scanner;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class CreateCells extends Application {

	/** Number of columns wide a Braille cell is */
	private static final int BRAILLE_WIDTH = 2;
	/** Number of rows tall a Braille cell is */
	private static final int BRAILLE_HEIGHT = 4;
	/** Maximum rows this screen will have */
	private static final int SCREEN_ROWS = 10;
	/** Radius of Braille dot */
	static final int BRAILLE_DOT_RADIUS = 5;
	/** Length of Braille box */
	static final int BRAILLE_BOX_SIDE = 40;

	@Override
	public void start(Stage primaryStage) throws Exception {
		Scanner stdin = new Scanner(System.in);

		// Get the word to show
		System.out.print("Word to display? ");
		String brailleText = stdin.nextLine();

		// Get the number of buttons
		System.out.print("Number of buttons? ");
		int numButtons = stdin.nextInt();

		primaryStage.setTitle("Enjoy your game.");

		SimulatorCore simCore = new SimulatorCore(brailleText.length(), numButtons);

		// Set the strings
		int[][] nCells = BrailleTextTranslator.translate(brailleText);
		for (int i = 0; i < brailleText.length(); i++) {
			simCore.setCell(i, nCells[i]);
		}

		TilePane grid = new TilePane();
		// grid.getStyleClass().add("game-grid");

		// TODO: Make programatically generated
		Button yes = new Button("YES");
		Button no = new Button("NO");

		// Layout each of the cells
		for (int k = 0; k < simCore.numOfCells(); k++) {
			// Create a running index
			int[] cellArray = simCore.cellAt(k);
			GridPane secondary = new GridPane();

			int runningIndex = 0;
			for (int i = 0; i < BRAILLE_WIDTH; i++) {
				for (int j = 0; j < BRAILLE_HEIGHT; j++) {
					Pane pane = new Pane();
					pane.setPrefSize(BRAILLE_BOX_SIDE, BRAILLE_BOX_SIDE);
					pane.getChildren().add(BrailleCircle.getCircle(cellArray, runningIndex));
					pane.getStyleClass().add("game-grid-cell");
					secondary.add(pane, i + (3 * k), j);

					runningIndex++;
				}
			}
			grid.getChildren().add(secondary);
			grid.setHgap(20);
			grid.setVgap(20);
		}

		// Scene width will be approx 3 braille boxes wide per braille cell
		// (except only 2 on last cell)
		int sceneWidth = 3 * BRAILLE_BOX_SIDE * brailleText.length() - BRAILLE_BOX_SIDE;

		// Scene height will be approx the height of 1 cell plus one more box
		int sceneHeight = ((BRAILLE_HEIGHT + 1) * BRAILLE_BOX_SIDE);

		Scene scene = new Scene(grid);
		scene.getStylesheets().add("application.css");

		primaryStage.setScene(scene);
		primaryStage.show();

		stdin.close();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
