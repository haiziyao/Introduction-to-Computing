package test;

import com.hzyxsj.ImageCode;
import com.hzyxsj.ImageToRGB;
import com.hzyxsj.MessageRead;
import com.hzyxsj.util.readFile;
import com.hzyxsj.util.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.annotation.Target;
import java.util.Properties;

/**
 * 作者：宇宙超级无敌大马猴
 * 姓：亥
 * 字：子曜
 * 号：栖逸居士
 * 版本号：随缘
 */

/**
 * 将文字嵌入图片
 */
public class TestImageCode {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileReader("src/main/resources/detail.properties"));

        String image=properties.getProperty("image");
        String codeiamge=properties.getProperty("codeimage");
        String message="这是一个测试";
        String filename=properties.getProperty("filename");
        new ImageCode( ).CodemessageToImage(message,image,codeiamge);
        System.out.println("完成了图片的编码");
        new ImageToRGB().imgToRgb(codeiamge,filename);
        System.out.println("完成了图片的解码");
        String s = new readFile().readFile2(filename);
        System.out.println("完成了二进制文件的读取");
        String s1 = new MessageRead().decodeBinary(s);
        System.out.println("完成了二进制文件的解码");
        new writeFile().write(filename,s1);
        System.out.println("完成了解码后文本的书写");
    }
}
