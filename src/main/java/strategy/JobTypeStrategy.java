package strategy;

import workTP.WorkTP;
import workTP.WorkType;

public interface JobTypeStrategy
{
    Object executeJob(WorkTP aWorkTP);

    Boolean isMyJob(WorkType aWorkType);
}
