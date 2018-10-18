package concurrTP.monitor;

/**Monitor para sincornizar la finalizacion del trabajo de todos los workers*/
public class FinishedJobMonitor
{
    private int inactiveWorkers = 0;
    private int activeWorkers;

    public FinishedJobMonitor(int workers)
    {   this.activeWorkers= workers;    }

    /**Cada worker avisara que termino y restara en 1 el contador*/
    public synchronized void workCompleted()
    {
        this.inactiveWorkers++;
        if (this.inactiveWorkers == this.activeWorkers)
            notify();
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
