package conwaysgameoflife;

import java.awt.Toolkit;

import javax.swing.JFrame;

/** 
 * 
 * @author Sharun, Joel, Ravi
 *
 */
public class GameOfLifeApp {
	

	public static void main(String[] args) {
		
		JFrame game = new GameOfLifeView();
        game.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - game.getWidth())/2, 
                (Toolkit.getDefaultToolkit().getScreenSize().height - game.getHeight())/2);
        game.setVisible(true);

	}

}
