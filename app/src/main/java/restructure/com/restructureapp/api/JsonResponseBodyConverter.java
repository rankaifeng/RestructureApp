package restructure.com.restructureapp.api;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.ResponseBody;
import restructure.com.restructureapp.util.JsonParseUtil;
import retrofit2.Converter;

/**
 * Created by rankaifeng on 2017/10/4.
 */

public class JsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private Class classType;

    JsonResponseBodyConverter(Class classType) {
        this.classType = classType;
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
}
