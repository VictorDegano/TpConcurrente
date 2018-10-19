package strategy.mapper;

import workTP.WorkTP;
import workTP.WorkType;
import strategy.JobTypeStrategy;

public class AssignMaskStrategy implements JobTypeStrategy
{
    @Override
    public void executeJob(WorkTP aWorkTP) {
        double[] elements       = aWorkTP.getVector();
        double[] assignVector   = aWorkTP.getHelperVector();
        double[] maskVector   = aWorkTP.getMaskVector();
        int position = aWorkTP.getPosition();

        for (int i = 0; i < aWorkTP.workSize(); ++i)
        {
            if (maskVector[position + i] > 0)
                elements[i] = assignVector[position + i];
        }
        aWorkTP.setResultVector(elements);
    }

    @Override
    public Boolean isMyJob(WorkType aWorkType)
    {   return aWorkType == WorkType.ASSIGNMASK;   }
}
