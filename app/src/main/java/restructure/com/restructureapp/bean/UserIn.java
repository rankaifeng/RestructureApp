package restructure.com.restructureapp.bean;

/**
 * 用户传入对象
 * Created by Ellrien on 2015/11/1.
 */
public class UserIn {
    private String usercode;
    private String password;
    private String platId;

    public UserIn(String usercode, String password, String platId) {
        this.usercode = usercode;
        this.password = password;
        this.platId = platId;
    }

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPlatId() {
        return platId;
    }

    public void setPlatId(String platId) {
        this.platId = platId;
    }
}
