package strategy.mapper;

import strategy.MapStrategy;
import workTP.WorkType;

public class AbsStrategy extends MapStrategy {
    @Override
    protected void doOperation(int index) {
        this.elements[index] = Math.abs(elements[index]);
    }

    @Override
    public Boolean isMyJob(WorkType aWorkType)
    {   return aWorkType == WorkType.ABS;   }
}