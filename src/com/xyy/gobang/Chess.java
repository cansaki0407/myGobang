package com.xyy.gobang;

import java.awt.*;

/**
 * @author 皮皮瑶
 * @proname
 * @data 2022/4/27- 0:37
 */
public class Chess {
	private int x;
	private int y;
	private int h = 50;//图片高度
	private int type = 1; //1 白棋  2 黑棋

	//构造方法
	public Chess(int x,int y,int type){
		this.x = x;
		this.y = y;
		this.type = type;
	}

	public void drawChess(Graphics g){
		if(type == 1){
			g.setColor(Color.white);
			g.fillArc(x-h/2, y-h/2, 50, 50, 0, 360);

			//画棋子 通过图片渲染
			//g.drawImage(ImageData.whiteChessImage,x ,y-h/2 ,50,50,null );
		}
		else {
			g.setColor(Color.black);
			g.fillArc(x-h/2, y-h/2, 50, 50, 0, 360);

			//画棋子 通过图片渲染
			//g.drawImage(ImageData.blackChessImage, x-h/2, y-h/2,50,50, null);
		}
	}



}
