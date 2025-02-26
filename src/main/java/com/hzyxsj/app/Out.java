package com.hzyxsj.app;
import com.hzyxsj.*;
import com.hzyxsj.util.readFile;
import com.hzyxsj.util.writeFile;

import java.io.IOException;

/**
 * 作者：宇宙超级无敌大马猴
 * 姓：亥
 * 字：子曜
 * 号：栖逸居士
 * 版本号：随缘
 */
public class Out {
    public void decodeImgToMessage(String decodeImg,String filepath) throws IOException {
        new ImageToRGB().imgToRgb(decodeImg,filepath);
        System.out.println("完成了图片的解码");
        String s = new readFile().readFile2(filepath);
        System.out.println("完成了二进制文件的读取");
        String s1 = new MessageRead().decodeBinary(s);
        System.out.println("完成了二进制文件的解码");
        System.out.println("下面展示解码内容");
        System.out.println(s1);
        new writeFile().write(filepath,s1);
        System.out.println("完成了解码后文本的书写");
    }

    public void decodeImgToMessage(String decodeImg){

    }
}
