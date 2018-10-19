package strategy.mapper;

import workTP.WorkTP;
import workTP.WorkType;
import strategy.JobTypeStrategy;

public class AbsStrategy implements JobTypeStrategy
{
    @Override
    public void executeJob(WorkTP aWorkTP) {
        double[] elements       = aWorkTP.getVector();
        double[] assignVector   = aWorkTP.getHelperVector();
        int position = aWorkTP.getPosition();

        for (int i = 0; i < aWorkTP.workSize(); ++i)
        {
            elements[i] = Math.abs(elements[i]);
        }
        aWorkTP.setResultVector(elements);
    }

    @Override
    public Boolean isMyJob(WorkType aWorkType)
    {   return aWorkType == WorkType.ABS;   }
}