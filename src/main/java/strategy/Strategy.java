package strategy;

import workTP.WorkTP;
import workTP.WorkType;

public abstract class Strategy {
    protected double[] elements;
    protected double[] helperVector;
    protected double[] maskVector;
    protected int position;
    protected double value;
    protected double result;
    protected WorkTP work;
    public final void executeJob(WorkTP aWorkTP) {
        this.elements = aWorkTP.getVector();
        this.helperVector = aWorkTP.getHelperVector();
        this.position = aWorkTP.getPosition();
        this.maskVector = aWorkTP.getMaskVector();
        this.value = aWorkTP.getValue();
        this.result = 0;
        this.work = aWorkTP;

        for (int i = 0; i < aWorkTP.workSize(); ++i)
        {
            this.doOperation(i);
        }
        this.saveResult();
    }

    abstract protected void saveResult();

    abstract protected void doOperation(int index);

    abstract public Boolean isMyJob(WorkType aWorkType);
}
