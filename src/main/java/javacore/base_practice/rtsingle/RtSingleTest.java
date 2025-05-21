package javacore.base_practice.rtsingle;

import com.alibaba.fastjson.JSON;

import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleObserver;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RtSingleTest {

    public static void main(String[] args) throws InterruptedException {
        success();
        System.out.println("---------------------------------------------------");
        failed();
        System.out.println("---------------------------------------------------");
        blockingGet();
    }

    /**
     * 只有当实现 onSuccess 的时候, Single.create 里面的 subscribe 才会执行
     */
    private static void success() throws InterruptedException {
        Student student = new Student();
        Bag bag = new Bag();
        bag.setName("bag1");
        student.setBag(bag);
        System.out.println("success step1:" + JSON.toJSONString(student));

        Single<Student> single = Single.create(new SingleOnSubscribe<Student>() {
            @Override
            public void subscribe(@NonNull SingleEmitter<Student> emitter) throws Exception {
                Bag bag = new Bag();
                bag.setName("bag2");
                student.setBag(bag);
                System.out.println("success step2:" + JSON.toJSONString(student));
                emitter.onSuccess(student);
            }
        });
        System.out.println("success step3:" + JSON.toJSONString(student));
        Thread.sleep(1000);

        // 只有当实现 subscribe 的时候, Single.create 里面的 onSuccess 才会执行
        single.subscribe(new SingleObserver<Student>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onSuccess(@NonNull Student student) {
                System.out.println("success step4:" + JSON.toJSONString(student));
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }
        });
        System.out.println("success step5:" + JSON.toJSONString(student));
    }

    /**
     * 只有当实现 onSuccess 的时候, Single.create 里面的 subscribe 才会执行
     */
    private static void failed() throws InterruptedException {
        Student student = new Student();
        Bag bag = new Bag();
        bag.setName("bag1");
        student.setBag(bag);
        System.out.println("failed step1:" + JSON.toJSONString(student));

        Single<Student> single = Single.create(new SingleOnSubscribe<Student>() {
            @Override
            public void subscribe(@NonNull SingleEmitter<Student> emitter) throws Exception {
                Bag bag = new Bag();
                bag.setName("bag2");
                student.setBag(bag);
                System.out.println("failed step2:" + JSON.toJSONString(student));
                emitter.onSuccess(student);
            }
        });
        System.out.println("failed step3:" + JSON.toJSONString(student));
    }


    /**
     * 只有当实现 onSuccess 的时候, Single.create 里面的 subscribe 才会执行
     */
    private static void blockingGet() throws InterruptedException {
        Student student = new Student();
        Bag bag = new Bag();
        bag.setName("bag1");
        student.setBag(bag);
        System.out.println("failed step1:" + JSON.toJSONString(student));

        Single<Student> single = Single.create(new SingleOnSubscribe<Student>() {
            @Override
            public void subscribe(@NonNull SingleEmitter<Student> emitter) throws Exception {
                Bag bag = new Bag();
                bag.setName("bag2");
                student.setBag(bag);
                System.out.println("failed step2:" + JSON.toJSONString(student));
                Thread.sleep(5000);
                emitter.onSuccess(student);
            }
        });
        System.out.println("failed step3:" + JSON.toJSONString(student));
        // 阻塞式获取
        Student data = single.blockingGet();
        System.out.println("failed step4(blockingGet):" + JSON.toJSONString(data));

    }
}