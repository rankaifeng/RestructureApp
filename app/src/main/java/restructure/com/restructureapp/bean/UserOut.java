package restructure.com.restructureapp.bean;

import java.util.ArrayList;

/**
 * 用户输出
 * Created by Ellrien on 2015/11/1.
 */
public class UserOut {
    private String accessToken;//令牌
    private ArrayList<EmpInfo> empList;//多账号列表
    private String organizationCode;//承运商代码
    private String organizationName;//承运商名称
    private int organizationType;//承运商类型
    private int role;//角色
    private String userCode;//登录手机号码
    private String userName;//用户名称
    private String empCode;//用户账号

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public ArrayList<EmpInfo> getEmpList() {
        return empList;
    }

    public void setEmpList(ArrayList<EmpInfo> empList) {
        this.empList = empList;
    }

    public String getOrganizationCode() {
        return organizationCode;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public int getOrganizationType() {
        return organizationType;
    }

    public void setOrganizationType(int organizationType) {
        this.organizationType = organizationType;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmpCode() {
        return empCode;
    }

    public void setEmpCode(String empCode) {
        this.empCode = empCode;
    }
}
