package listeners;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import authoring.GUI;

public class NewScenarioListener implements ActionListener {

	private GUI gui;
	private JLabel cellLabel = new JLabel("Cell: " );
	private JLabel btnLabel = new JLabel("Button: " );
	private JLabel titleLabel = new JLabel("Title: " );
	private JTextField celltxt = new JTextField(5);
    private JTextField btntxt = new JTextField(5);
	private JTextField titletxt = new JTextField(5);
	private JPanel myPanel = new JPanel(new GridLayout(0, 1, 5, 5));
	
	public NewScenarioListener(GUI gui)
	{
		this.gui = gui;
	}
	
	public void scenarioBuilder() {
		gui.getLeftPanel().clearItem();

		 myPanel.add(cellLabel);
	     myPanel.add(celltxt); 

	     myPanel.add(btnLabel);
	     myPanel.add(btntxt); 
	     myPanel.add(titleLabel);
	     myPanel.add(titletxt);


	     int result = JOptionPane.showConfirmDialog(null, myPanel, 
	              "Enter the Scenario parameters", JOptionPane.OK_CANCEL_OPTION);
	     if (result == JOptionPane.OK_OPTION) {
	        gui.getSettingsPanel().setCellField(celltxt.getText());
	        gui.getSettingsPanel().setButtonFieldText(btntxt.getText());
	        gui.getSettingsPanel().setTitleField(titletxt.getText());

	     }
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(gui.getLeftPanel().elementCheck()) 
		{
			scenarioBuilder();
		 } else {
			 int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to start a new Scenario?"
			 		+ " All current changes will be lost", "Warning!", 
			 		JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION);
		     if (result == JOptionPane.YES_OPTION) {
		    	 scenarioBuilder();
		     }
		     
		 }
	   
		
		
	}
}