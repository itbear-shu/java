package First;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolFactory_ implements ThreadFactory {
    private final AtomicInteger threadIdx = new AtomicInteger(0);

    private final String threadNamePrefix;

    public ThreadPoolFactory_(String Prefix) {
        threadNamePrefix = Prefix;
    }

    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setName(threadNamePrefix + "-xxljob-" + threadIdx.getAndIncrement());
        return thread;
    }
}
