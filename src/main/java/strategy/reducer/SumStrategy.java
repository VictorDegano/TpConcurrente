package strategy.reducer;

import workTP.WorkTP;
import workTP.WorkType;
import strategy.JobTypeStrategy;

public class SumStrategy implements JobTypeStrategy
{
    @Override
    public void executeJob(WorkTP aWorkTP)
    {
        double result = 0;
        for (int i = 0; i < aWorkTP.workSize(); ++i)
            result += aWorkTP.getVector()[i];

        aWorkTP.setResultValue(result);
    }

    @Override
    public Boolean isMyJob(WorkType aWorkType)
    {   return aWorkType == WorkType.SUM;   }
}
