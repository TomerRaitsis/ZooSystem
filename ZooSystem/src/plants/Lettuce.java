package plants;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import graphics.IDrawable;
import graphics.PanelDrawing;
import utilities.MessageUtility;

/**
 * @author baroh
 *
 */
public class Lettuce extends Plant {
	public Lettuce() {
		MessageUtility.logConstractor("Lettuce", "Lettuce");
	}

	@Override
	public void drawObject(Graphics g) {
		try {
			g.drawImage(ImageIO.read(new File(IDrawable.PICTURE_PATH + "lettuce.png")),
					(int) (this.getLocation().GetX() - this.getHeight() / 2),
					(int) (this.getLocation().GetY() - this.getHeight() / 2), ((int) this.getHeight()),
					((int) this.getHeight()), null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
