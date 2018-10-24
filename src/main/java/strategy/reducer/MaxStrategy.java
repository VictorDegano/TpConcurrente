package strategy.reducer;

import strategy.ReduceStrategy;
import workTP.WorkType;

public class MaxStrategy extends ReduceStrategy
{
    @Override
    protected void doOperation(int index) {
        result = Math.max(work.getVector()[index], result);
    }

    @Override
    public Boolean isMyJob(WorkType aWorkType)
    {   return aWorkType == WorkType.MAX;   }
}
