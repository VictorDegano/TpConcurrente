import com.sun.corba.se.spi.orbutil.threadpool.Work;

import java.util.ArrayList;
import java.util.List;

public class ThreadPoolTP {

    private final int threads;
    private final int load;

    public ThreadPoolTP(int threads, int load) {
        this.threads = threads;
        this.load = load;
    }

    public double[] set(List<Double> elements, double d) {

        int elementNbr = elements.size() / threads;
        List<List<Double>> works = new ArrayList<List<Double>>();
        for (int i = 0; i < threads; i++) {
            works.add(elements.subList(i, elementNbr));
        }
        Buffer buffer = new Buffer(works.size());
        List<Worker> workers = new ArrayList<Worker>();
        for (int i = 0; i < threads; i++) {
            Worker w = new Worker(buffer);
            workers.add(w);
            w.start();
        }
    }
}
