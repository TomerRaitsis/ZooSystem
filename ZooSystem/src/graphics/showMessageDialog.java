 /**
    * @author 
    * Tomer Raitsis
    * SCE, Ashdod
    *    
    */
package graphics;

import java.awt.Color;

import java.awt.Dimension;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javax.swing.JDialog;


/**
 *  A dialog that shows a message to the user, extends JDialog.
 *  The text is being Set along the program according to the case
 *  the object is being used.
 * 
 * @version 1.0
 * 
 * @param 
 * 
 * @return 
 * 
 * @see
 */
public class showMessageDialog extends JDialog{
	
	/**
	 *  A Ctor for the showMessageDialog,
	 *  sets an image for the icon,
	 *  sets a question mark (?) image int the dialog itself
	 * 
	 * @version 1.0
	 */
	public showMessageDialog()
	{
		super();
		this.setTitle("Message");
		this.setSize(new Dimension(420,200));
		this.setLocationRelativeTo(getParent());
		this.setLayout(null);
		this.setResizable(false);
		this.getRootPane ().setOpaque (false);
		this.getContentPane ().setBackground (Color.DARK_GRAY);
		this.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
		try {
			this.setIconImage(ImageIO.read(new File(IDrawable.PICTURE_PATH + "zoo.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PanelDrawing pd = new PanelDrawing();
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File(IDrawable.PICTURE_PATH + "asd.png"));
		} catch (IOException e1) {
			System.out.println("Cannot load image");
		}
		pd.setImage(img);
		pd.setBounds(30, 40, 70, 70);
		this.add(pd);
	}

}
