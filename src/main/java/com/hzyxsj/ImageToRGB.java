package com.hzyxsj;

import javax.imageio.ImageIO;
import javax.management.ConstructorParameters;
import java.awt.*;
import java.io.*;

/**
 * 作者：宇宙超级无敌大马猴
 * 姓：亥
 * 字：子曜
 * 号：栖逸居士
 * 版本号：随缘
 */
public class ImageToRGB {
    /**
     *
     * @param img 传入图片地址
     * @param filepath 传入要将内容写出的文件地址
     */
    public  void imgToRgb(String img,String filepath) throws IOException {
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filepath,false));
        java.awt.image.BufferedImage bf = null;
        try {
            bf = ImageIO.read(new File(img));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (bf == null) {
            System.out.println("文件不存在");
            return;
        }
        //得到图片的宽高
        int height=bf.getHeight();
        int width=bf.getWidth();
        //得到了想要RGB的数组,我给出数组只是一个习惯，其实这里应该作用不大
        RGB[][] rgb=new  RGB[height][width];
        int add=0;
        for(int y=0;y<height;y++){
            for(int x=0;x<width;x++){
                Color c=new Color(bf.getRGB(x,y));
                rgb[y][x]=new RGB();
                int[] num=new int[3];
                rgb[y][x].r= c.getRed();
                rgb[y][x].g=c.getGreen();
                rgb[y][x].b=c.getBlue();
                num[0]=c.getRed();
                num[1]=c.getGreen();
                num[2]=c.getBlue();
                for (int i = 0; i < 3; i++) {
                    String s=Integer.toBinaryString(num[i]);
                    int a= (int)s.charAt(s.length()-1);
                    //if (add==8){bos.write(' ');add=0;}
                    bos.write(a);
                    add++;
                }

            }
            //bos.write('\n');
        }
            bos.close();
    }
//这个类作用不大
    static class RGB{
        int r,g,b;
        //我直接写个取最后一位数的方法，你不炸了吗
        public String getLastnum(){
            return  ""+r%10+g%10+b%10;
        }
        @Override
        public String toString() {
            return  "["+r+","+g+","+b+"]";
        }
    }
}
