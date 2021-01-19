package com.account;



import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import javax.swing.SwingWorker;
import javax.swing.Timer;

import org.hibernate.HibernateException;

import accounting.Hibernate.SessionFactoryAdapter;
import accounting.enums.constants;
import accounting.ui.Main_Screen;

public class Account_lunch  extends JWindow {

	
/**
	 * 
	 */
	private static final long serialVersionUID = 3240341335898357960L;

/**
 * Hello world!
 *
 */ 

    static boolean isRegistered;

    //static Log log = LogFactory.getLog(App.class);

    private final  static JProgressBar progressBar = new JProgressBar();
    private static Account_lunch execute;
    private static int count;
    private static Timer timer1;
    BufferedImage image; 
    
	public Account_lunch() {
		 Image image = null; InputStream in=null;
 	try {
        		 	  in = getClass().getResourceAsStream("/resources/img/logo.jpg");  
         		
        		 	  	if (in==null)
        		 	  	 in = getClass().getResourceAsStream("/img/logo.jpg");  
            			 
        		 	  		
        		 	  		
    			 image = ImageIO.read(in);
    		} catch (IllegalArgumentException  | IOException e) {
    			// TODO Auto-generated catch block
    			
    			 
    			e.printStackTrace();
    		}  
        	
      	final    Container container = getContentPane();
        container.setLayout(null);

        final    JPanel panel = new JPanel();
        panel.setBorder(new javax.swing.border.EtchedBorder());
        panel.setBackground(new Color(255, 255, 255));
        panel.setBounds(10, 10, 355, 150);
        panel.setLayout(null);
        
        container.add(panel);

       // JLabel label = new JLabel("Zidan");
        final      JLabel label = new JLabel(new ImageIcon(image));
       //label.setFont(new Font("Acme", Font.BOLD , 36));
        label.setBounds(5, 5, 345, 140);
        panel.add(label);

        progressBar.setMaximum(300);
        progressBar.setStringPainted(true);
        progressBar.setBounds(55, 180, 250, 15);
        container.add(progressBar);
      //  loadProgressBar();

        
        Thread loadProgressBardb=new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				loadProgressBar();
			}
        	
        });
Thread db=new Thread(new Runnable() {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		 try {
			 loadProgressBardb.join();
			 loadProgressBardb.start();
				new SessionFactoryAdapter().getsSessionFactory(constants.Mysql).getCurrentSession();
			
 	 }catch (org.hibernate.service.spi.ServiceException eh ) {
					// TODO Auto-generated catch block
 		warnning( ) ;
		 System.exit(0);
			} catch (HibernateException e1 ) {
				// TODO Auto-generated catch block
				warnning( ) ;
				 System.exit(0);
			}catch( ClassNotFoundException e) {
				warnning( ) ;
				 System.exit(0);
			//	  JOptionPane.showMessageDialog(this,"Can not find Entity in DataBase.","Error", JOptionPane.ERROR_MESSAGE);
				 
			} catch (IOException e) {
				// TODO Auto-generated catch block
				warnning( ) ;
				 System.exit(0);
				  
			}   catch (java.lang.IllegalStateException exception) {
				warnning() ; System.exit(0);
				
			}   catch (RuntimeException exception) {
	            // Output expected IllegalStateException.
				 
				warnning( ) ;
				 System.exit(0);
	        } catch (Exception e) {
				// TODO Auto-generated catch block
	        	warnning( ) ;
				 System.exit(0);
				 
			} 
	}
	
});
db.start();
        
        setSize(380, 220);
        setLocationRelativeTo(null);
        setVisible(true);
      		// TODO Auto-generated method stub
				
      
    }

    public void loadProgressBar() {
    	
    	
    	final      ActionListener al = new ActionListener() {
            @SuppressWarnings("deprecation")
			public void actionPerformed(java.awt.event.ActionEvent evt) {
                count++;
                progressBar.setValue(count);
               
                if (count == 300) {
                    timer1.stop();
                    execute.setVisible(false);
                     
                    
                    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                    double width = screenSize.getWidth();
                    double height = screenSize.getHeight();
                     
                    
                      new Main_Screen.Builder().build((new Double(width).intValue()/3)*2,( new Double(height).intValue()/3)*2,1,1);
                   
                   
                    return;
                }
                
            }
        };
        timer1 = new Timer(50, al);
        timer1.start();
       
    }
    public void warnning( ) {
    	JOptionPane.showMessageDialog(this,"Can not connect to DataBase.","Error", JOptionPane.ERROR_MESSAGE); 
    	timer1.stop();
     
    	 
		
    }

    public static void main(final String[] args) {

        execute = new Account_lunch();

      
	}

    
     

     
}
