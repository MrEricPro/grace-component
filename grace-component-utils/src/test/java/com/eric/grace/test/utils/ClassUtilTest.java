package com.eric.grace.test.utils;

import com.eric.grace.utils.common.ClassUtil;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * ClassUtilTest:
 *
 * @author: MrServer
 * @since: 2017/12/28 下午1:48
 */
public class ClassUtilTest {

    @Test
    public void getClassNameTest() {
        String className = ClassUtil.getClassName(ClassUtil.class, false);
        System.out.println(className);

        String simpleClassName = ClassUtil.getClassName(ClassUtil.class, true);
        System.out.println(simpleClassName);
        Assert.assertEquals("ClassUtil", simpleClassName);
    }


    @SuppressWarnings("unused")
    class TestClass {
        private String privateField;
        protected String field;

        private void privateMethod() {
        }

        public void publicMethod() {
        }
    }

    @SuppressWarnings("unused")
    class TestSubClass extends TestClass {
        private String subField;

        private void privateSubMethod() {
        }

        public void publicSubMethod() {
        }

    }

    @Test
    public void getPublicMethod() {
        Method superPublicMethod = ClassUtil.getPublicMethod(TestSubClass.class, "publicMethod");
        System.out.println(superPublicMethod);
        Method superPrivateMethod = ClassUtil.getPublicMethod(TestSubClass.class, "privateMethod");
        Assert.assertNull(superPrivateMethod);

        Method publicMethod = ClassUtil.getPublicMethod(TestSubClass.class, "publicSubMethod");
        Assert.assertNotNull(publicMethod);
        Method privateMethod = ClassUtil.getPublicMethod(TestSubClass.class, "privateSubMethod");
        Assert.assertNull(privateMethod);
    }


}