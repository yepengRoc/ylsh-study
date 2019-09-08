package com.ylsh.study.guauaSty;

import com.google.common.base.Joiner;

import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.List;

public class GuauaSty1  {


    private final List<String> stringList = Arrays.asList("a","b");

    private final List<String> stringListWithNull = Arrays.asList("a","b",null);
    //事件总线
    //
    public void JoinerSty() throws  Exception{
        Joiner.on("#").join(stringList);
        //跳过空值
        Joiner.on("#").skipNulls().join(stringListWithNull);
        //给空值赋默认值
        Joiner.on("#").useForNull("ab").join(stringListWithNull);
//
        StringBuilder sb = new StringBuilder();
        Joiner.on("#").appendTo(sb, stringList);
        Joiner.on("#").useForNull("ab").appendTo(sb, stringListWithNull);

        //也可以向文件writer中添加数据
        FileWriter fw = new FileWriter(new File(""));
        Joiner.on("#").appendTo(fw, stringList);



    }

    public void SpliterSty(){

    }


}
