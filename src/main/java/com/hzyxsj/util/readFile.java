package com.hzyxsj.util;

import java.io.*;

/**
 * 作者：宇宙超级无敌大马猴
 * 姓：亥
 * 字：子曜
 * 号：栖逸居士
 * 版本号：随缘
 */
public class readFile {
    public String readFile(String fileName) throws IOException {
        BufferedInputStream bf = new BufferedInputStream(new FileInputStream(fileName));
        int data;
        byte[] buffer = new byte[1024];
        String str="";
        while((data=bf.read(buffer))!=-1){
             str=str+buffer.toString();
        }
        bf.close();
        return str;

    }
    public String readFile2(String fileName) throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader(fileName));
        String str="";
        String temp;
        while((temp=bf.readLine())!=null){
            str=str+temp;
        }
        bf.close();
        return str;
    }
}
