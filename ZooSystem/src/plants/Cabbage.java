package plants;

import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import graphics.IDrawable;
import utilities.MessageUtility;

/**
 * @author baroh
 *
 */
public class Cabbage extends Plant {
	public Cabbage() {
		//MessageUtility.logConstractor("Cabbage", "Cabbage");
	}


	@Override
	public void drawObject(Graphics g) {
		try {
			g.drawImage(ImageIO.read(new File(IDrawable.PICTURE_PATH + "cabbage.png")),
					(int) (this.getLocation().GetX() - this.getHeight() / 2),
					(int) (this.getLocation().GetY() - this.getHeight() / 2), ((int) this.getHeight()),
					((int) this.getHeight()), null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
