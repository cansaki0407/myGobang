package com.xyy.gobang;

import com.sun.jndi.toolkit.url.Uri;

import javax.swing.*;
import java.net.URL;
import java.util.Date;

/**
 * @author 皮皮瑶
 * @proname
 * @data 2022/4/24- 18:43
 * 棋子图片获取方法 1
 */
public class Data {
	//提取棋子图片
	public static URL whiteChessUrl = Date.class.getResource("/resources/img/whiteChess.png");
	public static ImageIcon whiteChess = new ImageIcon(whiteChessUrl);
	public static URL blackChessUrl = Date.class.getResource("/resources/img/blackChess.png");
	public static ImageIcon blackChess = new ImageIcon(blackChessUrl);
}
