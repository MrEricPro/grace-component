package com.eric.grace.test;

/**
 * Test:
 *
 * @author: MrServer
 * @since: 2018/3/5 下午2:57
 */
public class Test {

    public static int a;
    public static int b=0;
    private static Test test = new Test();
//    public static int a;
//    public static int b=0;

    private Test(){
        a++;
        b++;
    }

    public static Test getInstance(){
        return test;
    }




}