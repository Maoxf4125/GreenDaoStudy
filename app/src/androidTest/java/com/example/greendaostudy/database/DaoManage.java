package com.example.greendaostudy.database;

import android.content.Context;

import com.example.greendaostudy.dataobject.DaoMaster;
import com.example.greendaostudy.dataobject.DaoSession;

import org.greenrobot.greendao.query.QueryBuilder;

public class DaoManage {

    private static final String TAG = DaoManage.class.getSimpleName();
    private static final String DB_NAME = "greendaotest";
    private Context context;

    //多线程中要被共享的使用volatile关键字修饰
    private volatile static DaoManage manage;

    private static DaoMaster sDaoMaster;
    private static DaoMaster.DevOpenHelper sHelper;
    private static DaoSession sDaoSession;

    /**
     * 单例模式获得操作数据库对象
     * @return
     */
    public static DaoManage getInstance(){
        if (manage == null)
            manage  = new DaoManage();

        return manage;
    }

    public void init(Context context){
        this.context = context;
    }

    /**
     * 判断是否有存在数据库，如果没有则创建
     * @return
     */
    public DaoMaster getDaoMaster(){
        if(sDaoMaster == null) {
            sHelper = new DaoMaster.DevOpenHelper(context, DB_NAME, null);
            sDaoMaster = new DaoMaster(sHelper.getWritableDatabase());
        }

        return sDaoMaster;
    }

    /**
     * 完成对数据库的添加、删除、修改、查询操作，仅仅是一个接口
     * @return
     */
    public DaoSession getDaoSession(){
        if(sDaoSession == null){
            if(sDaoMaster == null){
                sDaoMaster = getDaoMaster();
            }
            sDaoSession = sDaoMaster.newSession();
        }

        return sDaoSession;
    }

    /**
     * 打开输出日志，默认关闭
     */
    public void setDebug(){
        QueryBuilder.LOG_SQL = true;
        QueryBuilder.LOG_VALUES = true;
    }

    /**
     * 关闭所有的操作，数据库开启后，使用完毕要关闭
     */
    public void closeConnection(){
        closeHelper();
        closeDaoSession();
    }

    public void closeHelper(){
        if(sHelper != null){
            sHelper.close();
            sHelper = null;
        }
    }

    public void closeDaoSession(){
        if(sDaoSession != null){
            sDaoSession.clear();
            sDaoSession = null;
        }
    }
}
