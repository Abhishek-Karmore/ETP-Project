package com.onlinefooddelivery.utility;

public class BaseRequest<T> {

    private String actionId;   // replaces ActionInfo
    private T formData;        // actual request payload
    private String logId;      // for logging/tracing

    public String getActionId() {
        return actionId;
    }

    public void setActionId(String actionId) {
        this.actionId = actionId;
    }

    public T getFormData() {
        return formData;
    }

    public void setFormData(T formData) {
        this.formData = formData;
    }

    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId;
    }
}