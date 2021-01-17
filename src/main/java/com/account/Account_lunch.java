package com.account;



import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import javax.swing.Timer;
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
      	//try {
     

      	//String xc =new File(Account_lunch.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getPath();
      		
      	  ClassLoader classLoader = getClass().getClassLoader();
      	  
 
      	 
      	 
        	try {
        		 	  in = getClass().getResourceAsStream("/resources/img/logo.jpg");  
        		
        	//	URL resource = classLoader.getResource("resources/img/logo.jpg");
        		
        
        		
    			 image = ImageIO.read(in);
    		} catch (IllegalArgumentException  | IOException e) {
    			// TODO Auto-generated catch block
    			
    			  in = getClass().getResourceAsStream("/img/logo.jpg");  
    			try {
					image = ImageIO.read(in);
				} catch (IllegalArgumentException  | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
    			e.printStackTrace();
    		}  
        	
        	/*
      		 URL imageURL =  getClass().getClassLoader().getResource("img"+File.separator+"s-l400.jpg");
             if(imageURL != null){
                   image = Toolkit.getDefaultToolkit().getImage(imageURL);
               } 
   			 image = ImageIO.read(new File(imageURL.toURI()));
  		} catch (final IOException e) {
  			// TODO Auto-generated catch block
 
  		 
  			e.printStackTrace();
  		} catch (final URISyntaxException e) {
  			// TODO Auto-generated catch block
  		 
  			e.printStackTrace();
  		}*/
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
        loadProgressBar();
        setSize(380, 220);
        setLocationRelativeTo(null);
        setVisible(true);
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

    public static void main(final String[] args) {

        execute = new Account_lunch();

      
	}

}
