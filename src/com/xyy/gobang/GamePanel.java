package com.xyy.gobang;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @author 皮皮瑶
 * @proname
 * @data 2022/4/24- 18:02
 */
public class GamePanel extends JPanel implements MouseListener{
	//棋子坐标x y 表示
	int[] blackX = new int[250];
	int[] blackY = new int[250];
	int[] whiteX = new int[250];
	int[] whiteY = new int[250];
	//棋盘相对于窗口的坐标起点
	static int chessBoardX = 30;
	static int chessBoardY = 90;
	//棋盘尺寸
	static int chessBoardWidth = 1140;
	static int chessBoardHeight = 750;
	int chessNum;//落子数 第几步
	int whiteChessRound;//白子回合 暂时默认单数成立
	int blackChessRound;//黑子回合 暂时默认双数成立
	int whiteChessStep;//白子步数
	int blackChessStep;//黑子步数
	boolean isClick = false;



	public GamePanel() {
		init0();
	}

	void init0(){
		chessNum = 2;
		this.setFocusable(true);
		this.addMouseListener(this);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(Color.white);
		g.fillRect(chessBoardX,chessBoardY,chessBoardWidth,chessBoardHeight);//棋盘的位置坐标及其宽高

			g.setColor(Color.red);
			for(int i = 0;i < chessBoardHeight / 30;i++){
				g.drawLine(chessBoardX,(30*i)+chessBoardY+15,chessBoardWidth+chessBoardX,(30*i)+chessBoardY+15);
			}
			for (int i = 0;i <chessBoardWidth / 30;i++){
				g.drawLine((30*i)+chessBoardX+15,chessBoardY,(30*i)+chessBoardX+15,chessBoardY+chessBoardHeight);
			}

//		Data.blackChess.paintIcon(this, g, 45, 105);
//		Data.blackChess.paintIcon(this, g, 70, 105);
//		Data.blackChess.paintIcon(this, g, 100, 105);
//		Data.blackChess.paintIcon(this, g, 130, 105);
//		Data.blackChess.paintIcon(this, g, 160, 105);
//		Data.whiteChess.paintIcon(this, g, 1125, 105);
		//(whiteX[0] % 30 + 15 <= 2 || whiteX[0] % 30 + 15 >= 28) && (whiteY[0] % 30 + 15 <= 2 || whiteY[0] % 30 + 15>= 28) &&
		if(isClick) {
			chessNum++;
			for (int i = 0;i < chessNum;i++)
			{
					Data.whiteChess.paintIcon(this, g, whiteX[i]-whiteX[i]%30, whiteY[i]-whiteY[i]%30);
					Data.blackChess.paintIcon(this, g, blackX[i]-blackX[i]%30, blackY[i]-blackY[i]%30);
			}
		}

	}


	@Override
	public void mouseClicked(MouseEvent e) {
		if(chessNum % 2 == 0){
			whiteX[chessNum] = e.getX();
			whiteY[chessNum] = e.getY();
			System.out.println(whiteX[chessNum]);
			System.out.println(whiteX[chessNum]);
			whiteChessStep++;
		}else if(chessNum % 2 == 1){
			blackX[chessNum] = e.getX();
			blackY[chessNum] = e.getY();
			System.out.println(whiteX[chessNum]);
			System.out.println(whiteX[chessNum]);
			blackChessStep=blackChessStep+1;
		}

		System.out.println(chessNum);
		isClick = true;
		repaint();
	}
	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}
	@Override
	public void mouseEntered(MouseEvent e) {
	}
	@Override
	public void mouseExited(MouseEvent e) {
	}

}
