package impl;

/**
 * Created by naritc on 7/6/2017.
 */
public class Divide implements Operation {
    @Override
    public Double calc(Double a, Double b) {
        if (b == 0) throw new IllegalArgumentException();
        return a/b;
    }
}
