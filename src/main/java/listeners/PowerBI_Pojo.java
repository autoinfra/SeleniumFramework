package listeners;

import java.util.List;

public class PowerBI_Pojo {
    private String Suitename;
    private String Classname;
    private String Methodname;
    private String MethodDescription;
    private String Host;
    private String Result;
    private long Duration;

    public void setSuitename(String suitename) {
        Suitename = suitename;
    }

    public void setClassname(String classname) {
        Classname = classname;
    }

    public void setMethodname(String methodname) {
        Methodname = methodname;
    }

    public void setMethodDescription(String methodDescription) {
        MethodDescription = methodDescription;
    }

    public void setHost(String host) {
        Host = host;
    }

    public void setResult(String result) {
        Result = result;
    }

    public String getSuitename() {
        return Suitename;
    }

    public String getClassname() {
        return Classname;
    }

    public String getMethodname() {
        return Methodname;
    }

    public String getMethodDescription() {
        return MethodDescription;
    }

    public String getHost() {
        return Host;
    }

    public String getResult() {
        return Result;
    }

    public long getDuration() {
        return Duration;
    }

    public void setDuration(long duration) {
        Duration = duration;
    }

}
