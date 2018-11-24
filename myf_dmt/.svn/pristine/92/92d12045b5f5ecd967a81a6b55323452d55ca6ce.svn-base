package com.bjdreamtech.dmt.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * 验证码生成工具
 * @author duanwu
 *
 */
public class DMTImageUtil {
	// 验证码图片的宽度
	private static int width = 70;
	// 验证码图片的高度
	private static int height = 25;
	// 字符间距
	private static int x = 15;
	// 字体高度
	private static int fontHeight = 23;
	private static int codeY = 21;
	private static char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G',
			'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
			'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6',
			'7', '8', '9' };

	/**
	 * 得到图片缓存
	 * @param code 验证码
	 * @return 图片缓存
	 */
	public static BufferedImage getBufferImage(String code) {
		// 定义图像buffer
		BufferedImage bufferedImage = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		// 创建图像上下文
		Graphics2D g = bufferedImage.createGraphics();
		// 创建随机数生成器
		Random random = new Random();
		// 将图像背景填充为白色
		g.setColor(Color.WHITE);
		// 填充矩形
		g.fillRect(0, 0, width, height);
		// 创建字体，字体的大小应该根据图片的高度来定
		Font font = new Font("Fixedsys", Font.PLAIN | Font.BOLD | Font.ITALIC, fontHeight);
		// 设置字体
		g.setFont(font);
		// 画边框
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, width-1, height-1);
		// 随机产生160条干扰线，使图象中的认证码不易被其它程序探测到
		g.setColor(Color.pink);
		for (int i = 0; i < 160; i++) {
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int xl = random.nextInt(12);
			int yl = random.nextInt(12);
			g.drawLine(x, y, x + xl, y + yl);
		}
		// 画出验证码
		for (int i = 0; i < code.length(); i++) {
			// 设置随即颜色
			g.setColor(new Color(random.nextInt(200), random.nextInt(200),
					random.nextInt(200)));
			g.drawString(code.substring(i, i + 1), (i + 1) * x - 6, codeY);
		}
		g.dispose();
		return bufferedImage;
	}

	/**
	 * 随即生成验证码
	 * @return 验证码字符串
	 */
	public static String getCode() {
		String code = "";
		for (int i = 0; i < 4; i++) {
			code += String.valueOf(codeSequence[new Random().nextInt(36)]);
		}
		return code;
	}
	
	
}
