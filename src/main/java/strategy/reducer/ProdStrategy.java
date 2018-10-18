package strategy.reducer;

import workTP.WorkTP;
import workTP.WorkType;
import strategy.JobTypeStrategy;

public class ProdStrategy implements JobTypeStrategy
{
    @Override
    public Object executeJob(WorkTP aWorkTP) {
        return null;
    }

    @Override
    public Boolean isMyJob(WorkType aWorkType)
    {   return aWorkType == WorkType.PROD;   }
}