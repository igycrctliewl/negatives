package mikebro.negativeui.ui;

import java.awt.Image;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import mikebro.image.services.MBBufferedImage;
import mikebro.image.utils.ImageUtils;

/**
 *
 * @author mikebro
 */
public class MainJFrame extends javax.swing.JFrame {

	// component variables declaration
   private javax.swing.JFileChooser jFileChooser;
   private javax.swing.JMenu jMenu1;
   private javax.swing.JMenuBar jMenuBar;
   private javax.swing.JLabel jlLeft;
   private javax.swing.JLabel jlRight;
   private javax.swing.JMenuItem jmiOpen;
   private javax.swing.JMenuItem jmiSaveLeft;
   private javax.swing.JMenuItem jmiSaveRight;

	//private String imgFile = "C:\\Users\\mikebro\\Desktop\\200808261257_001.jpg";
	private String imgFile = getClass().getResource( "/mikebro/resources/java.jpg" ).getFile();
	private MBBufferedImage currentImage;
	private Image negativeImage;

   /**
    * Creates new form MainJFrame
    */
   public MainJFrame() {
      initComponents();
   }

   /**
    * This method is called from within the constructor to initialize the form.
	 * Automatic code generation has been disabled so that code can be edited directly.
    */
   @SuppressWarnings("unchecked")
   private void initComponents() {

      jFileChooser = new javax.swing.JFileChooser();
      jlLeft = new JLabel( new ImageIcon( imgFile ) );
      jlRight = new JLabel( new ImageIcon( ImageUtils.scaleImage( (new ImageIcon( imgFile )).getImage(), 80, 60 ) ));
      jMenuBar = new javax.swing.JMenuBar();
      jMenu1 = new javax.swing.JMenu();
      jmiOpen = new javax.swing.JMenuItem();
      jmiSaveLeft = new javax.swing.JMenuItem();
      jmiSaveRight = new javax.swing.JMenuItem();

      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
      addComponentListener(new java.awt.event.ComponentAdapter() {
			@Override
         public void componentResized(java.awt.event.ComponentEvent evt) {
            formComponentResized(evt);
         }
      });

      jlLeft.setText("Original");
      jlLeft.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
      jlRight.setText("Negative");
      jlRight.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

      jMenu1.setText("File");

      jmiOpen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, 0));
      jmiOpen.setText("Open");
      jmiOpen.setName(""); // NOI18N
      jmiOpen.addActionListener(new java.awt.event.ActionListener() {
			@Override
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jmiOpenActionPerformed(evt);
         }
      });
      jMenu1.add(jmiOpen);

      jmiSaveLeft.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, 0));
      jmiSaveLeft.setText("Save Left As...");
      jmiSaveLeft.addActionListener(new java.awt.event.ActionListener() {
			@Override
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jmiSaveLeftActionPerformed(evt);
         }
      });
      jMenu1.add(jmiSaveLeft);

      jmiSaveRight.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, 0));
      jmiSaveRight.setText("Save Right As...");
      jmiSaveRight.addActionListener(new java.awt.event.ActionListener() {
			@Override
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jmiSaveRightActionPerformed(evt);
         }
      });
      jMenu1.add(jmiSaveRight);
      jMenuBar.add(jMenu1);
      this.setJMenuBar(jMenuBar);

		this.getContentPane().add( jlLeft );
		this.getContentPane().add( jlRight );
      jlLeft.setVisible( false );
      jlRight.setVisible( false );

