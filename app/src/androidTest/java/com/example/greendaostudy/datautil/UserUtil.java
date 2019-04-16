package com.example.greendaostudy.datautil;

import android.content.Context;

import com.example.greendaostudy.database.DaoManage;
import com.example.greendaostudy.dataobject.User;

import java.util.List;

public class UserUtil {

    private DaoManage manage;

    public UserUtil(Context context){
        manage = DaoManage.getInstance();
        manage.init(context);
    }

    public boolean insert(User user){
        boolean flag = false;

        long ret = manage.getDaoSession().getUserDao().insert(user);

        if (ret != -1)
            flag = true;

        return flag;
    }

    public boolean insertList(final List<User> users){
        boolean flag = false;

        try {
            manage.getDaoSession().runInTx(new Runnable() {
                @Override
                public void run() {
                    for (User user : users)
                        manage.getDaoSession().getUserDao().insert(user);
                }
            });

            flag = true;
        } catch (Exception e){
            e.printStackTrace();
        }

        return flag;
    }

    public boolean update(User user){
        boolean flag = false;

        try {
            manage.getDaoSession().getUserDao().update(user);
            flag = true;
        } catch (Exception e){
            e.printStackTrace();
        }

        return flag;
    }

    public boolean delete(User user){
        boolean flag = false;

        try {
            manage.getDaoSession().getUserDao().delete(user);
            flag = true;
        } catch (Exception e){
            e.printStackTrace();
        }

        return flag;
    }
}
