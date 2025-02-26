package com.hzyxsj;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * 作者：宇宙超级无敌大马猴
 * 姓：亥
 * 字：子曜
 * 号：栖逸居士
 * 版本号：随缘
 */
public class ImageCode {
    /**
     * @param message   需要隐藏的信息
     * @param image     原图片地址
     * @param codeimage 新图片地址
     */
    public void CodemessageToImage(String message, String image, String codeimage) throws IOException {
        java.awt.image.BufferedImage bf = null;
        java.awt.image.BufferedImage bf2 = null;
        try {
            bf = ImageIO.read(new File(image));
        } catch (IOException e) {
            throw new IOException(e);
        }
        if (bf == null) {
            System.out.println("文件不存在");
            return;
        }
        //得到图片的宽高
        int height = bf.getHeight();
        int width = bf.getWidth();
        bf2 = new java.awt.image.BufferedImage(width, height, java.awt.image.BufferedImage.TYPE_INT_RGB);

        String hidemessage = new MessageHiden().hidemessage(message);
        int strlen=hidemessage.length();
        int add=0;
        int newrgb;
        int[][] RGB=new int[height][width];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Color c = new Color(bf.getRGB(x, y));
                int[] num = new int[3];
                num[0] = c.getRed();
                num[1] = c.getGreen();
                num[2] = c.getBlue();
                for (int i = 0; i < 3; i++) {
                     num[i]=((num[i]>>1)<<1)+((int) add<strlen?hidemessage.charAt(add++)-48:0);
//                    num[i] = (num[i] >>1)<<1;
//                    int temp = (add<strlen)? hidemessage.charAt(add++):0;
//                    num[i]  =   temp;
                }
                newrgb=(num[0] << 16) | (num[1] << 8) | num[2];
                bf2.setRGB(x,y,newrgb);

            }
            File outputfile = new File(codeimage);
            ImageIO.write(bf2, "png", outputfile);

        }
    }
}
