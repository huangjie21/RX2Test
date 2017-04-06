package com.fengying.rx2test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.trello.rxlifecycle2.android.ActivityEvent;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends RxAppCompatActivity {

    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.button)
    Button button;
    @BindView(R.id.button2)
    Button button2;
    @BindView(R.id.button3)
    Button button3;
    @BindView(R.id.button4)
    Button button4;
    Retrofit retrofit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        button.setText("onclick2");
        button2.setText("onViewClicked");
        button3.setText("Retrofit");
        button4.setText("Rxjava+Retrofit");

         retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl("http://webapi.yunsiku.com:8080/Woxiao_WebService/")
                .build();

        subscriber = new Subscriber<String>() {
            @Override
            public void onSubscribe(Subscription s) {
                System.out.println("onSubscribe");
                s.request(Long.MAX_VALUE);
            }

            @Override
            public void onNext(String o) {
                System.out.println(o);
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        };

        flowable = Flowable.create(new FlowableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull FlowableEmitter<String> e) throws Exception {
                e.onNext("rxjava2");
                e.onComplete();
            }
        }, BackpressureStrategy.BUFFER);
    }

    @OnClick(R.id.button)
    public void onclick2() {
        Toast.makeText(MainActivity.this, "xxxx", Toast.LENGTH_LONG).show();

        flowable.subscribe(subscriber);

    }

    private Flowable<String> flowable;
    private Subscriber subscriber;

    @OnClick(R.id.button2)
    public void onViewClicked() {
        Flowable.just("just rxjava2").subscribe(new Consumer<String>() {
            @Override
            public void accept(@NonNull String s) throws Exception {
                System.out.println(s);
            }
        });

        Flowable.just("map")
                .map(new Function<String, String>() {
                    @Override
                    public String apply(String s) throws Exception {
                        return s + " -ittianyu";
                    }
                })
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        System.out.println(s);
                    }
                });
    }

    @OnClick(R.id.button3)
    public void onclick3() {


        ApiService apiService = retrofit.create(ApiService.class);
        Call<List<CourseModel>> call = apiService.callCourse(1, 1, "964bd7d3-0a3a-4bbe-870a-aa22276bbd8b");
        call.enqueue(new Callback<List<CourseModel>>() {
            @Override
            public void onResponse(Call<List<CourseModel>> call, Response<List<CourseModel>> response) {
                for (CourseModel c : response.body()) {
                    System.out.println(c.toString());
                }
            }

            @Override
            public void onFailure(Call<List<CourseModel>> call, Throwable t) {

            }
        });
//        apiService.getCourse(1,1,"964bd7d3-0a3a-4bbe-870a-aa22276bbd8b")
//                .subscribeOn(Schedulers.newThread())

    }
    @OnClick(R.id.button4)
    public void onClick4(){
        ApiService apiService = retrofit.create(ApiService.class);
        apiService.rxCourse(1, 1, "964bd7d3-0a3a-4bbe-870a-aa22276bbd8b")
                .subscribeOn(Schedulers.newThread())//请求在新的线程中执行
                .observeOn(Schedulers.io())         //请求完成后在io线程中执行
                .doOnNext(new Consumer<List<CourseModel>>() {
                    @Override
                    public void accept(@NonNull List<CourseModel> courseModels) throws Exception {
                        for (CourseModel c : courseModels) {
                            System.out.println(c.toString());
                        }
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .compose(this.<List<CourseModel>>bindUntilEvent(ActivityEvent.PAUSE))
                .subscribe(new Observer<List<CourseModel>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<CourseModel> courseModels) {
                        String str="";
                        for (CourseModel c : courseModels) {
//                            System.out.println(c.toString());
                            str+=c.toString()+"\r\n";
                        }
                        textView.setText(str);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        Toast.makeText(MainActivity.this,"请求完成",Toast.LENGTH_LONG).show();
                    }
                });
//                .subscribe(new Consumer<List<CourseModel>>() {
//                    @Override
//                    public void accept(@NonNull List<CourseModel> courseModels) throws Exception {
//                        String str="";
//                        for (CourseModel c : courseModels) {
////                            System.out.println(c.toString());
//                            str+=c.toString()+"\r\n";
//                        }
//                        textView.setText(str);
//                    }
//                });
    }
}
