package software.ulpgc.katas.infraestructure.adapters.endpoints;

import io.javalin.http.Context;
import software.ulpgc.katas.application.UseCase;
import software.ulpgc.katas.infraestructure.adapters.EndPoint;

public class FibonacciEndPoint implements EndPoint {
    private final UseCase useCase;
    private final Context context;

    public FibonacciEndPoint(UseCase useCase, Context context) {
        this.useCase = useCase;
        this.context = context;
    }

    public static EndPoint use(UseCase useCase, Context context) {
        return new FibonacciEndPoint(useCase, context);
    }

    @Override
    public void execute() {
        context.result(useCase.execute(context.queryParam("n")));
    }
}
