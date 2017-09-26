package restructure.com.restructureapp.api;

import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import restructure.com.restructureapp.util.JsonParseUtil;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * Created by rankaifeng on 2017/9/26.
 */

class JsonConverterFactory extends Converter.Factory {
    public Class classType;

    public JsonConverterFactory(Class classType) {
        this.classType = classType;
    }

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {

        JsonResponseBodyConverter json = new JsonResponseBodyConverter<JSONObject>();
        json.setType(classType);
        return json;
    }

    @Override
    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
        return new JsonRequestBodyConverter<JSONObject>();
    }

}

class JsonRequestBodyConverter<T> implements Converter<T, RequestBody> {
    private static final MediaType MEDIA_TYPE = MediaType.parse("application/json;charset=UTF-8");

    @Override
    public RequestBody convert(T value) throws IOException {
        Gson gson = new Gson();
        Object jsonStr = JsonParseUtil.parseJsonStr_(value);
        String s = gson.toJson(jsonStr);
        return RequestBody.create(MEDIA_TYPE, s);
    }
}

/**
 * 返回
 *
 * @param <T>
 */
class JsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private Class classType;

    JsonResponseBodyConverter() {

    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        String response = value.string();
        Gson gson = new Gson();
        try {
            /*获取服务器返回的json*/
            String jsonObj = JsonParseUtil.parseJsonStr(response).toString();
            /*根据传过来的class 把json转成相对应的实体*/
            Object o = gson.fromJson(jsonObj, classType);
            return (T) o;
        } catch (Exception e) {
            return null;
        }
    }

    public void setType(Class type) {
        this.classType = type;
    }
}
