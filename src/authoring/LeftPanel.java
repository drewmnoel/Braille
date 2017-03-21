package authoring;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class LeftPanel<E> extends JPanel {
	/** Autogenerated serial */
	private static final long serialVersionUID = 2716138356085893186L;

	private JScrollPane scrollPane = new JScrollPane();
	private JList<E> commandList = new JList<>();
	private DefaultListModel<E> listModel = new DefaultListModel<>();

	private GUI gui;

	/**
	 * Create a new left panel of the GUI.
	 *
	 * @param gui
	 *            Reference to the overall GUI object
	 */
	public LeftPanel(GUI gui) {
		// Create a basic JPanel with a grid layout
		super(new GridLayout(1, 1));

		// Set the JList to have listModel as the content
		commandList.setModel(listModel);

		// Set the scollpane to have commandList as its content
		scrollPane.setViewportView(commandList);

		// Create a border around this panel
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Scenario"));

		// Add the scrollpane to this panel
		add(scrollPane);

		this.gui = gui;
	}

	/**
	 * Swap two string elements in the list, given their indices
	 *
	 * @param a
	 *            Parameter to swap
	 * @param b
	 *            Parameter to be swapped with
	 */
	private void swapElements(int a, int b) {
		// Get the element at each of the requested locations
		E strA = listModel.getElementAt(a);
		E strB = listModel.getElementAt(b);

		// Swap the elements and their indices
		listModel.set(a, strB);
		listModel.set(b, strA);
	}

	/**
	 * Add an element to the scrollpane in the left panel
	 *
	 * @param newElement
	 *            New element to be added
	 */
	public void addItem(E newElement) {
		listModel.addElement(newElement);
	}

	/**
	 * Move the currently selected element one spot higher in the list. If the
	 * selected element is already the top element, this method will gracefully
	 * do nothing.
	 */
	public void moveUp() {
		// Get the index of the selected element
		int selectedIndex = commandList.getSelectedIndex();

		// Do not move the top element "up"!
		if (selectedIndex == 0) {
			return;
		}

		// Swap the element with the one above it
		swapElements(selectedIndex, selectedIndex - 1);

		// Update the highlight position
		commandList.setSelectedIndex(selectedIndex - 1);
	}

	/**
	 * Move the currently selected element one spot lower in the list. If the
	 * selected element is already the bottom element, this method will
	 * gracefully do nothing.
	 */
	public void moveDown() {
		// Get the index of the selected element
		int selectedIndex = commandList.getSelectedIndex();

		// Do not move the bottom "down"!
		if (selectedIndex == listModel.size() - 1) {
			return;
		}

		// Swap the element with the one below it
		swapElements(selectedIndex, selectedIndex + 1);

		// Update the highlight position
		commandList.setSelectedIndex(selectedIndex + 1);
	}

	/**
	 * Remove the currently selected element from the list completely.
	 */
	public void deleteItem() {
		// Get the index of the selected element
		int selectedIndex = commandList.getSelectedIndex();

		// Remove that position from the listModel
		listModel.remove(selectedIndex);
	}
}
