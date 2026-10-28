package software.ulpgc.katas.infraestructure.adapters;

import com.google.gson.Gson;
import software.ulpgc.katas.application.ports.SeriesSerializer;

public class JsonSeriesSerializer implements SeriesSerializer {
    @Override
    public String serializer(int[] series) {
        return new Gson().toJson(series);
    }
}
