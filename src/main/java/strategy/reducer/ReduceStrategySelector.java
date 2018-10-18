package strategy.reducer;

import strategy.AbstractMapReducSelector;
import java.util.Arrays;

public class ReduceStrategySelector extends AbstractMapReducSelector
{
    public ReduceStrategySelector()
    {   super(Arrays.asList(new SumStrategy(), new MeanStrategy(), new ProdStrategy(), new NormStrategy(), new MaxStrategy())); }
}
