package strategy;

import workTP.WorkTP;
import workTP.WorkType;

public interface JobTypeStrategy
{
    void executeJob(WorkTP aWorkTP);

    Boolean isMyJob(WorkType aWorkType);
}
