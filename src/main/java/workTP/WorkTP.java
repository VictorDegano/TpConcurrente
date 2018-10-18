package workTP;

import concurrTP.Worker;

public class WorkTP {

    public WorkTP(Worker w){ worker = w; }
    public Worker worker;

    /*[----]*/
    private WorkType workType;
    private double[] vector;

    private double value;

    // TODO: 17/10/2018 Puede ponerse la posicion en la que se encuentra en el buffer para saber en que posicion guardarla en le caso de los mensajes de mapeo 
    private int position;

    // TODO: 18/10/2018 Se puede poner que posea el resultado del trabajo.
    private double[] resultVector;

    private double resultValue;

    public WorkTP(WorkType aWorkType, double[] aVector, int position)
    {
        this.workType       = aWorkType;
        this.vector         = aVector;
        this.position       = position;
        this.resultVector   = new double[aVector.length];
    }

    public int workSize() { return this.vector.length;}

    public WorkType getWorkType() { return workType;    }
    public void setWorkType(WorkType workType) {    this.workType = workType;   }

    public double[] getVector() {   return vector;  }
    public void setVector(double[] vector) {    this.vector = vector;   }

    public double getValue() {  return value;   }
    public void setValue(double value) {    this.value = value; }

    public double[] getResultVector() { return resultVector;    }
    public void setResultVector(double[] resultVector) {    this.resultVector = resultVector;   }

    public int getPosition() {  return position;    }
    public void setPosition(int position) { this.position = position;   }

    public double getResultValue() {    return resultValue; }
    public void setResultValue(double resultValue) {    this.resultValue = resultValue; }
}
