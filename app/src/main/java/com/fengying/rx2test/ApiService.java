package com.fengying.rx2test;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by huangjie on 2017/4/6.
 */

public interface ApiService {
    @GET("GetJSON")
    Observable<List<CourseModel>> rxCourse(@Query("CommandID")int commandID, @Query("UserType")int userType, @Query("Session_Key")String session_Key);

    @GET("GetJSON")
    Call<List<CourseModel>> callCourse(@Query("CommandID")int commandID, @Query("UserType")int userType, @Query("Session_Key")String session_Key);
}
