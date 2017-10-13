package restructure.com.restructureapp.api;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import restructure.com.restructureapp.util.JsonParseUtil;
import retrofit2.Converter;

/**
 * Created by rankaifeng on 2017/10/4.
 */

public class JsonRequestBodyConverter<T> implements Converter<T, RequestBody> {
    private static final MediaType MEDIA_TYPE = MediaType.parse("application/json;charset=UTF-8");

    @Override
    public RequestBody convert(T value) throws IOException {
        Gson gson = new Gson();
        Object jsonStr = JsonParseUtil.parseJsonStr_(value);
        String s = gson.toJson(jsonStr);
        return RequestBody.create(MEDIA_TYPE, s);
    }
}
