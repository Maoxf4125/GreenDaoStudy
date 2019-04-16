package com.example.greendaostudy;

import android.content.Context;
import android.support.test.InstrumentationRegistry;

import com.example.greendaostudy.dataobject.User;
import com.example.greendaostudy.datautil.UserUtil;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import java.util.ArrayList;
import java.util.List;

public class Test {

    private static List<User> users = new ArrayList<>();
    private static Context context = InstrumentationRegistry.getInstrumentation().getTargetContext();
    private static UserUtil userUtil;

    @BeforeClass
    public static void SetUp(){
        init();
        userUtil = new UserUtil(context);
    }

    private static void init(){
        User mao = new User(3, "Maoxf", "M", 2);
        User zhong = new User(4, "Zhongch", "M", 2);
        User yang = new User(1, "Yangxr", "W", 1);
        User chen = new User(2, "Chenyy", "M", 2);
        users.add(mao);
        users.add(zhong);
        users.add(yang);
        users.add(chen);
    }

    @AfterClass
    public static void TearDown(){

    }

    @org.junit.Test
    public void test1(){
        System.out.println("test1");
        System.out.println(userUtil.insert(users.get(0)));
    }

    @org.junit.Test
    public void test2(){
        System.out.println("test2");
        System.out.println(userUtil.insert(users.get(1)));
    }

    @org.junit.Test
    public void test3(){
        System.out.println("test3");
        System.out.println(userUtil.insert(users.get(2)));
        System.out.println(userUtil.insert(users.get(3)));
    }

    @org.junit.Test
    public void test4(){
        System.out.println("test4");
        System.out.println(userUtil.delete(users.get(0)));
    }
}
