package concurrTP.monitor;

/**Monitor para sincornizar la finalizacion del trabajo de todos los workers*/
public class FinishedJobMonitor
{
    private int activeWorkers   = 0;
    private boolean jobFinished = false;
    private int worksToDo       = 0;

    public FinishedJobMonitor(){}

    public synchronized void workerWorking()
    {
        this.activeWorkers++;
    }


    /**Cada worker avisara que termino y restara en 1 el contador*/
    public synchronized void workCompleted()
    {
        this.activeWorkers--;
        this.worksToDo--;
        if (this.activeWorkers == 0 && this.worksToDo == 0) {
            this.jobFinished = true;
            notifyAll();
        }
    }

    /**Metodo para que el ThreadPool espere a que sus workers terminen el trabajo*/
    public synchronized void requestCompleted()
    {
        while (! this.jobFinished)
        {
            try { wait(); }
            catch (InterruptedException e) {}
        }
        this.jobFinished= false;
        this.worksToDo  = 0;
    }

    public void worksToDo(int i)
    {
        this.worksToDo  = i;
    }
}
