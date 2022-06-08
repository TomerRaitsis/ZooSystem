 /**
    * @author 
    * Tomer Raitsis 316160167
    * SCE, Ashdod
    *    
    */
package graphics;

import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import animals.Animal;

/**
 *  This class extends JFrame and shows the info of all the animals in the zoo 
 *  and the total of the objects that has been eaten.
 *  
 * @version 1.0
 * 
 */
public class InfoTable extends JFrame{
	
	/**
	 *  A Ctor that gets the Animals and builds according to them the table.
	 * 
	 * @version 1.0
	 * 
	 * @param Animals - ArrayList of animals
	 */
	public InfoTable(ArrayList<Animal> Animals)
	{
		super();
		this.setTitle("Info Table");
		try {
			this.setIconImage(ImageIO.read(new File(IDrawable.PICTURE_PATH + "zoo.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int TEatCount = 0;
		String[] columnNames = {"Animal", "Color", "Weight", "Hor.speed", "Ver.speed","Eat Counter"};
		String[][] data = new String[Animals.size() + 1][6];
		for (int i = 0; i < Animals.size(); i++) {
			Animal a = Animals.get(i);
			data[i][0] = a.getAnimalName() + ": " + a.getName();
			data[i][1] = a.getColor();
			data[i][2] = String.format("%.5f",a.getWeight());
			data[i][3] = String.format("%d",a.getHorSpeed());
			data[i][4] = String.format("%d",a.getVerSpeed());
			data[i][5] = String.format("%d",a.getEatCount());	
			TEatCount += a.getEatCount();
		}
		data[Animals.size()][0] = "Total";
		data[Animals.size()][1] = "";
		data[Animals.size()][2] = "";
		data[Animals.size()][3] = "";
		data[Animals.size()][4] = "";
		data[Animals.size()][5] = String.format("%d",TEatCount);
		
		JTable j = new JTable(data, columnNames);
		JScrollPane sp = new JScrollPane(j);
        this.add(sp);
        this.setSize(new Dimension(400,200));
        this.setLocationRelativeTo(getParent());
        this.setVisible(true);
	}
	
	
}
