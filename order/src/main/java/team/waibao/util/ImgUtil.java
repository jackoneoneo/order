package team.waibao.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageOutputStream;

/**
 * 图片工具类
 * 
 * @author 曾志鹏
 * @version 创建时间：2016年8月17日 下午1:41:32
 * 
 */
public class ImgUtil {

	/**
	 * 获取默认图片的Blob类型
	 * 
	 * @return
	 */
	public byte[] getImgBytes(File file) {

		final String URL = "images/dog.jpg";// 本地图片URL
		if (file == null)
			file = new File(URL);
		FileInputStream fs = getFileInputStream(file);
		BufferedImage image = getBufferedImage(fs);

		ByteArrayOutputStream bos = new ByteArrayOutputStream(); // 字节输出流

		writerImageInfoToByteArrayOutputStream(image, bos);

		return bos.toByteArray();// generate byte[] //输出流将字节信息输出到byte数组b中

	}

	/**
	 * 
	 * @param image图片的流
	 * @param bos二进制流
	 */
	private void writerImageInfoToByteArrayOutputStream(BufferedImage image,
			ByteArrayOutputStream bos) {
		try {
			ImageIO.write(image, "jpg", bos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 将虚拟图片信息写入到字节输出流中
	}

	private BufferedImage getBufferedImage(FileInputStream fs) {
		BufferedImage image = null;
		try {
			image = ImageIO.read(fs);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 用ImageIO将本地图片文件转换成虚拟图片信息
		return image;
	}

	/**
	 * 获取fileInputStream 对象
	 * 
	 * @param file
	 * @return
	 */
	private FileInputStream getFileInputStream(File file) {
		FileInputStream fs = null;
		try {
			fs = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return fs;
	}

	// byte数组到图片
	public void byte_image(byte[] data, String path) {
		if (data.length < 3 || path.equals(""))
			return;
		try {
			FileImageOutputStream imageOutput = new FileImageOutputStream(
					new File(path));
			imageOutput.write(data, 0, data.length);
			imageOutput.close();
			System.out.println("Make Picture success,Please find image in "
					+ path);
		} catch (Exception ex) {
			System.out.println("Exception: " + ex);
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) {
		byte[] bt = new ImgUtil().getImgBytes(null);
		System.out.println(bt.toString());
		new ImgUtil().byte_image(bt, "I:/d.jpg");
	}
}
