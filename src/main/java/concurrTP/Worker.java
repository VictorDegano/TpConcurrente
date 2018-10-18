package concurrTP;

import strategy.MapReducStrategy;
import workTP.WorkTP;

public class Worker extends Thread {
    private Buffer buffer;

    public Worker(Buffer buffer) { this.buffer = buffer; }

    @Override
    public void run() {
        while (buffer.isEmpty()){
            try { wait(); }
            catch (InterruptedException e) {}
        }

        WorkTP workToDo = buffer.pop();
        this.resolveJobTypeAndExecute(workToDo);
        // guardar el trabajo resuelto
        //avisar que termino
    }

    private Object resolveJobTypeAndExecute(WorkTP workToDo)
    {
        return new MapReducStrategy().resolveJobTypeAndExecute(workToDo);

    }
}
