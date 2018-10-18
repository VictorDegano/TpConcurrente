package strategy;

import workTP.WorkTP;
import workTP.WorkType;

import java.util.List;

public abstract class AbstractMapReducSelector
{
    private List<JobTypeStrategy> mapStrategies;

    public AbstractMapReducSelector(List<JobTypeStrategy> mapStrategies)
    {   this.mapStrategies = mapStrategies; }

    // TODO: 17/10/2018 Resolver que clase devuelve
    public Object resolveJobTypeAndExecute(WorkTP aWorkTP)
    {   return this.selectStrategy(aWorkTP.getWorkType()).executeJob(aWorkTP);  }

    private JobTypeStrategy selectStrategy(WorkType workType)
    {   return this.mapStrategies.stream()
                                 .filter((rs) -> { return rs.isMyJob(workType);})
                                 .findFirst()
                                 .get();    }
}
