package strategy.reducer;

import strategy.ReduceStrategy;
import workTP.WorkType;

public class SumStrategy extends ReduceStrategy
{
    @Override
    protected void doOperation(int index) {
        result += work.getVector()[index];
    }

    @Override
    public Boolean isMyJob(WorkType aWorkType)
    {   return aWorkType == WorkType.SUM;   }
}
