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
        this.threads= threads;
        this.load   = load;
        this.finishedJobMonitor = new FinishedJobMonitor();
    }

    // TODO: 18/10/2018 Falta revisar el metodo, se armo como idea. Convendria separarlo en dos metodos, uno para la carga de threads al pool y otra para la resolucion, asi se puede usar recursion en la resolucion.
    public void fillPool(double[] elements, Buffer buffer, ResultBufferType resultBuffer) {
        if (workers.size()<threads) {
            int workersNeeded   = Math.min(elements.length, threads);// TODO: 18/10/2018 falta hacer el calculo de la carga de trabajo
            finishedJobMonitor.setActiveWorkers(workersNeeded);
            for (int i = 0; i < workersNeeded; i++) {
                Worker w = new Worker(buffer, resultBuffer, this.finishedJobMonitor);
                workers.add(w);
                w.start();
            }
        }
    }

    public void updatePool(double[] elements, int calculoDeCarga)
    {   this.finishedJobMonitor.setActiveWorkers(this.workersToWork(elements, calculoDeCarga)); }

    public int workersToWork(double[] elements, int calculoDeCarga)
    {   return (elements.length % threads < calculoDeCarga ) ? 1 : threads; }


    public void jobFinished()
    {   this.finishedJobMonitor.requestCompleted(); }

    public int getThreads() {   return threads; }



}
