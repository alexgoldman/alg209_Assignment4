package edu.pitt.is1017.view;

import java.awt.Color;
import java.awt.TextField;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTextField;

import edu.pitt.is1017.controller.Controller;

public class View {
	
	
	 private JTextField itemArea;

	 private JFrame frmMain;

	 private JButton btnAdd;
	 
	 private JButton btnDelete;

	 private DefaultListModel listModel;
	 
	 private JList itemList;
	 
	 private Controller controller;
	 

	
	public View(){
		
		
		 frmMain = new JFrame();
		 frmMain.setLayout(null);
	     frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     frmMain.setSize(500, 350);
	     
	     itemArea = new JTextField();
	     itemArea.setBounds(20, 110, 120, 30);
	     
	     btnAdd = new JButton ("Add");
	     btnAdd.setBounds(180, 75, 80, 30);
	     
	     btnDelete = new JButton("Delete");
	     btnDelete.setBounds(180, 150, 80, 30);
	     
	     
	     itemList = new JList();
	     itemList.setBounds(300, 30, 150, 250);
	     itemList.setVisible(true);
	     
	     listModel = new DefaultListModel();
	     itemList.setModel(listModel);
	     itemList.setBorder(BorderFactory.createLineBorder(Color.black));

	     frmMain.add(itemArea);
	     frmMain.add(btnAdd);
	     frmMain.add(btnDelete);
	     frmMain.add(itemList);

	     
	     frmMain.setVisible(true);
		
	}



	public JButton getBtnAdd() {
		return btnAdd;
	}



	public JButton getBtnDelete() {
		return btnDelete;
	}



	public JTextField getItemArea() {
		return itemArea;
	}



	public DefaultListModel getListModel() {
		return listModel;
	}



	public JList getItemList() {
		return itemList;
	}
	


}
