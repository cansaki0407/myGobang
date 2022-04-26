package com.xyy.gobang;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 皮皮瑶
 * @proname
 * @data 2022/4/24- 18:02
 */
public class GamePanel extends JPanel {
	int ChessboardX1 = 30;
	int ChessboardX2 = 870;
	int ChessboardY1 = 30;
	int ChessboardY2 = 870;
	int spacing = 60;
	int rows = 15;
	int cols = 15;
	String gameFlage = "start";
	//初始化指示器二维数组
	Pointer[][] pointers = new Pointer[rows][cols];
	//初始化棋子集合
	private List<Chess> chessList = new ArrayList<Chess>();
	//落子颜色判断
	int chessJuge = 1;
	//游戏结束
	boolean gameOver = false;



	//构造方法
	GamePanel(){
		//加载图片
		ImageData.init();
		this.setOpaque(false);
		//创建鼠标监听
		createMouseListener();
		//创建指示器二维数组内容
		createPointers();
	}



	//绘制棋盘内容
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		//绘制棋盘
		drawChessboard(g);
		//绘制五个主点
		dramFiveMainPoint(g);
		//绘制指示器
		drawPointer(g);
		//绘制棋子
		drawChess(g);

		//绘制游戏结束的文字
		if(gameOver){
			g.setColor(Color.red);
			g.setFont(new Font("宋体",Font.BOLD,50));
			g.drawString("游戏结束", 300, 300);
		}

	}


	private void createMouseListener() {
		MouseAdapter mouseAdapter = new MouseAdapter() {
			@Override
			//鼠标移动事件
			public void mouseMoved(MouseEvent e) {
				super.mouseMoved(e);
				if(!"start".equals(gameFlage)){
					return;
				}
				//获取鼠标的坐标
				int x = e.getX();
				int y = e.getY();
				System.out.println(x+","+y);
				Pointer pointer = null;
				for (int i = 0; i < rows;i++){
					for (int j = 0;j < cols;j++){
						pointer = pointers[i][j];
						if(pointer.isPoint(x, y)){
							pointer.setShow(true);
						}else{
							pointer.setShow(false);
						}
					}
				}
				repaint();
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				int x = e.getX();
				int y = e.getY();
				//System.out.println(x+","+y);
				Pointer pointer = null;
				Chess chess = null;
				for (int i = 0; i < rows;i++){
					for (int j = 0;j < cols;j++){
						pointer = pointers[i][j];
						if(pointer.isPoint(x, y)&&pointer.getType()==0){
							chess = new Chess(pointer.getX(),pointer.getY(),chessJuge);
							chessList.add(chess);
							pointer.setType(chessJuge);
							//System.out.println("啦啦啦啦啦啦啦啦啦啦啦");
							checkSuccess(pointer,i,j,chessJuge);
							repaint();
							if(chessJuge==1){
								chessJuge = 2;
							}else if (chessJuge==2){
								chessJuge = 1;
							}
							return;
						}
					}
				}
			}
		};
		addMouseMotionListener(mouseAdapter);
		addMouseListener(mouseAdapter);
	}

	//绘制棋盘
	private void drawChessboard(Graphics g){
		for (int i = 0; i < 15;i++){
			g.drawLine(ChessboardX1, ChessboardY1+spacing*i, ChessboardX2, ChessboardY1+spacing*i);
		}
		for (int i = 0;i < 15;i++){
			g.drawLine(ChessboardX1+spacing*i, ChessboardY1, ChessboardX1+spacing*i, ChessboardY2);
		}
	}

	//绘制五个主点
	private void dramFiveMainPoint(Graphics g){
		int px = ChessboardX1 + spacing*3-6;
		int py = ChessboardY1 + spacing*3-6;
		g.fillArc(px, py, 12, 12, 0, 360);

		px = ChessboardX1 + spacing*12-6;
		py = ChessboardY1 + spacing*3-6;
		g.fillArc(px, py, 12, 12, 0, 360);

		px = ChessboardX1 + spacing*3-6;
		py = ChessboardY1 + spacing*12-6;
		g.fillArc(px, py, 12, 12, 0, 360);

		px = ChessboardX1 + spacing*12-6;
		py = ChessboardY1 + spacing*12-6;
		g.fillArc(px, py, 12, 12, 0, 360);

		px = ChessboardX1 + spacing*7-6;
		py = ChessboardY1 + spacing*7-6;
		g.fillArc(px, py, 12, 12, 0, 360);
	}

	//创建指示器坐标二维数组
	private void createPointers() {
		int x;
		int y;
		int starter = 30;
		Pointer pointer = null;
		for (int i = 0 ;i < rows;i++){
			for (int j = 0; j < cols;j++){
				x = starter+j*spacing;
				y = starter+i*spacing;
				System.out.println(x+","+y);
				pointer = new Pointer(i,j,x,y);
				pointers[i][j] = pointer;
			}
		}
	}

	//绘制指示器
	private void drawPointer(Graphics g){
		Pointer pointer = null;
		for (int i = 0 ;i < rows;i++){
			for (int j = 0; j < cols;j++){
				pointer = pointers[i][j];
				pointer.dramPointer(g);
			}
		}
	}

	//绘制棋子
	private void drawChess(Graphics g) {
		Chess chess = null;
		for (int i = 0; i < chessList.size();i++){
			chess = chessList.get(i);
			chess.drawChess(g);
		}
	}


	//判断五子连珠是否成立
	void checkSuccess(Pointer pointer,int i,int j,int chessJuge){
		int num = 0;
		int k = 1;

		//横向五连
		while (pointers[i][j-k].getType()==chessJuge){
			System.out.println("牛皮");
			k++;
			num++;
			if (num == 4){
				gameOver = true;
				return; }
		}
		 num = 0;
		 k = 1;
		while (pointers[i][j+k].getType()==chessJuge){
			k++;
			num++;
			if (num == 4){
				gameOver = true;
				return;
			}
		}
		num = 0;
		k = 1;
		while (pointers[i][j-k].getType()==chessJuge&&pointers[i][j+k].getType()==chessJuge){
			k++;
			num++;
			if (num == 2){
				gameOver = true;
				return;
			}
		}
		num = 0;
		k = 1;
		while (pointers[i][j-k].getType()==chessJuge){
			k++;
			if (k==3&&pointers[i][j+1].getType()==chessJuge){
				gameOver = true;
				return;
			}
		}
		num = 0;
		k = 1;
		while (pointers[i][j+k].getType()==chessJuge){
			k++;
			if (k==3&&pointers[i][j-1].getType()==chessJuge){
				gameOver = true;
				return;
			}
		}

		//纵向五连
		num = 0;
		k = 1;
		while (pointers[i-k][j].getType()==chessJuge){
			System.out.println("牛皮");
			k++;
			num++;
			if (num == 4){
				gameOver = true;
				return; }
		}
		num = 0;
		k = 1;
		while (pointers[i+k][j].getType()==chessJuge){
			k++;
			num++;
			if (num == 4){
				gameOver = true;
				return;
			}
		}
		num = 0;
		k = 1;
		while (pointers[i-k][j].getType()==chessJuge&&pointers[i+k][j].getType()==chessJuge){
			k++;
			num++;
			if (num == 2){
				gameOver = true;
				return;
			}
		}
		num = 0;
		k = 1;
		while (pointers[i-k][j].getType()==chessJuge){
			k++;
			if (k==3&&pointers[i+1][j].getType()==chessJuge){
				gameOver = true;
				return;
			}
		}
		num = 0;
		k = 1;
		while (pointers[i+k][j].getType()==chessJuge){
			k++;
			if (k==3&&pointers[i-1][j].getType()==chessJuge){
				gameOver = true;
				return;
			}
		}

		//左对角五连
		num = 0;
		k = 1;
		while (pointers[i-k][j-k].getType()==chessJuge){
			System.out.println("牛皮");
			k++;
			num++;
			if (num == 4){
				gameOver = true;
				return; }
		}
		num = 0;
		k = 1;
		while (pointers[i+k][j+k].getType()==chessJuge){
			k++;
			num++;
			if (num == 4){
				gameOver = true;
				return;
			}
		}
		num = 0;
		k = 1;
		while (pointers[i-k][j-k].getType()==chessJuge&&pointers[i+k][j+k].getType()==chessJuge){
			k++;
			num++;
			if (num == 2){
				gameOver = true;
				return;
			}
		}
		num = 0;
		k = 1;
		while (pointers[i-k][j-k].getType()==chessJuge){
			k++;
			if (k==3&&pointers[i+1][j+1].getType()==chessJuge){
				gameOver = true;
				return;
			}
		}
		num = 0;
		k = 1;
		while (pointers[i+k][j+k].getType()==chessJuge){
			k++;
			if (k==3&&pointers[i-1][j-1].getType()==chessJuge){
				gameOver = true;
				return;
			}
		}

		//右对角五连
		num = 0;
		k = 1;
		while (pointers[i+k][j-k].getType()==chessJuge){
			System.out.println("牛皮");
			k++;
			num++;
			if (num == 4){
				gameOver = true;
				return; }
		}
		num = 0;
		k = 1;
		while (pointers[i-k][j+k].getType()==chessJuge){
			k++;
			num++;
			if (num == 4){
				gameOver = true;
				return;
			}
		}
		num = 0;
		k = 1;
		while (pointers[i-k][j+k].getType()==chessJuge&&pointers[i+k][j-k].getType()==chessJuge){
			k++;
			num++;
			if (num == 2){
				gameOver = true;
				return;
			}
		}
		num = 0;
		k = 1;
		while (pointers[i-k][j+k].getType()==chessJuge){
			k++;
			if (k==3&&pointers[i+1][j-1].getType()==chessJuge){
				gameOver = true;
				return;
			}
		}
		num = 0;
		k = 1;
		while (pointers[i+k][j-k].getType()==chessJuge){
			k++;
			if (k==3&&pointers[i-1][j+1].getType()==chessJuge){
				gameOver = true;
				return;
			}
		}

	}

}



























