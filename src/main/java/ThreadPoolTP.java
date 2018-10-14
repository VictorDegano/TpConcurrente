import com.sun.corba.se.spi.orbutil.threadpool.Work;

import java.util.ArrayList;
import java.util.List;

public class ThreadPoolTP {

    private final int threads;
    private final int load;
    private final List<Worker> workers = new ArrayList<>();

    public ThreadPoolTP(int threads, int load) {
        this.threads = threads;
        this.load = load;
    }

    public void fillPool(double[] elements) {
        if (workers.size()<threads) {
            int workersNeeded = Math.min(elements.length, threads);
            Buffer buffer = new Buffer(elements.length / workersNeeded);
            for (int i = 0; i < workersNeeded; i++) {
                Worker w = new Worker(buffer);
                workers.add(w);
                w.start();
            }
        }
    }
}
