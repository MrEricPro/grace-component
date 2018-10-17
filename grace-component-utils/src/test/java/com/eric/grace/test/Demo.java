package com.eric.grace.test;

import com.eric.grace.test.Test;

/**
 * Demo:
 *
 * @author: MrServer
 * @since: 2018/3/5 下午2:58
 */
public class Demo {

    public static void main(String[] args){
        Test singleton=Test.getInstance();
        System.out.println("a:"+singleton.a);
        System.out.println("b:"+singleton.b);
    }

}