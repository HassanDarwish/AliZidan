package accounting.ui;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SpringLayout;
import javax.swing.tree.DefaultMutableTreeNode;

import accounting.enums.constants;
import accounting.model.dao.StudentDao;
import accounting.model.entity.student;
import accounting.ui.jcomponent.Jtree_accounts;

public class Main_Screen extends JFrame implements WindowListener  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6239582361955983191L;

	    
	private Main_Screen(int width, int height) {
		
		StudentDao studentDao = new StudentDao();

        student student = new student("Ramesh", "Fadatare", "ramesh@gmail.com");
        studentDao.saveStudent(student);

        System.out.println(student.getId());
		
		  
        SpringLayout layout = new SpringLayout();  
        getContentPane().setLayout(layout);  
       
       //JTree  jtree=new Jtree_accounts.Builder().build(constants.jtree_accounts);
        
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
        DefaultMutableTreeNode mercury = new DefaultMutableTreeNode("Mercury");
        root.insert(mercury, 0);
        DefaultMutableTreeNode venus = new DefaultMutableTreeNode("Venus");
        root.insert(venus, 1);
        DefaultMutableTreeNode mars = new DefaultMutableTreeNode("java2s.com");
        root.insert(mars, 2);
        JTree tree = new JTree(root);
        tree=new Jtree_accounts.Builder().build(constants.jtree_accounts);
        JScrollPane scrollPane = new JScrollPane(tree);
        
         
        layout.putConstraint(SpringLayout.WEST, scrollPane,6, SpringLayout.WEST, this.getContentPane());
        layout.putConstraint(SpringLayout.NORTH, scrollPane,6, SpringLayout.NORTH, this.getContentPane());
        
        
        this.getContentPane().add(scrollPane);
		
        tree.expandRow(1);
        tree.scrollRowToVisible(2);
        tree.revalidate();

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
			
			JMenu_account menu =new JMenu_account.Builder(MenuAnditems,constants.Main_Saceen_Menu).build();
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
