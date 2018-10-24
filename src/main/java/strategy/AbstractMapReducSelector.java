package strategy;

import workTP.WorkTP;
import workTP.WorkType;

import java.util.List;

public abstract class AbstractMapReducSelector
{
    private List<Strategy> mapStrategies;

    public AbstractMapReducSelector(List<Strategy> mapStrategies)
    {   this.mapStrategies = mapStrategies; }

    public void resolveJobTypeAndExecute(WorkTP aWorkTP)
    {   this.selectStrategy(aWorkTP.getWorkType()).executeJob(aWorkTP);  }

    private Strategy selectStrategy(WorkType workType)
    {   return this.mapStrategies.stream()
                                 .filter((rs) -> { return rs.isMyJob(workType);})
                                 .findFirst()
                                 .get();    }
}
