package software.ulpgc.katas;

import io.javalin.Javalin;
import io.javalin.config.JavalinConfig;
import software.ulpgc.katas.application.usecases.FibonacciCalculationUseCase;
import software.ulpgc.katas.infraestructure.adapters.JsonSeriesSerializer;
import software.ulpgc.katas.infraestructure.adapters.endpoints.FibonacciEndPoint;
import software.ulpgc.katas.infraestructure.adapters.endpoints.HolaEndPoint;

public class Main {
    static void main() {
        Javalin javalin = Javalin.create(c->create(c))
                .start(8081);
    }

    private static void create(JavalinConfig config) {
        config.routes.get("/hola/{name}", context-> HolaEndPoint.use(context).execute());
        config.routes.get("/fibonacci", context-> FibonacciEndPoint.use(new FibonacciCalculationUseCase(new JsonSeriesSerializer()), context).execute());
    }
}
