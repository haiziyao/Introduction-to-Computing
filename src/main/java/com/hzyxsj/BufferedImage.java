package com.hzyxsj;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 作者：宇宙超级无敌大马猴
 * 姓：亥
 * 字：子曜
 * 号：栖逸居士
 * 版本号：随缘
 */
public class BufferedImage {
    public static void main(String[] args) throws IOException {

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File
                ("C:/Users/17542/Desktop/homework.txt"),
                false));//老是忘记 false代表覆盖
        java.awt.image.BufferedImage bf = null;
        java.awt.image.BufferedImage bf2 = null;
        try {
              bf = ImageIO.read(new File("src/main/resources/img/img1.png"));
            bf2 = ImageIO.read(new File("src/main/resources/img/img2.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int height=bf.getHeight();
        int width=bf.getWidth();

        //此行代码显示宽高，没必要加，只是用于校验
        //System.out.println(""+height+"    "+width);
        RGB[][] rgb=new RGB[height][width];
        for (int y=0;y<height;y++) {
            for (int x=0;x<width;x++) {
                Color c=new Color(bf.getRGB(x, y));
                Color c2=new Color(bf2.getRGB(x, y));
                RGB rgb1 = new RGB();
                RGB rgb2 = new RGB();
                rgb1.r=c.getRed();
                rgb1.g=c.getGreen();
                rgb1.b=c.getBlue();
                rgb2.r=c2.getRed();
                rgb2.g=c2.getGreen();
                rgb2.b=c2.getBlue();
                rgb[y][x]=rgb1;

                if (!rgb1.encode().equals(rgb2.encode()  )) {
                    bufferedWriter.write( rgb2.encode());
                }

            }
            bufferedWriter.write(".....................................................");
        }

        bufferedWriter.close();
        System.out.println(
                "已完成"
        );






    }
    static class RGB{
        int r,g,b;
        //我直接写个取最后一位数的方法，你不炸了吗
        public String encode(){
            return  ""+r%10+g%10+b%10;
        }
        @Override
        public String toString() {
            return  "["+r+","+g+","+b+"]";
        }
    }
}
