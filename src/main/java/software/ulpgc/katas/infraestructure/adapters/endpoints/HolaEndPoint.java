package software.ulpgc.katas.infraestructure.adapters.endpoints;

import io.javalin.http.Context;
import io.javalin.router.Endpoint;
import software.ulpgc.katas.infraestructure.adapters.EndPoint;

public class HolaEndPoint implements EndPoint {
    private final Context context;

    public HolaEndPoint(Context context) {
        this.context = context;
    }

    public static EndPoint use(Context context) {
        return new HolaEndPoint(context);
    }

    @Override
    public void execute() {
        context.result("Hola " + context.pathParam("name") + "!!!");
    }
}
