package strategy.mapper;

import strategy.MapStrategy;
import workTP.WorkType;

public class SetStrategy extends MapStrategy
{
    @Override
    protected void doOperation(int index) {
        elements[index] = value;
    }

    @Override
    public Boolean isMyJob(WorkType aWorkType)
    {   return aWorkType == WorkType.SET;   }
}