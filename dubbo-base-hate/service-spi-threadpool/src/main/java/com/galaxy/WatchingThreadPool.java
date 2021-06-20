package com.galaxy;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.threadpool.support.fixed.FixedThreadPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.*;

/**
 * @author lane
 * @date 2021年06月18日 下午3:39
 */
public class WatchingThreadPool extends FixedThreadPool implements Runnable {
    private static final Logger LOGGER = LoggerFactory.getLogger(WatchingThreadPool.class);
    //定义线程使用的阀值
    private static final double ALARM_PERCENT = 0.80;
    private final Map<URL, ThreadPoolExecutor> THREAD_POOL = new ConcurrentHashMap<>();
    public WatchingThreadPool(){
        //每隔三秒打印线程的使用情况
        Executors.newSingleThreadScheduledExecutor().scheduleWithFixedDelay(this,1,3, TimeUnit.SECONDS);

    }
    @Override
    public Executor getExecutor(URL url){
        Executor executor = super.getExecutor(url);
        if (executor instanceof ThreadPoolExecutor){
            THREAD_POOL.put(url, (ThreadPoolExecutor) executor);

        }
        return executor;
    }



    @Override
    public void run() {
        for (Map.Entry<URL,ThreadPoolExecutor> entry:THREAD_POOL.entrySet()){
            final URL url = entry.getKey();
            final ThreadPoolExecutor executor = entry.getValue();
            //计算指标
            int activeCount = executor.getActiveCount();
            int corePoolSize = executor.getCorePoolSize();
            double usedPercent = activeCount/(corePoolSize*1.0);
            LOGGER.info("线程池的状态：activeCount:"+activeCount+"corePoolSize:"+corePoolSize+"usedPercent:"+usedPercent);
            if (usedPercent>ALARM_PERCENT){
                LOGGER.error("超出警戒线："+"host:"+url.getHost()+"ip:"+url.getIp()+"url:"+url);
            }

            LOGGER.info("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            LOGGER.info("线程池的状态:[{}/{}:{}%]",activeCount,corePoolSize,usedPercent*100);
            if (usedPercent>ALARM_PERCENT){
                LOGGER.error("超出警戒线!host:{},ip:{},url:{}",url.getHost(),url.getIp(),url);
            }
        }
    }
}
