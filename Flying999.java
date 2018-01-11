import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class game{
	public static void main(String[]ar){
game_Frame fms = new game_Frame();
	}
}

class game_Frame extends JFrame implements KeyListener,Runnable{

	int f_width = 1200;
	int f_height = 700;

	int x,y;


	boolean KeyUp = false;
	boolean KeyDown = false;
	boolean KeyLeft = false;
	boolean KeyRight = false;

	Thread th;

	Toolkit tk = Toolkit.getDefaultToolkit();

	Image me_img = tk.getImage("devil.png");

	game_Frame(){
		init();
		start();

		setTitle("BlackDevil999👿");
		setSize(f_width,f_height);

		Dimension screen = tk.getScreenSize();

		int f_xpos = (int)(screen.getWidth() / 2-f_width / 2);
		int f_ypos = (int)(screen.getHeight() / 2-f_height / 2);

		setLocation(f_xpos,f_ypos);
		setResizable(false);
		setVisible(true);
	}
	public void init(){
	y = 99;
	x = 99;
	}
	public void start(){

	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


	addKeyListener(this);
	th = new Thread(this);
	th.start();

	}

	public void run(){
		try{
			while(true){
				KeyProcess();
				repaint();
				Thread.sleep(20);
			}
		}catch (Exception e){}
	}

	public void paint(Graphics g){
		g.clearRect(0,0,f_width,f_height);

		g.drawImage(me_img,100,100,this);
	}

	public void KeyPressed(KeyEvent e){
		switch(e.getKeyCode()){
			case KeyEvent.VK_UP:
				KeyUp=true;
				break;
			case KeyEvent.VK_DOWN:
				KeyDown=true;
				break;
			case KeyEvent.VK_LEFT:
				KeyLeft=true;
				break;
			case KeyEvent.VK_RIGHT:
				KeyRight=true;
				break;
		}
	}
	public void KeyReleased(KeyEvent e){
		switch(e.getKeyCode()){
		case KeyEvent.VK_UP:
				KeyUp=false;
				break;
		case KeyEvent.VK_DOWN:
				KeyDown=false;
				break;
		case KeyEvent.VK_LEFT:
				KeyLeft=false;
				break;
		case KeyEvent.VK_RIGHT:
				KeyRight=false;
				break;
		}
	}
	public void KeyProcess(){

		if(KeyUp == true) y-=5;
		if(KeyDown == true) y+=5;
		if(KeyLeft == true) x-=5;
		if(KeyRight == true) x+=5;
	}
}
