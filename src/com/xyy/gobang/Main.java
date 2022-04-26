package com.xyy.gobang;

/**
 * @author 皮皮瑶
 * @proname
 * @data 2022/4/26- 1:04
 */
public class Main {
		//添加画板（棋盘运行画面在此之中）
		public static void main(String[] args) {
			GameJframe gameJframe = new GameJframe();

			gameJframe.add(new GamePanel());


			gameJframe.setVisible(true);

		}


}
