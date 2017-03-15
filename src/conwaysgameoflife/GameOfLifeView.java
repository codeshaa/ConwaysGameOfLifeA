package conwaysgameoflife;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameOfLifeView extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Dimension DEFAULT_WINDOW_SIZE = new Dimension(800, 600);
    private static final Dimension MINIMUM_WINDOW_SIZE = new Dimension(600, 600);
    private static final Dimension BUTTON_SIZE = new Dimension(150, 40);
    private static final Font fontButton = new Font("Arial", Font.BOLD, 20);
	private JButton btnPlay, btnStop, btnReset;
	private JPanel pnlControls;
	private GameBoard gameBoard;
	private Thread game;
	
	GameOfLifeView(){
		
		//setting Layout
		setSize(DEFAULT_WINDOW_SIZE);
		setMinimumSize(MINIMUM_WINDOW_SIZE);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setLayout(new BorderLayout());
        
        //setting control buttons on a new panel
		pnlControls = new JPanel();
		btnPlay = new JButton("Play");
		btnPlay.setPreferredSize(BUTTON_SIZE);
		btnPlay.setFont(fontButton);
		btnPlay.addActionListener(this);
		btnStop = new JButton("Stop");
		btnStop.setPreferredSize(BUTTON_SIZE);
		btnStop.setFont(fontButton);
		btnStop.addActionListener(this);
		btnReset = new JButton("Reset");
		btnReset.setPreferredSize(BUTTON_SIZE);
		btnReset.setFont(fontButton);
		btnReset.addActionListener(this);
		pnlControls.add(btnPlay);
		pnlControls.add(btnStop);
		pnlControls.add(btnReset);
		pnlControls.setBackground(Color.CYAN);
		super.add(pnlControls, BorderLayout.NORTH);
		pnlControls.setVisible(true);
		gameBoard = new GameBoard(DEFAULT_WINDOW_SIZE);
		super.add(gameBoard, BorderLayout.CENTER);
		
	}
	
	// paying game button controls 
	public void setPlayingGame (boolean isPlaying){
		if (isPlaying){
			btnPlay.setEnabled(false);
			btnStop.setEnabled(true);
			game = new Thread(gameBoard);
			game.start();
		}
		else{
			btnPlay.setEnabled(true);
			btnStop.setEnabled(false);
			game.interrupt();
		}
	}
	
	public void actionPerformed(ActionEvent e){
		
		if(e.getSource().equals(btnPlay)){
			setPlayingGame(true);
		}
		else if(e.getSource().equals(btnStop)){
			setPlayingGame(false);
		}
		else if(e.getSource().equals(btnReset)){
			gameBoard.resetBoard();
			gameBoard.repaint();
		}
		
	}
}
