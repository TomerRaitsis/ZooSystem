package plants;

import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import food.IEdible;
import graphics.IDrawable;

public class Lettuce extends Plant {
	
	// singelton implementation for Cabbage
	private static Lettuce LettuceOBJ = null;

	public static Lettuce getInstance() {
		if (LettuceOBJ == null)
			LettuceOBJ = new Lettuce();
		return LettuceOBJ;
	}
	
	private Lettuce() {
	}
	
	public void SetNull() {LettuceOBJ = null;}
	
	/*
	 * An Override of IDrawable interface method
	 */
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
	
	/*
	 * An Override of IEdible interface method
	 */
	@Override
	public IEdible clone()  {
		return Lettuce.getInstance();
	}

}