/*		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addGap(85, 85, 85)
            .addComponent(jlLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(46, 46, 46)
            .addComponent(jlRight, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(151, Short.MAX_VALUE))
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addGap(66, 66, 66)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(jlRight, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(jlLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(126, Short.MAX_VALUE))
      );
*/

      java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
      setBounds((screenSize.width-416)/2, (screenSize.height-338)/2, 416, 338);
   }

   private void jmiOpenActionPerformed(java.awt.event.ActionEvent evt) {
		System.out.println( "jmiOpenActionPerformed:" + evt );
		int dialogRc = this.jFileChooser.showOpenDialog( this );

		if( dialogRc == JFileChooser.APPROVE_OPTION ) {
			try {
				currentImage = new MBBufferedImage( ImageIO.read( jFileChooser.getSelectedFile() ));
				negativeImage = currentImage.getNegativeImg();
				jlLeft.setText( null );
				jlRight.setText( null );
				jlLeft.setVisible( true );
				jlRight.setVisible( true );
				reDrawImages();
			} catch( IOException ex ) {
				Logger.getLogger( MainJFrame.class.getName() ).log( Level.SEVERE, null, ex );
				ex.printStackTrace();
			}
		}
   }

   private void jmiSaveLeftActionPerformed(java.awt.event.ActionEvent evt) {
      // TODO add your handling code here:
		System.out.println( "jmiSaveLeftActionPerformed:" + evt );
		this.jFileChooser.showSaveDialog( this );
   }

   private void jmiSaveRightActionPerformed(java.awt.event.ActionEvent evt) {
      // TODO add your handling code here:
		System.out.println( "jmiSaveRightActionPerformed:" + evt );
		this.jFileChooser.showSaveDialog( this );
   }

	private int getAdjustedWidth() {
		return this.getWidth() - 25;
	}

	private int getAdjustedHeight() {
		return this.getHeight() - 70;
	}

   private void formComponentResized(java.awt.event.ComponentEvent evt) {
		System.out.println( "formComponentResized:" + evt );
		int adjustedWidth = this.getAdjustedWidth();
		int adjustedHeight = this.getAdjustedHeight();
		jlLeft.setLocation( 2, 2 );
		jlRight.setLocation( (( adjustedWidth / 2 ) + 5 ), 2 );
		jlLeft.setSize( ( adjustedWidth / 2 ), adjustedHeight );
		jlRight.setSize( ( adjustedWidth / 2 ), adjustedHeight );
		reDrawImages();
	}

	private void reDrawImages() {
		int adjustedWidth = this.getAdjustedWidth();
		int adjustedHeight = this.getAdjustedHeight();
		if( currentImage != null ) {
			jlLeft.setIcon( new ImageIcon( ImageUtils.scaleImage( currentImage.getImage(), ( adjustedWidth / 2 ), adjustedHeight ) ));
			jlRight.setIcon( new ImageIcon( ImageUtils.scaleImage( negativeImage, ( adjustedWidth / 2 ), adjustedHeight ) ));
		}

		System.out.println( "Frame size: " + this.getSize() );
		System.out.println( "Left location: " + jlLeft.getLocation() );
		System.out.println( "Left size: " + jlLeft.getSize() + " visible = " + jlLeft.isVisible() );
		System.out.println( "Right location: " + jlRight.getLocation() );
		System.out.println( "Right size: " + jlRight.getSize() + " visible = " + jlRight.isVisible() );
   }

   /**
    * @param args the command line arguments
    */
   public static void main(String args[]) {
      /* Set the Nimbus look and feel */
      //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
       * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
       */
      try {
         for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				System.out.println( "Look & Feel: " + info.getName() );
            if ("Windows".equals(info.getName())) {
               javax.swing.UIManager.setLookAndFeel(info.getClassName());
               // break;
            }
         }
      } catch (ClassNotFoundException ex) {
         java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (InstantiationException ex) {
         java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (IllegalAccessException ex) {
         java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (javax.swing.UnsupportedLookAndFeelException ex) {
         java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }


      /* Create and display the form */
      java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
         public void run() {
            new MainJFrame().setVisible(true);
         }
      });
   }
}


/*

Bad appearance: overlapping images:
formComponentResized:java.awt.event.ComponentEvent[COMPONENT_RESIZED (432,231 437x338)] on frame0
Frame size: java.awt.Dimension[width=437,height=338]
Left location: java.awt.Point[x=2,y=2]
Left size: java.awt.Dimension[width=206,height=268] visible = true
Right location: java.awt.Point[x=211,y=2]
Right size: java.awt.Dimension[width=206,height=268] visible = true



Good appearance: perfectly displayed images
formComponentResized:java.awt.event.ComponentEvent[COMPONENT_RESIZED (432,231 450x338)] on frame0
Frame size: java.awt.Dimension[width=450,height=338]
Left location: java.awt.Point[x=2,y=2]
Left size: java.awt.Dimension[width=212,height=268] visible = true
Right location: java.awt.Point[x=217,y=2]
Right size: java.awt.Dimension[width=212,height=268] visible = true

 */