package com.hzyxsj;

import com.hzyxsj.util.readFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 作者：宇宙超级无敌大马猴
 * 姓：亥
 * 字：子曜
 * 号：栖逸居士
 * 版本号：随缘
 */
public class TRy {
    public static void main(String[] args) throws IOException {
//        Integer a=255;
//        String as=Integer.toBinaryString(a);
//        System.out.println(as);
//        byte[] mmm={0,1,0,1,0,1,0,1};
//        String s=new String(mmm, StandardCharsets.UTF_8);
//        System.out.println(s);

        System.out.println("----------------------");
        String thisIsATest = new MessageHiden().hidemessage("这是一个测试");
        System.out.println(thisIsATest );

        System.out.println("-------------------");
        String binary=new readFile().readFile2("C:/Users/17542/Desktop/ascii.txt");
        String endcodestr=new MessageRead().decodeBinary(binary);
        System.out.println(endcodestr);

    }
}
