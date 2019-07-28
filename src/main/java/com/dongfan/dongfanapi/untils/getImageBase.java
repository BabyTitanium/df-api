package com.dongfan.dongfanapi.untils;

import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: lll
 * @Date: 2019/7/21 9:41
 * @Version 1.0
 */
public class getImageBase {
    //获得图片的base64码
    //@SuppressWarnings("deprecation")
    public static Map<String, Object> getBase64(String imgsrc) {

        Map<String, Object> map = new HashMap<String, Object>();
        try {
            double rate = 0;
            int widthdist = 0;
            int heightdist = 0;
            double widthMax = 350;
            double heightMax = 350;

            File srcfile = new File(imgsrc);
            // 检查图片文件是否存在
            if (!srcfile.exists()) {
                System.out.println("文件不存在");
            }
            // 如果比例不为空则说明是按比例压缩
            //获得源图片的宽高存入数组中
            int[] results = getImgWidthHeight(srcfile);

            //计算具体等比比例
            int width = results[0];
            int height = results[1];
            double widthRate = widthMax / width;
            double heightRate = heightMax / height;
            if (heightRate > widthRate) {
                rate = widthRate;
            } else {
                rate = heightRate;
            }

            if (results == null || results[0] == 0 || results[1] == 0) {
                return null;
            } else {
                //按比例缩放或扩大图片大小，将浮点型转为整型
                widthdist = (int) (results[0] * rate);
                heightdist = (int) (results[1] * rate);
            }
            // 开始读取文件并进行压缩
            Image src = ImageIO.read(srcfile);

            // 构造一个类型为预定义图像类型之一的 BufferedImage
            BufferedImage tag = new BufferedImage((int) widthdist, (int) heightdist, BufferedImage.TYPE_INT_RGB);

            //绘制图像  getScaledInstance表示创建此图像的缩放版本，返回一个新的缩放版本Image,按指定的width,height呈现图像
            //Image.SCALE_SMOOTH,选择图像平滑度比缩放速度具有更高优先级的图像缩放算法。
            tag.getGraphics().drawImage(src.getScaledInstance(widthdist, heightdist, Image.SCALE_SMOOTH), 0, 0, null);

//		            //创建文件输出流
//		            FileOutputStream out = new FileOutputStream(imgdist);
//		            //将图片按JPEG压缩，保存到out中
//		            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
//		            encoder.encode(tag);
//		            //关闭文件输出流
//		            out.close();

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(tag, "jpg", baos);
            byte[] bytes = baos.toByteArray();
            BASE64Encoder encoder = new BASE64Encoder();
            map.put("img", encoder.encodeBuffer(bytes).trim());
            map.put("w", widthdist);
            map.put("h", heightdist);
            map.put("name", imgsrc);
            baos.close();
            return map;
        } catch (Exception ef) {
            ef.printStackTrace();
        }
        return null;


    }

    /**
     * 获取图片宽度和高度
     *
     * @param file
     * @return 返回图片的宽度
     */
    public static int[] getImgWidthHeight(File file) {
        InputStream is = null;
        BufferedImage src = null;
        int result[] = {0, 0};
        try {
            // 获得文件输入流
            is = new FileInputStream(file);
            // 从流里将图片写入缓冲图片区
            src = ImageIO.read(is);
            result[0] = src.getWidth(null); // 得到源图片宽
            result[1] = src.getHeight(null);// 得到源图片高
            is.close();  //关闭输入流
        } catch (Exception ef) {
            ef.printStackTrace();
        }

        return result;
    }

}
