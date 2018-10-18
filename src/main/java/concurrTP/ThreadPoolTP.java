package concurrTP;

import concurrTP.buffer.Buffer;
import concurrTP.buffer.ResultBufferMapperType;
import concurrTP.monitor.FinishedJobMonitor;

import java.util.ArrayList;
import java.util.List;

public class ThreadPoolTP {

    private final int threads;
    private final int load;
    private final List<Worker> workers = new ArrayList<>();

    public ThreadPoolTP(int threads, int load)
    {
        this.threads= threads;
        this.load   = load;
    }

    // TODO: 18/10/2018 Falta revisar el metodo, se armo como idea. Convendria separarlo en dos metodos, uno para la carga de threads al pool y otra para la resolucion, asi se puede usar recursion en la resolucion.
    public void fillPool(double[] elements) {
        if (workers.size()<threads) {
            int workersNeeded   = Math.min(elements.length, threads);// TODO: 18/10/2018 falta hacer el calculo de la carga de trabajo
            Buffer buffer       = new Buffer(elements.length / workersNeeded);
            Buffer resultBuffer = new Buffer(elements.length / workersNeeded);
            FinishedJobMonitor finishedJobMonitor   = new FinishedJobMonitor(workersNeeded);
            for (int i = 0; i < workersNeeded; i++) {
                Worker w = new Worker(buffer, resultBuffer, finishedJobMonitor);
                workers.add(w);
                w.start();
            }
        }
    }


}
