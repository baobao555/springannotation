package com.baobao.springannotation.springmvcannotation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author baobao
 * @create 2020-02-13 15:32
 * @description
 */
@Controller
public class AsyncController {
    private static class DeferredResultQueue{
        private static ConcurrentLinkedQueue<DeferredResult<String>> deferredResultQueue = new ConcurrentLinkedQueue<>();

        public static void save(DeferredResult<String> deferredResult){
            deferredResultQueue.offer(deferredResult);
        }

        public static DeferredResult<String> get(){
            return deferredResultQueue.poll();
        }
    }

    @ResponseBody
    @RequestMapping("/createOrderMain")
    public DeferredResult<String> createOrderMain(){
        //创建保存结果的临时容器,参数1：超时时间 参数2：超时后的返回结果
        DeferredResult<String> deferredResult = new DeferredResult<>(5000L, "failed to create order");
        //将临时容器保存到消息队列
        DeferredResultQueue.save(deferredResult);
        return deferredResult;
    }

    @ResponseBody
    @RequestMapping("/createOrderWorker")
    public String createOrderWorker(){
        //从消息队列中获取临时容器
        DeferredResult<String> deferredResult = DeferredResultQueue.get();
        //往临时容器中保存处理结果的数据
        deferredResult.setResult("order");
        return "success" + " order";
    }



    @ResponseBody
    @RequestMapping("/asyncCallable")
    public Callable<String> asyncCallable(){
        System.out.println("主线程开始："+Thread.currentThread()+"==>"+System.currentTimeMillis());
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("工作线程开始："+Thread.currentThread()+"==>"+System.currentTimeMillis());
                TimeUnit.SECONDS.sleep(3);
                System.out.println("工作线程开始："+Thread.currentThread()+"==>"+System.currentTimeMillis());
                return "Callable<String> asyncCallable()";
            }
        };
        System.out.println("主线程结束："+Thread.currentThread()+"==>"+System.currentTimeMillis());
        return callable;
    }
}
