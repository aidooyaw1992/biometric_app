package com.miaxis.demo.data.remote.response;

public class LoginAnalyticsModel {
//    user_id,username,module,activity,remote_addr,agent,c_location,gps_location
    private String user_id;
    private String module;
    private String activity;

    public LoginAnalyticsModel(String user_id, String module, String activity) {
        this.user_id = user_id;
        this.module = module;
        this.activity = activity;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }
}
