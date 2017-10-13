package restructure.com.restructureapp.api;

/**
 * Created by rankaifeng on 2017/10/12.
 */

public class ApiFactory {
    private static ApiFactory instanse;

    public static ApiFactory getInstanse() {
        if (instanse == null) {
            instanse = new ApiFactory();
        }
        return instanse;
    }

    public  CarAppApi getCarAppApi(Class type) {
        return RetrofitSP.getInstanse().getRetrofit(type).create(CarAppApi.class);
    }
}
