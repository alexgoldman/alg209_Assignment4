package edu.pitt.is1017.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Vector;

import edu.pitt.is1017.model.ListItem;



public class DeleteButton implements ActionListener {
	
	private Controller controller;
	
	public DeleteButton(Controller controller){
		
		this.controller=controller;
		
	}
	
	public void actionPerformed(ActionEvent e) {
		int i = controller.getView().getItemList().getSelectedIndex();
		int modelID = 0;
		int d=0;
		
		
		
		if(controller.getView().getItemList().getSelectedValue()==null){
			controller.getView().getBtnDelete().setEnabled(false);
			controller.getView().getBtnDelete().setEnabled(true);
		}
		else{
			
		Vector<ListItem> item = controller.getModel().getList();
		Iterator<ListItem> iter = item.iterator();
		while(iter.hasNext()){
			ListItem lis = iter.next();
			System.out.println(i);
			
			System.out.println(modelID);
		      if(i==modelID )
		      {
		    	d=lis.getid();
		        iter.remove();
		        modelID++;
		      } else modelID++;
		}
		/*
		for(ListItem li : item) {
			System.out.println(li.getid());
			System.out.println(i);
			System.out.println(modelID);
		    if(i==modelID){
		    	d=li.getid();
		    	 toRemove.add(item);
		    	modelID++;
		    } else {
		    	modelID++;
		    }
		}
		for(ListItem li: item){
			System.out.println(li.getDescription());
		}
		*/
		controller.getModel().deleteDatabaseItem(d);
		controller.getView().getListModel().removeElementAt(i);
		controller.getModel().deleteListItem(i);
		}
	}

}
