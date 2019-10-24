package bupt.fnl.dht.config.ThreadConfiguration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

@Configuration
@EnableAsync
public class ThreadPoolConfiguration {
    @Value("${webtask.coresize}")
    private int coreSize;
    @Value("${webtask.maxsize}")
    private  int maxSize;
    @Value("${webtask.queuecapacity}")
    private int queueCapacity;
    @Value("${webtask.alivetime}")
    private int aliveTime;
    @Value("${webtask.poolname}")
    private String poolName;
    @Value("${webtask.waitforshutdown}")
    private boolean waitForShutdown;

    @Bean
    public TaskExecutor webTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(coreSize);// 设置核心线程数
        executor.setMaxPoolSize(maxSize);// 设置最大线程数
        executor.setQueueCapacity(queueCapacity);// 设置队列容量
        executor.setKeepAliveSeconds(aliveTime);// 设置线程活跃时间（秒）
        executor.setThreadNamePrefix(poolName);// 设置默认线程名称
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy()); // 设置拒绝策略
        executor.setWaitForTasksToCompleteOnShutdown(waitForShutdown);// 等待所有任务结束后再关闭线程池
        return executor;
    }
}
