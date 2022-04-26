package com.xyy.gobang;

import sun.java2d.loops.DrawLine;

import java.awt.*;

/**
 * @author 皮皮瑶
 * @proname
 * @data 2022/4/26- 17:05
 * @指示器对象
 */
public class Pointer {
	private int i = 0;//二维数组的下标i
	private int j = 0;//二维数组的下标j
	private int x = 0;
	private int y = 0;
	private int h = 50;
	private boolean isShow = false; //是否展示指示器
	private int type = 0; //0 表示当前指示器位置没有棋子 1表示当前指示器位置为白棋 2表示当前指示器位置为黑棋

	public void setShow(boolean show) {
		isShow = show;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	//构造
	public Pointer(int i,int j,int x,int y){
		this.i = i;
		this.j = j;
		this.x = x;
		this.y = y;

	}

	//绘制指示器
	public void dramPointer(Graphics g){
		if (isShow){
			g.setColor(Color.red);
			//绘制对应样式的指示器
			//g.drawRect(x - h/2 , y - h/2 , h, h);
			drawPonintStyle(g);
		}
	}

	//指示器样式
	private void drawPonintStyle(Graphics g) {
		//转换成2D画笔
		Graphics2D graphics2D = (Graphics2D) g;
		//设置画笔的粗细
		graphics2D.setStroke(new BasicStroke(2.0f));

		//左上角的绘制
		int x1 = this.x - h/2;
		int x2 = this.x - h/4;
		int y1 = this.y - h/2;
		int y2 = this.y - h/4;
		graphics2D.drawLine(x1,y1,x2,y1);
		graphics2D.drawLine(x1,y1,x1,y2);

		//左下角的绘制
		x1 = this.x - h/2;
		x2 = this.x - h/4;
		y1 = this.y + h/2;
		y2 = this.y + h/4;
		graphics2D.drawLine(x1,y1,x2,y1);
		graphics2D.drawLine(x1,y1,x1,y2);

		//右上角的绘制
		x1 = this.x + h/2;
		x2 = this.x + h/4;
		y1 = this.y - h/2;
		y2 = this.y - h/4;
		graphics2D.drawLine(x1,y1,x2,y1);
		graphics2D.drawLine(x1,y1,x1,y2);

		//右下角的绘制
		x1 = this.x + h/2;
		x2 = this.x + h/4;
		y1 = this.y + h/2;
		y2 = this.y + h/4;
		graphics2D.drawLine(x1,y1,x2,y1);
		graphics2D.drawLine(x1,y1,x1,y2);


	}

	//判断鼠标是否在指示器的范围内
	public boolean isPoint(int x,int y){
		int x1 = this.x - h/2;
		int y1 = this.y - h/2;

		int x2 = this.x + h/2;
		int y2 = this.y + h/2;

//		if(x>x1&&y>y1&&x<x2&&y<y2){
//			return true;
//		}
		return x>x1&&y>y1&&x<x2&&y<y2;

//		return false;
	}

}
