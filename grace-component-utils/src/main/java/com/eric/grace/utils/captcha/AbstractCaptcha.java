package com.eric.grace.utils.captcha;

import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.OutputStream;

import com.eric.grace.utils.io.FileUtil;
import com.eric.grace.utils.io.IORuntimeException;
import com.eric.grace.utils.common.ImageUtil;
import com.eric.grace.utils.common.RandomUtil;
import com.eric.grace.utils.common.StrUtil;

/**
 * 抽象验证码<br>
 * 抽象验证码实现了验证码字符串的生成、验证，验证码图片的写出<br>
 * 实现类通过实现{@link #createImage(String)} 方法生成图片对象
 * 
 * @author looly
 *
 */
public abstract class AbstractCaptcha implements ICaptcha {
	private static final long serialVersionUID = 3180820918087507254L;

	// 图片的宽度。
	protected int width = 100;
	// 图片的高度。
	protected int height = 37;
	// 验证码字符个数
	protected int codeCount = 4;
	// 验证码干扰元素个数
	protected int interfereCount = 15;
	// 字体
	protected Font font;
	// 验证码
	protected String code;
	// 验证码图片Buffer
	protected BufferedImage image;

	/**
	 * 构造
	 * 
	 * @param width 图片宽
	 * @param height 图片高
	 * @param codeCount 字符个数
	 * @param interfereCount 验证码干扰元素个数
	 */
	public AbstractCaptcha(int width, int height, int codeCount, int interfereCount) {
		this.width = width;
		this.height = height;
		this.codeCount = codeCount;
		this.interfereCount = interfereCount;
		// 字体高度设为验证码高度-2，留边距
		this.font = new Font("Courier", Font.PLAIN, this.height - 2);
	}

	@Override
	public void createCode() {
		this.code = RandomUtil.randomString(this.codeCount);
		createImage(this.code);
	}

	public abstract void createImage(String code);

	@Override
	public String getCode() {
		return this.code;
	}

	@Override
	public boolean verify(String userInputCode) {
		if (StrUtil.isNotBlank(userInputCode)) {
			return StrUtil.equalsIgnoreCase(getCode(), userInputCode);
		}
		return false;
	}

	/**
	 * 验证码写出到文件
	 * 
	 * @param path 文件路径
	 * @throws IORuntimeException IO异常
	 */
	public void write(String path) throws IORuntimeException {
		this.write(FileUtil.getOutputStream(path));
	}

	/**
	 * 验证码写出到文件
	 * 
	 * @param file 文件
	 * @throws IORuntimeException IO异常
	 */
	public void write(File file) throws IORuntimeException {
		this.write(FileUtil.getOutputStream(file));
	}

	@Override
	public void write(OutputStream out) {
		ImageUtil.write(this.getImage(), ImageUtil.IMAGE_TYPE_PNG, out);
	}

	/**
	 * 获取验证码图
	 * 
	 * @return 验证码图
	 */
	public BufferedImage getImage() {
		if (null == this.image) {
			createCode();
		}
		return image;
	}

	/**
	 * 自定义字体
	 * 
	 * @param font 字体
	 */
	public void setFont(Font font) {
		this.font = font;
	}
}
