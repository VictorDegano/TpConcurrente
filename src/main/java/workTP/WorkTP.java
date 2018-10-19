package workTP;

public class WorkTP {

    private WorkType workType;
    private double[] vector;    // vector inicial

    private double value;
    private int position;
    private double[] resultVector;
    private double resultValue;
    private double[] helperVector;

    public WorkTP(){}

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

    public double[] getHelperVector() { return this.helperVector; }
    public void setHelperVector(double[] otherVector) { this.helperVector = otherVector;    }
}
