import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;
import java.util.*;

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
class MainCanvas extends Canvas implements Runnable
{
	Thread thread;
	int heroX,heroY,bossX,bossY,i,j;
	int flag=1;
	Image currentImg;
	Image bossImg;
	Image [][]heroImg=new Image[3][7];
	Random rd=new Random();

	public void currentImg(int a,int b){
		currentImg=heroImg[a][b];
	}
	public void changeImg(int a){
		if(flag%2==0)
			currentImg(0,a);
		else
			currentImg(2,a);
		repaint();
	}
	public MainCanvas(){
		try
		{
		for(i=0;i<heroImg.length;i++)
			for(j=0;j<heroImg[i].length;j+=2){
				heroImg[i][j]=Image.createImage("/sayo"+i+j+".png");
			}
			currentImg=heroImg[1][0];
			bossImg=Image.createImage("/zuzu000.png");
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		bossX=0;
		bossY=0;
		heroX=120;
		heroY=100;
		thread=new Thread(this);
		thread.start();
	}
	public void run(){
		while(true){
			int rdNumber=rd.nextInt(10);

			try
			{
				Thread.sleep(200);   //ÆÁÄ»Ë¢ÐÂÂÊ
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			if (rdNumber%3==0){
				if(bossX<heroX)
					bossX+=2;
				else
					bossX-=2;
				if(bossY<heroY)
					bossY+=3;
				else
					bossY-=3;
				repaint();
				}
		}
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
		g.drawImage(currentImg,heroX,heroY,0);
		g.drawImage(bossImg,bossX,bossY,0);
	}
	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);
		if(action==LEFT){
			heroX=heroX-5;
			changeImg(2);
			flag++;
		}
		if(action==UP){
			heroY=heroY-6;
			changeImg(4);
			flag++;
		}
		if(action==RIGHT){
			heroX=heroX+5;
			changeImg(6);
			flag++;
		}
		if(action==DOWN){
			heroY=heroY+6;
			changeImg(0);
			flag++;
		}
	}
}
