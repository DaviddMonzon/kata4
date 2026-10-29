package software.ulpgc.katas.application.usecases;

import software.ulpgc.katas.application.UseCase;
import software.ulpgc.katas.application.domain.FibonacciSeries;
import software.ulpgc.katas.application.ports.SeriesSerializer;

public class FibonacciCalculationUseCase implements UseCase {
    private final SeriesSerializer serializer;

    public FibonacciCalculationUseCase(SeriesSerializer serializer) {
        this.serializer = serializer;
    }

    @Override
    public String execute(String value) {
        return serializer.serialize(FibonacciSeries.calculate(deserialize(value)));
    }

    private int deserialize(String value) {
        return Integer.parseInt(value);
    }
}
