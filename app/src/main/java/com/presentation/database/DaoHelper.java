package com.presentation.database;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.presentation.entity.DaoMaster;
import com.presentation.entity.DaoSession;
import com.presentation.entity.UserInfo;
import com.presentation.entity.UserInfoDao;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class DaoHelper {

    private static final String DAO_USER = "user.db";

    private final DaoMaster.DevOpenHelper mDaoOpenHelper;
    private final DaoMaster mDaoMaster;
    private final DaoSession mDaoSession;
    private final UserInfoDao mUserInfoDao;

    @Inject
    public DaoHelper(Application application) {
        mDaoOpenHelper = new DaoMaster.DevOpenHelper(application, DAO_USER);
        mDaoMaster = new DaoMaster(getWritableDatabase());
        mDaoSession = mDaoMaster.newSession();

        mUserInfoDao = mDaoSession.getUserInfoDao();
    }

    private SQLiteDatabase getReadableDatabase() {
        return mDaoOpenHelper.getReadableDatabase();
    }

    private SQLiteDatabase getWritableDatabase() {
        return mDaoOpenHelper.getWritableDatabase();
    }

    public void insertOrReplace(UserInfo UserInfo) {
        mUserInfoDao.insertOrReplace(UserInfo);
    }

    public long insert(UserInfo UserInfo) {
        return mUserInfoDao.insert(UserInfo);
    }

    public void update(UserInfo UserInfo) {
        UserInfo mOldUserInfo = mUserInfoDao.queryBuilder().where(UserInfoDao.Properties.Id.eq(UserInfo.getId())).build().unique();//拿到之前的记录
        if (mOldUserInfo != null) {
            mUserInfoDao.update(mOldUserInfo);
        }
    }

    public List<UserInfo> searchByWhere(String wherecluse) {
        List<UserInfo> UserInfos = (List<UserInfo>) mUserInfoDao.queryBuilder().where(UserInfoDao.Properties.UserId.eq(wherecluse)).build().unique();
        return UserInfos;
    }

    public List<UserInfo> searchAll() {
        List<UserInfo> UserInfos = mUserInfoDao.queryBuilder().list();
        return UserInfos;
    }

    public void delete(String wherecluse) {
        mUserInfoDao.queryBuilder().where(UserInfoDao.Properties.UserId.eq(wherecluse)).buildDelete().executeDeleteWithoutDetachingEntities();
    }

}
