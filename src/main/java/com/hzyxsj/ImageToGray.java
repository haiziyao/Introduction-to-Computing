package com.hzyxsj;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 作者：宇宙超级无敌大马猴
 * 姓：亥
 * 字：子曜
 * 号：栖逸居士
 * 版本号：随缘
 */
public class ImageToGray {
    /**
     *
     * @param img 传入图片地址
     * @param filepath 传入要将内容写出的文件地址
     */
    public  void imgTogray(String img,String filepath) throws IOException {
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
        for(int y=0;y<height;y++){
            for(int x=0;x<width;x++){
                Color c=new Color(bf.getRGB(x,y));
                rgb[y][x]=new  RGB();
                int[] num=new int[3];
                rgb[y][x].r= c.getRed();
                rgb[y][x].g=c.getGreen();
                rgb[y][x].b=c.getBlue();
                int gray = rgb[y][x].getGray();

                    String s=Integer.toBinaryString(gray);
                    int a= (int)s.charAt(s.length()-1);
                    bos.write(a);


            }
        }
        bos.close();
    }

    static class RGB{
        int r,g,b;

        public int getGray(){
            return (int) (0.299 * r + 0.587 * g + 0.114 * b);
        }
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


