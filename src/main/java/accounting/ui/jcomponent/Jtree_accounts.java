package accounting.ui.jcomponent;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import accounting.enums.constants;

public class Jtree_accounts{

	private Jtree_accounts(DefaultMutableTreeNode x) {}
	
	
	
	
	
	public static class Builder{
		
		public Builder(){
			
		}
		
		
	public JTree	build(constants tree_type){
		
		if(tree_type.equals(constants.jtree_accounts)) {
	        
	        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
	        DefaultMutableTreeNode mercury = new DefaultMutableTreeNode("Mercury");
	        root.insert(mercury, 0);
	        DefaultMutableTreeNode venus = new DefaultMutableTreeNode("Venus");
	        root.insert(venus, 1);
	        DefaultMutableTreeNode mars = new DefaultMutableTreeNode("java2s.com");
	        root.insert(mars, 2);
	        JTree tree = new JTree(root);

	         
	        System.out.print("not null"); 
		return tree;
		}else {
			System.out.print("null");
		}
		
		return null;
				}
		
		
	}
	
	

}
