package concurrTP;

import concurrTP.buffer.Buffer;
import concurrTP.buffer.ResultBufferType;
import concurrTP.monitor.FinishedJobMonitor;
import strategy.MapReducStrategy;
import workTP.WorkTP;

public class Worker extends Thread
{
    private Buffer buffer;                          //Buffer para conseguir trabajo
    private ResultBufferType resultBuffer;          //Buffer para dejar el trabajo
    private FinishedJobMonitor finishedJobMonitor;  //Monitor para avisar que se termino el trabajo
    private MapReducStrategy mapReducStrategy;

    public Worker(Buffer buffer, ResultBufferType resultBuffer, FinishedJobMonitor finishedJobMonitor)
    {
        this.buffer             = buffer;
        this.resultBuffer       = resultBuffer;
        this.finishedJobMonitor = finishedJobMonitor;
        this.mapReducStrategy   = new MapReducStrategy();
    }

    @Override
    public void run() {
        while (true)
        {
            WorkTP workToDo = buffer.pop();         //Toma Trabajo
            this.finishedJobMonitor.workerWorking();
            this.mapReducStrategy.resolveJobTypeAndExecute(workToDo);  //Discrimina que tipo de trabajo es y lo resuelve
            this.resultBuffer.add(workToDo);       //Guarda el trabajo resuelto
            this.finishedJobMonitor.workCompleted();
        }
    }
}
