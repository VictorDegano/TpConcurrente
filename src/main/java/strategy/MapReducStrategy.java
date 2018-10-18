package strategy;

import workTP.WorkTP;
import workTP.WorkType;
import strategy.mapper.MapStrategySelector;
import strategy.reducer.ReduceStrategySelector;

import java.util.Arrays;
import java.util.List;

public class MapReducStrategy
{
    private final MapStrategySelector mapStrategy;
    private final ReduceStrategySelector reducStrategy;

    public MapReducStrategy()
    {
        this.mapStrategy    = new MapStrategySelector();
        this.reducStrategy  = new ReduceStrategySelector();
    }

    // TODO: 17/10/2018 falta resolver la clase que devuelve al terminar la operacion
    public Object resolveJobTypeAndExecute(WorkTP aWorkTP)
    {
        if(this.isAReducerType(aWorkTP.getWorkType()))
        {   return this.reducStrategy.resolveJobTypeAndExecute(aWorkTP);    }
        else
        {   return this.mapStrategy.resolveJobTypeAndExecute(aWorkTP);  }
    }

    private boolean isAReducerType(WorkType workType)
    {
        List<WorkType> reducerType  = Arrays.asList(WorkType.SUM, WorkType.MEAN, WorkType.PROD, WorkType.NORM, WorkType.MAX);
        return reducerType.contains(workType);
    }

}
