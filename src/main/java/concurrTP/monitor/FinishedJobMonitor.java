package concurrTP.monitor;

/**Monitor para sincornizar la finalizacion del trabajo de todos los workers*/
public class FinishedJobMonitor
{
    private boolean workerNotify= false;
    private int inactiveWorkers = 0;
    private int activeWorkers;

    public FinishedJobMonitor(int workers)
    {   this.activeWorkers= workers;    }

    /**Cada worker avisara que termino y restara en 1 el contador*/
    public synchronized void workCompleted()
    {
        while (this.workerNotify)
        {
            try { wait(); }
            catch (InterruptedException e) {}
        }
        this.workerNotify=true;
        this.inactiveWorkers++;
        this.workerNotify=false;
        notifyAll();
    }

    /**Metodo para que el ThreadPool espere a que sus workers terminen el trabajo*/
    public synchronized void requestCompleted()
    {
        while (this.inactiveWorkers != this.activeWorkers)
        {
            try { wait(); }
            catch (InterruptedException e) {}
        }
        this.inactiveWorkers= 0;
    }
}
