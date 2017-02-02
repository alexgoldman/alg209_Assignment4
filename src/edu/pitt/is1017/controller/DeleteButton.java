package edu.pitt.is1017.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import edu.pitt.is1017.model.ListItem;



public class DeleteButton implements ActionListener {
	
	private Controller controller;
	
	public DeleteButton(Controller controller){
		
		this.controller=controller;
		
	}
	
	public void actionPerformed(ActionEvent e) {
		int i = controller.getView().getItemList().getSelectedIndex();
		int j = 0;
		int d=0;
		
		
		
		
		if(controller.getView().getItemList().getSelectedValue()==null){
			controller.getView().getBtnDelete().setEnabled(false);
			controller.getView().getBtnDelete().setEnabled(true);
		}
		else{
		Vector<ListItem> item = controller.getModel().getList();
		for(ListItem li : item) {
			System.out.println(li.getid());
			System.out.println(i);
			System.out.println(j);
		    if(j==i){
		    	d=li.getid();
		    	
		    	j++;
		    } else {
		    	j++;
		    }
		}
		
		controller.getModel().deleteDatabaseItem(d);
		controller.getView().getListModel().removeElementAt(i);
		controller.getModel().deleteListItem(i);
		}
	}

}
