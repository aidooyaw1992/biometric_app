package com.miaxis.demo.data.remote.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class PensionData implements Serializable {
    @SerializedName("@odata.context")
    @Expose
    private String odataContext;
    @SerializedName("value")
    @Expose
    private List<Value> value;

    public String getOdataContext() {
        return odataContext;
    }

    public void setOdataContext(String odataContext) {
        this.odataContext = odataContext;
    }

    public List<Value> getValue() {
        return value;
    }

    public void setValue(List<Value> value) {
        this.value = value;
    }

}

