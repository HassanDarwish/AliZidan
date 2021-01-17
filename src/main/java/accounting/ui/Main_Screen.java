package accounting.ui;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;

public class Main_Screen extends JFrame implements WindowListener  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6239582361955983191L;

	private Main_Screen(int width, int height) {
		
	 
		 addWindowListener(this);
		
		setSize(width, height);
        setLocationRelativeTo(null);
        setVisible(true);
	}
	
	
	 
	public static class Builder {
		Main_Screen current;
		public Builder(){
			
		}
		
		public	void  build(int width,int height,int toolbar,int toolbar_type) {
			current=new Main_Screen(width,height);
			if(toolbar==1 & toolbar_type==1)
				build_toolbar(toolbar_type);
	 
		}
		void build_toolbar(int toolbar_type) {
			 
			ArrayList<String> items=new ArrayList<String>();
			String key="File";
			items.add("Save");
			
			HashMap<String,ArrayList<String>> MenuAnditems=new HashMap<String,ArrayList<String>>();
			MenuAnditems.put(key, items);
			
			JMenu_account menu =new JMenu_account.Builder(MenuAnditems).build();
			current.setJMenuBar(menu);
			
		}
		
	}












	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}










	public void windowClosing(WindowEvent arg0) {
		 
	    System.exit(0);
	  }










	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		 
	    System.exit(0);
		
	}












	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}












	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}












	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}












	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}
