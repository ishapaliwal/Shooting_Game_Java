import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.util.*;
public class Shooting_Game extends Applet implements MouseListener,MouseMotionListener
{
AudioClip ac;
int xb,yb,xs,ys,hit;
boolean flag1,flag2,flag3;
Date ob1,ob2;
long x,y,p;
public void init()
{
ob1=new Date();
x=ob1.getTime();
flag1=false;
flag2=false;
flag3=true;
xb=0;
yb=100;
xs=100;
ys=270;
hit=0;
ac=getAudioClip(getDocumentBase(),"ak47-1.wav");
addMouseListener(this);
addMouseMotionListener(this);
}
public void mouseEntered(MouseEvent me)
{
}
public void mouseExited(MouseEvent me)
{
}
public void mouseClicked(MouseEvent me)
{
}
public void mousePressed(MouseEvent me)
{
if(flag3==true)
{
ac.stop();
flag1=true;
flag2=true;
ac.play();
}
repaint();
}
public void mouseReleased(MouseEvent me)
{
}
public void mouseMoved(MouseEvent me)
{
}
public void mouseDragged(MouseEvent me)
{
repaint();
}
public void paint(Graphics g)
{
ob2=new Date();
y=ob2.getTime();

g.fillRect(0,50,200,300);
g.setColor(Color.blue);
g.fillOval(xb,yb,40,40);
g.setColor(Color.red);
g.fillRect(80,290,40,60);
g.fillOval(80,280,40,20);
g.setColor(Color.black);
g.drawOval(80,280,40,20);
g.setColor(Color.red);
g.drawOval(xs,ys,5,10);
if(flag3==true)
{
if(xb==160)
xb=0;
else
xb++;
if(flag1==true)
{
if(ys==50)
{
ys=270;
flag1=false;
}
else
ys-=4;
}
if(xs>=xb-5&&xs<=xb+40&&ys>=yb-10&&ys<=yb+40&&flag2==true)
{
hit++;
flag2=false;
}
p=y-x;
}
int b=(int)p/1000;
if(b==60)
{
g.drawString("Game Over",160,40);
flag3=false;
}
else
g.drawString("Time = 00:"+b,160,40);
g.drawString("No. of hits = "+hit,0,360);
repaint();
try
{
Thread.sleep(5);
}
catch(InterruptedException e)
{
System.out.println("ERRORRRRRRRR");
}
}
}
/*<applet code="Shooting_Game" width=1340 height=640>
</applet>*/