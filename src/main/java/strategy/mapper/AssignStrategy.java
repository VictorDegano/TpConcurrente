package strategy.mapper;

import workTP.WorkTP;
import workTP.WorkType;
import strategy.JobTypeStrategy;

public class AssignStrategy implements JobTypeStrategy
{
    @Override
    public void executeJob(WorkTP aWorkTP) {

    }

    @Override
    public Boolean isMyJob(WorkType aWorkType)
    {   return aWorkType == WorkType.ASSIGN;   }
}