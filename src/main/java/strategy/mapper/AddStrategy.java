package strategy.mapper;

import strategy.MapStrategy;
import workTP.WorkType;

public class AddStrategy extends MapStrategy
{
    @Override
    protected void doOperation(int index) {
        this.elements[index] += this.helperVector[position + index];
    }

    @Override
    public Boolean isMyJob(WorkType aWorkType)
    {   return aWorkType == WorkType.ADD;   }
}