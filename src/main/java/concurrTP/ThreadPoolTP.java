package concurrTP;

import concurrTP.buffer.Buffer;
import concurrTP.buffer.ResultBufferType;
import concurrTP.monitor.FinishedJobMonitor;
import java.util.ArrayList;
import java.util.List;

public class ThreadPoolTP {

    private final int threads;
    private final int load;
    private final List<Worker> workers = new ArrayList<>();
    private FinishedJobMonitor finishedJobMonitor;

    public ThreadPoolTP(int threads, int load)
    {
        this.threads            = threads;
        this.load               = load;
        this.finishedJobMonitor = new FinishedJobMonitor();
    }

    public void fillPool(double[] elements, Buffer buffer, ResultBufferType resultBuffer) {
        if (workers.size()<threads) {
            int workersNeeded   = Math.min(elements.length, threads);
            for (int i = 0; i < workersNeeded; i++) {
                Worker w = new Worker(buffer, resultBuffer, this.finishedJobMonitor);
                workers.add(w);
                w.start();
            }
        }
    }

    public void jobFinished()
    {   this.finishedJobMonitor.requestCompleted(); }

    public int getThreads() {   return threads; }

    public int getLoad() {  return load;    }

    public void setNewWorks(int i)
    {   this.finishedJobMonitor.worksToDo(i);  }
}
