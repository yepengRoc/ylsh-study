package com.ylsh.study.books.nettyqwzn.sty6;

import org.junit.Test;
import org.msgpack.MessagePack;
import org.msgpack.template.Templates;

import java.util.ArrayList;
import java.util.List;

public class SeriaTest {


    public static void test1(String[] args) {
         //Google protobuf
        /**
         * 结构化的数据存储格式 xml json
         * 高效的编解码性能
         * 无言 平台 无关，扩展性好
         * 支持java c++ python
         */

        /**
         * facebook thrift
         * 支持数据序列化和多只用类型的rpc服务。适用于静态的数据交换，需要先确定好它的数据结构，数据变化时，从新编辑idl
         * 文件，生成代码和编译，是thrift的弱项。适用于大型数据交换及存储的通用工具，在json和xml在性能和传输上有明显优势
         *
         */
        /**
         * jboss marshalling
         * 可插拔式类解析器，提供更加便捷的类加载定制策略，通过一个接口即可实现
         * 可插拔的对象替换技术，不需要通过继承的方式
         * 可插拔的预定义类缓存表，可以减小序列化的字节数组长度，提升常用类型的对象序列化性能
         * 无需实现 serializable，即可实现java的序列化
         * 通过缓存技术提升对象的序列化性能
         */

        /**
         * messagetPack
         * 编解码高效，性能搞
         * 序列化之后的码流小
         * 支持语言丰富
         */

    }

    @Test
    public void msgpackTest() throws Exception{

        List<String> src = new ArrayList<>();
        src.add("msgpack");
        src.add("kumofs");
        src.add("viv");
        MessagePack messagePack = new MessagePack();
        byte[] raw = messagePack.write(src);
       List<String> dst1 = messagePack.read(raw, Templates.tList(Templates.TString));
       System.out.println(dst1.get(0));
       System.out.println(dst1.get(1));
       System.out.println(dst1.get(2));

    }

}
