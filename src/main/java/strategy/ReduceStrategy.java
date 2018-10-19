package strategy;

public abstract class ReduceStrategy extends Strategy{
    @Override
    protected void saveResult() {
        work.setResultValue(result);
    }
}
