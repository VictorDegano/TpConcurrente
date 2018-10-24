package strategy.mapper;

import strategy.MapStrategy;
import workTP.WorkType;

public class MulStrategy extends MapStrategy
{
    @Override
    protected void doOperation(int index) {
        elements[index] *= helperVector[position + index];
    }

    @Override
    public Boolean isMyJob(WorkType aWorkType)
    {   return aWorkType == WorkType.MUL;   }
}