package com.zh.seat.config.threadpool;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

@Configuration
@EnableAsync
@Slf4j
public class ThreadConfig {

    @Bean(name = "asyncTaskExecutor")
    public TaskExecutor asyncTaskExecutor() {
        ThreadPoolTaskExecutor executor = new VisibleThreadPool();
        //Runtime.getRuntime().availableProcessors()获取虚拟机的个数
        /*
         * IO密集型任务  = 一般为2*CPU核心数（常出现于线程中：数据库数据交互、文件上传下载、网络数据传输等等）
         * CPU密集型任务 = 一般为CPU核心数+1（常出现于线程中：复杂算法）
         * 混合型任务  = 视机器配置和复杂度自测而定
         * corePoolSize用于指定核心线程数量
         * maximumPoolSize指定最大线程数
         * keepAliveTime和TimeUnit指定线程空闲后的最大存活时间
         * workQueue则是线程池的缓冲队列,还未执行的线程会在队列中等待
         * 监控队列长度，确保队列有界
         * 不当的线程池大小会使得处理速度变慢，稳定性下降，并且导致内存泄露。如果配置的线程过少，则队列会持续变大，消耗过多内存。
         * 而过多的线程又会 由于频繁的上下文切换导致整个系统的速度变缓——殊途而同归。队列的长度至关重要，它必须得是有界的，这样如果线程池不堪重负了它可以暂时拒绝掉新的请求。
         * ExecutorService 默认的实现是一个无界的 LinkedBlockingQueue。
         */
        // 设置核心线程数 executor.setCorePoolSize(100);
        log.info("----------核心线程的大小为----------------");
        log.info(String.valueOf(2*Runtime.getRuntime().availableProcessors()));
        executor.setCorePoolSize(2*Runtime.getRuntime().availableProcessors());
        // 设置最大线程数
        executor.setMaxPoolSize(200);
        // 设置队列容量
        executor.setQueueCapacity(20);
        // 设置线程活跃时间（秒）
        executor.setKeepAliveSeconds(30000);
        // 设置默认线程名称
        executor.setThreadNamePrefix("job-");
//        // 设置拒绝策略
//        executor.setRejectedExecutionHandler((r, executor1) -> {
//            // .....
//        });
        // 使用预定义的异常处理类
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // 当调度器shutdown被调用时等待当前被调度的任务完成
        executor.setWaitForTasksToCompleteOnShutdown(true);
        // 当调度器shutdown被调用时等待当前被调度的任务完成的超时时间
        executor.setAwaitTerminationSeconds(60);

        return executor;
    }
}