package strategy.mapper;

import strategy.MapStrategy;
import workTP.WorkType;

public class AssignMaskStrategy extends MapStrategy
{
    @Override
    protected void doOperation(int index) {
        if (maskVector[position + index] > 0)
            elements[index] = helperVector[position + index];
    }

    @Override
    public Boolean isMyJob(WorkType aWorkType)
    {   return aWorkType == WorkType.ASSIGNMASK;   }
}
