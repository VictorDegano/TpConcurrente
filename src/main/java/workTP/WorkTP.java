package workTP;

import concurrTP.Worker;

public class WorkTP {
    public WorkTP(Worker w){ worker = w; }
    public Worker worker;

    /*[----]*/
    private WorkType workType;
    private double[] vector;
    // TODO: 17/10/2018 Puede ponerse la posicion en la que se encuentra en el buffer para saber en que posicion guardarla en le caso de los mensajes de mapeo 
    
    public WorkTP(WorkType aWorkType, double[] aVector)
    {
        this.workType   = aWorkType;
        this.vector     = aVector;
    }

    public WorkType getWorkType() { return workType;    }
    public void setWorkType(WorkType workType) {    this.workType = workType;   }

    public double[] getVector() {   return vector;  }
    public void setVector(double[] vector) {    this.vector = vector;   }

    public int workSize() { return this.vector.length;}
}
