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
	int flag=1;
	Image currentImg;
	Image [][]heroImg=new Image[3][7];

	public void currentImg(int a,int b){
		currentImg=heroImg[a][b];
	}
	public void changeImg(int a){
			if(flag%2==0)
				currentImg(0,a);
			else
				currentImg(2,a);
	}
	public MainCanvas(){
		try
		{
		for(i=0;i<heroImg.length;i++)
			for(j=0;j<heroImg[i].length;j+=2){
				heroImg[i][j]=Image.createImage("/sayo"+i+j+".png");
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
			currentImg(1,2);
		}
		if(action==RIGHT){
			currentImg(1,6);
		}
		if(action==UP){
			currentImg(1,4);
		}
		if(action==DOWN){
			currentImg(1,0);
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
			changeImg(2);
			flag++;
		}
		if(action==UP){
			y=y-6;
			changeImg(4);
			flag++;
		}
		if(action==RIGHT){
			x=x+5;
			changeImg(6);
			flag++;
		}
		if(action==DOWN){
			y=y+6;
			changeImg(0);
			flag++;
		}
		repaint();
	}
}
