package com.xyy.gobang;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author 皮皮瑶
 * @proname
 * @data 2022/4/27- 0:25
 * 棋子图片获取方法2
 */
//图片加载
public class ImageData {
	public static BufferedImage whiteChessImage = null;	//白棋图片
	public static BufferedImage blackChessImage = null;	//黑棋图片
	public static String path = "/resources/img/";

	//初始化图片方法
	public static void init(){
		try {
			whiteChessImage = ImageIO.read(ImageData.class.getResource(path+"whiteChess.png"));
			blackChessImage = ImageIO.read(ImageData.class.getResource(path+"blackChess.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
