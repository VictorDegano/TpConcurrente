package concurrTP;

import concurrTP.buffer.Buffer;
import concurrTP.monitor.FinishedJobMonitor;
import strategy.MapReducStrategy;
import workTP.WorkTP;

public class Worker extends Thread
{
    private Buffer buffer;                          //Monitor para conseguir trabajo
    private Buffer resultBuffer;                    //Monitor para dejar el trabajo
    private FinishedJobMonitor finishedJobMonitor;  //Monitor para avisar que se termino el trabajo
    private MapReducStrategy mapReducStrategy;

    public Worker(Buffer buffer, Buffer resultBuffer, FinishedJobMonitor finishedJobMonitor)
    {
        this.buffer             = buffer;
        this.resultBuffer       = resultBuffer;
        this.finishedJobMonitor = finishedJobMonitor;
        this.mapReducStrategy   = new MapReducStrategy();
    }

    // TODO: 18/10/2018 el while no deberia ser un while true y si hay algo para sacar del buffer lo hace, y ahi quedaria bloqueado
    @Override
    public void run() {
        while (true)
        {
            WorkTP workToDo = buffer.pop();         //Toma Trabajo
            this.mapReducStrategy.resolveJobTypeAndExecute(workToDo);  //Discrimina que tipo de trabajo es y lo resuelve
            this.resultBuffer.push(workToDo);       //Guarda el trabajo resuelto
            this.finishedJobMonitor.workCompleted();//Avisa que termino
        }
    }
}
