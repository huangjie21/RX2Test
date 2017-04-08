package com.fengying.rx2test;

import com.fengying.rx2test.gen.DaoMaster;
import com.fengying.rx2test.gen.DaoSession;
import com.fengying.rx2test.gen.MySQLiteOpenHelper;

/**
 * Created by huangjie on 2017/4/7.
 */

public class GreenDaoManager {
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;
    private static GreenDaoManager mInstance; //单例

    private GreenDaoManager(){
        if (mInstance == null) {
//            DaoMaster.OpenHelper openHelper = new DaoMaster.OpenHelper(MyApp.getContext(), "rx2.db", null);
            //DaoMaster.OpenHelper openHelper = new DaoMaster.OpenHelper(MyApp.getContext(), "rx2.db", null);
            MySQLiteOpenHelper helper = new MySQLiteOpenHelper(MyApp.getContext(), "rx2.db", null);
            mDaoMaster = new DaoMaster(helper.getWritableDatabase());
            mDaoSession = mDaoMaster.newSession();
        }
    }

    public static GreenDaoManager getInstance() {
        if (mInstance == null) {
            synchronized (GreenDaoManager.class) {//保证异步处理安全操作

                if (mInstance == null) {
                    mInstance = new GreenDaoManager();
                }
            }
        }
        return mInstance;
    }

    public DaoMaster getMaster() {
        return mDaoMaster;
    }
    public DaoSession getSession() {
        return mDaoSession;
    }
    public DaoSession getNewSession() {
        mDaoSession = mDaoMaster.newSession();
        return mDaoSession;
    }
}
