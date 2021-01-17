package accounting.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.account.Bill;

public class JMenu_account extends JMenuBar  {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6026803433177177380L;


	private JMenu_account()
	{
		
		
    	
	}	

	
	public static class Builder {
		JMenu_account current;
		HashMap<String,ArrayList<String>> MenuAnditems;
		
		
		public Builder(HashMap<String,ArrayList<String>> MenuAnditems ){
			this.MenuAnditems=MenuAnditems;
		}
		
		public	JMenu_account build() {
			current =new  JMenu_account();
			
			for (Entry<String, ArrayList<String>> set : MenuAnditems.entrySet()) {
				JMenu menu=new JMenu(set.getKey()); 
				menu.add(new JMenuItem());
				ArrayList<String> list_item= set.getValue();
				
				 for (String temp : list_item) {
					 if(temp.equals("Save"))
					 {
						 JMenuItem item=new JMenuItem(temp);
						 item.addActionListener(new ActionListener() {
						        public void actionPerformed(ActionEvent ev) {
						        	ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
						        	Validator validator = factory.getValidator();
						        	
						        	Bill bill_user = new Bill();
						        	bill_user.setWorking(true);
						        	bill_user.setAboutMe("Its all about me!");
						        	bill_user.setAge(50);
						        	Set<ConstraintViolation<Bill>> violations = validator.validate(bill_user);
						        	
						        	for (ConstraintViolation<Bill> violation : violations) {
						        	   System.out.println(violation.getMessage()); 
						        	}
					        }
					    });
						 menu.add(item);	 
					 }else {
					 menu.add(new JMenuItem(temp));
					 }
				 }
			
				
				 JMenuItem exitItem = new JMenuItem("Exit");
				    exitItem.addActionListener(new ActionListener() {
				        public void actionPerformed(ActionEvent ev) {
				                System.exit(0);
				        }
				    });

				    menu.add(exitItem);
			    current.add(menu);
			}
			
		    
			return current;
			
		}
		
		
	}
}
