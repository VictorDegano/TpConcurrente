package strategy.reducer;

import strategy.ReduceStrategy;
import workTP.WorkType;

public class MeanStrategy extends ReduceStrategy
{
    @Override
    protected void doOperation(int index) {

    }

    @Override
    public Boolean isMyJob(WorkType aWorkType)
    {   return aWorkType == WorkType.MEAN;   }
}