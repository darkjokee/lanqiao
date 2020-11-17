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
	int x,y;
	Image downImg,leftImg,upImg,rightImg,currentImg,downMove1,downMove2,upMove1,upMove2,leftMove1,leftMove2,rightMove1,rightMove2;
	public MainCanvas(){
		try
			{
			downImg=Image.createImage("/sayo10.png");
			leftImg=Image.createImage("/sayo12.png");
			upImg=Image.createImage("/sayo14.png");
			rightImg=Image.createImage("/sayo16.png");
			downMove1=Image.createImage("/sayo00.png");
			downMove2=Image.createImage("/sayo20.png");
			upMove1=Image.createImage("/sayo04.png");
			upMove2=Image.createImage("/sayo24.png");
			leftMove1=Image.createImage("/sayo02.png");
			leftMove2=Image.createImage("/sayo22.png");
			rightMove1=Image.createImage("/sayo06.png");
			rightMove2=Image.createImage("/sayo26.png");
			currentImg=downImg;
			}
			catch(IOException e)
		{
			e.printStackTrace();
		}
		x=120;
		y=100;

	}
	public void paint(Graphics g){
		g.setColor(0,0,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);
	}
	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);
		if(action==LEFT){
			currentImg=leftImg;
			x=x-5;
			if(x%2==0)
				currentImg=leftMove1;
			else
				currentImg=leftMove2;
		}

		if(action==UP){
			currentImg=upImg;
			y=y-9;
			if(y%2==0)
				currentImg=upMove1;
			else
				currentImg=upMove2;
		}
		if(action==RIGHT){
			currentImg=rightImg;
			x=x+5;
			if(x%2==0)
				currentImg=rightMove1;
			else
				currentImg=rightMove2;
		}
		if(action==DOWN){
			currentImg=downImg;
			y=y+9;
			if(y%2==0)
				currentImg=downMove1;
			else
				currentImg=downMove2;
		}
		repaint();
	}
}
