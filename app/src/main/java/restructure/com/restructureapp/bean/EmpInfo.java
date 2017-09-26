package restructure.com.restructureapp.bean;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by wangrun on 2016/8/24
 */
public class EmpInfo implements Serializable {
    private String compName;//企业名称
    private String empCode;//用户账号
    private String empMobilePhone;//用户手机号
    private ArrayList<String> platList;//站点信息
    private String status;//用户状态  状态00删除10新增15审批不通过20审批通过

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public String getEmpCode() {
        return empCode;
    }

    public void setEmpCode(String empCode) {
        this.empCode = empCode;
    }

    public String getEmpMobilePhone() {
        return empMobilePhone;
    }

    public void setEmpMobilePhone(String empMobilePhone) {
        this.empMobilePhone = empMobilePhone;
    }

    public ArrayList<String> getPlatList() {
        return platList;
    }

    public void setPlatList(ArrayList<String> platList) {
        this.platList = platList;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
