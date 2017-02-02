package edu.pitt.is1017.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddButton implements ActionListener{
	
	private Controller controller;
	
	public AddButton(Controller controller){
		this.controller = controller;
	}
	
	public void actionPerformed(ActionEvent e) {
		String enteredText = controller.getView().getItemArea().getText();
		
		if(enteredText.isEmpty()){
		} else {
			controller.getView().getListModel().addElement(enteredText);
			
			int i= controller.getModel().addDatabaseItem(enteredText);
			
			controller.getModel().addListItem(enteredText,i);
			
			controller.getView().getItemArea().setText(null);	
		}
		
	}

}
