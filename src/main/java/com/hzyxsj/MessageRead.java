package com.hzyxsj;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * 作者：宇宙超级无敌大马猴
 * 姓：亥
 * 字：子曜
 * 号：栖逸居士
 * 版本号：随缘
 */
public class MessageRead {
    int model = 1;
    public String decodeBinary(String binary){
        int length=8*model;
        int bytecount=binary.length()/length;
        byte[] bytes=new byte[bytecount];
        for (int i=0;i<bytecount;i++){
            String substring = binary.substring(i * length, i * length + length);
            try {
                bytes[i] =(byte) Integer.parseInt(substring, 2);
            } catch (NumberFormatException e) {
               break;
            }
            //System.out.print(bytes[i]+"\t");
        }

        return new String(bytes, StandardCharsets.UTF_8);
    }

}
