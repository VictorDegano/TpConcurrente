package strategy.mapper;

import workTP.WorkTP;
import workTP.WorkType;
import strategy.JobTypeStrategy;

public class SetStrategy implements JobTypeStrategy
{
    @Override
    public void executeJob(WorkTP aWorkTP)
    {
        double[] elements   = aWorkTP.getVector();
        double d            = aWorkTP.getValue();

        for (int i = 0; i < aWorkTP.workSize(); ++i)
        {
            elements[i] = d;
            System.out.print("Set " + d + "en index " + i + "del WorkTP \n");
        }
        aWorkTP.setResultVector(elements);
    }

    @Override
    public Boolean isMyJob(WorkType aWorkType)
    {   return aWorkType == WorkType.SET;   }
}