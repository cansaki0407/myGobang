package com.xyy.gobang;

import javax.swing.*;
import java.awt.*;

/**
 * @author 皮皮瑶
 * @proname
 * @data 2022/4/24- 16:39
 * @gobang day one
 */
public class GameStarter {
	public static void main(String[] args) {
		//1.绘制游戏程序窗口的大小
		//获取屏幕的尺寸
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		System.out.println(width+","+height);
		JFrame jFrame = new JFrame("pp五子棋");
		jFrame.setSize(1200, 900);
		jFrame.setLocation((width-1200)/2, (height-900)/2);//设置窗口离主屏幕各边距离相等（上下居中）
		//jFrame.setTitle("pp五子棋");
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//2.添加画板（棋盘运行画面在此之中）
		jFrame.add(new GamePanel());

		jFrame.setVisible(true);

	}
}
