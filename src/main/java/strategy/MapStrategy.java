package strategy;

public abstract class MapStrategy extends Strategy {
    @Override
    protected void saveResult() {
        work.setResultVector(this.elements);
    }
}
