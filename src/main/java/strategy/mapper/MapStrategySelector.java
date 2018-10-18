package strategy.mapper;

import strategy.AbstractMapReducSelector;
import java.util.Arrays;

public class MapStrategySelector extends AbstractMapReducSelector
{
    public MapStrategySelector()
    {   super(Arrays.asList(new SetStrategy(), new AssignStrategy(), new AssignMaskStrategy(), new AddStrategy(), new MulStrategy(), new AbsStrategy()));   }
}