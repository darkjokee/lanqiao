import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;

public class AI extends MIDlet
{
	Display display;
	MainCanvas mc;
	public AI(){
		display=Display.getDisplay(this);
		mc=new MainCanvas();
		display.setCurrent(mc);
	}
	public void startApp(){
	}
	public void destroyApp(boolean unc){
	}
	public void pauseApp(){
	}
}
class MainCanvas extends Canvas
{
	int x,y,i,j;
	Image currentImg;
	Image [][]heroImg=new Image[3][7];
	public MainCanvas(){
		try
		{
		for(i=0;i<3;i++)
			for(j=0;j<4;j++){
				heroImg[i][j]=Image.createImage("/sayo"+i+""+j+".png");
			}
			currentImg=heroImg[1][0];
		}
		
		catch(IOException e)
		{
			e.printStackTrace();
		}
		x=120;
		y=100;

	}
	public void keyReleased(int keyCode){
		int action=getGameAction(keyCode);
		if(action==LEFT){
			currentImg=heroImg[1][1];
		}
		if(action==RIGHT){
			currentImg=heroImg[1][3];
		}
		if(action==UP){
			currentImg=heroImg[1][2];
		}
		if(action==DOWN){
			currentImg=heroImg[1][0];
		}
		repaint();
	}
	public void paint(Graphics g){
		g.setColor(0,0,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);
	}

	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);
		if(action==LEFT){
			x=x-5;
			if(x%2==0)
				currentImg=heroImg[0][1];
			else
				currentImg=heroImg[2][1];
		}

		if(action==UP){
			y=y-9;
			if(y%2==0)
				currentImg=heroImg[0][2];
			else
				currentImg=heroImg[2][2];
		}
		if(action==RIGHT){
			x=x+5;
			if(x%2==0)
				currentImg=heroImg[0][3];
			else
				currentImg=heroImg[2][3];
		}
		if(action==DOWN){
			y=y+9;
			if(y%2==0)
				currentImg=heroImg[0][0];
			else
				currentImg=heroImg[2][0];
		}
		repaint();
	}
}
