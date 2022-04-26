package com.xyy.gobang;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author 皮皮瑶
 * @proname
 * @data 2022/4/24- 16:39
 * @gobang day one
 */
public class GameJframe extends JFrame implements ActionListener{
		//1.绘制游戏程序窗口的大小
		//获取屏幕的尺寸
	public GameJframe() throws HeadlessException {
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		System.out.println(width+","+height);
		setSize(900, 1000);
		setLocation((width-900)/2, (height-900)/2);//设置窗口离主屏幕各边距离相等（上下居中）
		setTitle("pp五子棋");
		getContentPane().setBackground(new Color(209,146,17));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setJMenuBar(createMenu());
	}


	//绘制菜单选项
	public JMenuBar createMenu(){
		JMenuBar jmb = new JMenuBar();
		//字体
		Font font = getFont();
		//创建一级的菜单选项
		JMenu jMenu1 = new JMenu("游戏");
		jMenu1.setFont(font);
		JMenu jMenu2 = new JMenu("帮助");
		jMenu2.setFont(font);
		jmb.add(jMenu1);
		jmb.add(jMenu2);
		//创建二级的菜单选项
		JMenuItem jMenuItem1 = new JMenuItem("新游戏");
		JMenuItem jMenuItem2 = new JMenuItem("退出游戏");
		jMenu1.add(jMenuItem1);
		jMenu1.add(jMenuItem2);
		JMenuItem jMenuItem3 = new JMenuItem("操作帮助");
		JMenuItem jMenuItem4 = new JMenuItem("胜利条件判定");
		jMenu2.add(jMenuItem3);
		jMenu2.add(jMenuItem4);
		//添加监听
		jMenuItem1.addActionListener(this);
		jMenuItem2.addActionListener(this);
		jMenuItem3.addActionListener(this);
		jMenuItem4.addActionListener(this);
		//设置指令
		jMenuItem1.setActionCommand("第一个");
		jMenuItem2.setActionCommand("第二个");
		jMenuItem3.setActionCommand("第三个");
		jMenuItem4.setActionCommand("第四个");




		return jmb;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.print("点击了");
		String command = e.getActionCommand();
		System.out.println(command);

	}
	public Font getFont(){
		Font font = new Font("思源宋体",Font.BOLD,18);
		return font;
	}


}
