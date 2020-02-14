package com.baobao.springannotation.servlet30.servlet;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author baobao
 * @create 2020-02-13 15:14
 * @description
 */
@WebServlet(value = "/async",asyncSupported = true)//开启异步支持asyncSupported = true
public class AsyncServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("主线程开始：" + Thread.currentThread() + " 当前时间戳：" + System.currentTimeMillis());
        //开启异步处理
        AsyncContext asyncContext = req.startAsync();
        //提交异步处理任务
        asyncContext.start(new Runnable() {
            @Override
            public void run() {
                System.out.println("工作线程开始：" + Thread.currentThread() + " 当前时间戳：" + System.currentTimeMillis());
                try {
                    TimeUnit.SECONDS.sleep(3);
                    //异步任务结束
                    asyncContext.complete();
                    //获取异步任务的response输出结果
                    asyncContext.getResponse().getWriter().write("Hello Async");
                    System.out.println("工作线程结束：" + Thread.currentThread() + " 当前时间戳：" + System.currentTimeMillis());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        System.out.println("主线程结束：" + Thread.currentThread() + " 当前时间戳：" + System.currentTimeMillis());
    }
}
