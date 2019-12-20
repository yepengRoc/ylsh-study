package com.ylsh.jvm;

import org.junit.Test;

import java.io.*;

public class Sty016 extends ClassLoader {

    private String classLoaderName;

    private final String fileExtension = ".class";

    private  String path = "";

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Sty016(String classLoaderName){
        super();
        this.classLoaderName = classLoaderName;

    }

    /**
     *
     * @param classLoaderName
     * @param parent 父加载器
     */

    public Sty016(String classLoaderName,ClassLoader parent){
        super(parent);
        this.classLoaderName = classLoaderName;

    }


    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        System.out.println("findClass invoked:" + name);
        System.out.println("class loader name:" + this.classLoaderName);

        byte[] data = this.loadClassData(name);
        return this.defineClass(name, data, 0, data.length);
       // return super.findClass(name);
    }

    private byte[] loadClassData(String name){
        InputStream is = null;
        byte[] data = null;
        ByteArrayOutputStream baos = null;

        try {
            this.classLoaderName = this.classLoaderName.replace(".", "/");
            is = new FileInputStream(new File(name + this.fileExtension));
            baos = new ByteArrayOutputStream();

            int ch = 0;
            while(-1 != (ch = is.read())){
                baos.write(ch);

            }
            data = baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            try {
                is.close();
                baos.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        return data;


    }

    @Override
    public String toString() {
        return "[" + this.classLoaderName + "]";
    }

    /**
     * 结果中没有 findClass 说明没有用到自定义的类。因为父类加载器加载了
     *
     * 这里指定了path还是没有打印findClass，因为已经有了，所以不会再加载，删除之后，再次执行代码就有了
     *-XX:+TraceClassUnloading  查看类的卸载情况
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception{
        Sty016 load1 = new Sty016("load1");
        load1.setPath("/Users/yexiaoheiheliunuannuan/Desktop");

        Class<?> clazz = load1.loadClass("com.ylsh.jvm.Sty001");
        System.out.println("class:" + clazz.hashCode());

        Object object = clazz.newInstance();
        System.out.println(object);
        System.out.println(object.getClass().getClassLoader());
        /**
         * 新的加载器，hashcode 不一样。因为命名空间不同
         */
        Sty016 loader2 = new Sty016("load2");
        loader2.setPath("/Users/yexiaoheiheliunuannuan/Desktop");
        Class<?> clazz2 = loader2.loadClass("com.ylsh.jvm.Sty001");
        System.out.println("class:" + clazz2.hashCode());

        Object object2 = clazz.newInstance();
        System.out.println(object2);
        /**
         * 指定父类加载器。这里的hashcode和loader1一样。虽然命名空间不同，但是都是由委托父类进行加载的。
         * 子加载器可以看到父加载器加载的类，父加载器看不到子加载器加载的类
         */
        Sty016 loader3 = new Sty016("load2",load1);
        loader3.setPath("/Users/yexiaoheiheliunuannuan/Desktop");
        Class<?> clazz3 = loader3.loadClass("com.ylsh.jvm.Sty001");
        System.out.println("class:" + clazz3.hashCode());

        Object object3 = clazz.newInstance();
        System.out.println(object3);



    }

    /**
     * 测试类的卸载
     * @throws Exception
     *
     *
     */
    @Test
    public void testUnload() throws Exception{
        Sty016 load1 = new Sty016("load1");
        load1.setPath("/Users/yexiaoheiheliunuannuan/Desktop");

        Class<?> clazz = load1.loadClass("com.ylsh.jvm.Sty001");
        System.out.println("class:" + clazz.hashCode());

        Object object = clazz.newInstance();
        System.out.println(object);
        System.out.println(object.getClass().getClassLoader());

        /**
         * 如果不加这几行，看不到卸载信息。
         */
        load1 = null;
        clazz = null;
        object = null;

        load1 = new Sty016("load1");
        load1.setPath("/Users/yexiaoheiheliunuannuan/Desktop");
        clazz = load1.loadClass("com.ylsh.jvm.Sty001");
        System.out.println("class:" + clazz.hashCode());

        object = clazz.newInstance();
        System.out.println(object);
    }


}
