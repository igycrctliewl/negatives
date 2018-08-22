/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class NewJFrame extends javax.swing.JFrame {
	//private String imgFile = "C:\\Users\\mikebro\\Desktop\\200808261257_001.jpg";
	private String imgFile = getClass().getResource( "/mikebro/resources/java.jpg" ).getFile();
	private MBBufferedImage currentImage;
	private Image negativeImage;

   /**
    * Creates new form NewJFrame
    */
   public NewJFrame() {
      initComponents();
   }

   /**
    * This method is called from within the constructor to initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is always
    * regenerated by the Form Editor.
    */
   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      jFileChooser = new javax.swing.JFileChooser();
      jlLeft = new JLabel( new ImageIcon( imgFile ) );
      jlRight = new JLabel( new ImageIcon( ImageUtils.scaleImage( (new ImageIcon( imgFile )).getImage(), 80, 60 ) ));
      jlRight.setVisible( false );
      jMenuBar = new javax.swing.JMenuBar();
      jMenu1 = new javax.swing.JMenu();
      jmiOpen = new javax.swing.JMenuItem();
      jmiSaveLeft = new javax.swing.JMenuItem();
      jmiSaveRight = new javax.swing.JMenuItem();

      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
      addComponentListener(new java.awt.event.ComponentAdapter() {
         public void componentResized(java.awt.event.ComponentEvent evt) {
            formComponentResized(evt);
         }
      });

      jlLeft.setText("Original");
      jlLeft.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

      jlRight.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

      jMenu1.setText("File");

      jmiOpen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, 0));
      jmiOpen.setText("Open");
      jmiOpen.setName(""); // NOI18N
      jmiOpen.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jmiOpenActionPerformed(evt);
         }
      });
      jMenu1.add(jmiOpen);

      jmiSaveLeft.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, 0));
      jmiSaveLeft.setText("Save Left As...");
      jmiSaveLeft.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jmiSaveLeftActionPerformed(evt);
         }
      });
      jMenu1.add(jmiSaveLeft);

      jmiSaveRight.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, 0));
      jmiSaveRight.setText("Save Right As...");
      jmiSaveRight.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jmiSaveRightActionPerformed(evt);
         }
      });
      jMenu1.add(jmiSaveRight);

      jMenuBar.add(jMenu1);

      setJMenuBar(jMenuBar);

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
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

      jlLeft.setVisible( false );

      java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
      setBounds((screenSize.width-416)/2, (screenSize.height-338)/2, 416, 338);
   }// </editor-fold>//GEN-END:initComponents

   private void jmiOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiOpenActionPerformed
      // TODO add your handling code here:
		System.out.println( "jmiOpenActionPerformed:" + evt );
		int dialogRc = this.jFileChooser.showOpenDialog( this );

		if( dialogRc == JFileChooser.APPROVE_OPTION ) {
			try {
				currentImage = new MBBufferedImage( ImageIO.read( jFileChooser.getSelectedFile() ));
				negativeImage = currentImage.getNegativeImg();
				jlLeft.setVisible( true );
				jlRight.setVisible( true );
				reDrawImages();
			} catch( IOException ex ) {
				Logger.getLogger( NewJFrame.class.getName() ).log( Level.SEVERE, null, ex );
				ex.printStackTrace();
			}
		}
   }//GEN-LAST:event_jmiOpenActionPerformed

   private void jmiSaveLeftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiSaveLeftActionPerformed
      // TODO add your handling code here:
		System.out.println( "jmiSaveLeftActionPerformed:" + evt );
		this.jFileChooser.showSaveDialog( this );
   }//GEN-LAST:event_jmiSaveLeftActionPerformed

   private void jmiSaveRightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiSaveRightActionPerformed
      // TODO add your handling code here:
		System.out.println( "jmiSaveRightActionPerformed:" + evt );
		this.jFileChooser.showSaveDialog( this );
   }//GEN-LAST:event_jmiSaveRightActionPerformed

	private int getAdjustedWidth() {
		return this.getWidth() - 25;
	}

	private int getAdjustedHeight() {
		return this.getHeight() - 70;
	}

   private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
      // TODO add your handling code here:
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
   }//GEN-LAST:event_formComponentResized

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
            if ("Nimbus".equals(info.getName())) {
               javax.swing.UIManager.setLookAndFeel(info.getClassName());
               break;
            }
         }
      } catch (ClassNotFoundException ex) {
         java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (InstantiationException ex) {
         java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (IllegalAccessException ex) {
         java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (javax.swing.UnsupportedLookAndFeelException ex) {
         java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
      //</editor-fold>

      /* Create and display the form */
      java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
         public void run() {
            new NewJFrame().setVisible(true);
         }
      });
   }
   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JFileChooser jFileChooser;
   private javax.swing.JMenu jMenu1;
   private javax.swing.JMenuBar jMenuBar;
   private javax.swing.JLabel jlLeft;
   private javax.swing.JLabel jlRight;
   private javax.swing.JMenuItem jmiOpen;
   private javax.swing.JMenuItem jmiSaveLeft;
   private javax.swing.JMenuItem jmiSaveRight;
   // End of variables declaration//GEN-END:variables
}