package edu.upc.eetac.dsa.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by OriolGresa on 21/12/16.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EtakemonError {
    private int status;
    private String reason;

    public EtakemonError() {
    }

    public EtakemonError(int status, String reason) {
        this.status = status;
        this.reason = reason;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}