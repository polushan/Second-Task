package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "request")
public class Request {

    @Id
    @Column(name = "dspId")
    private String dspId;
    @Column(name = "userId", nullable = false)
    private String userId;
    @Column(name = "externalUserId", nullable = false)
    private String externalUserId;

    public Request() {

    }

    public Request(String dspId, String userId, String externalUserId) {
        this.dspId = dspId;
        this.userId = userId;
        this.externalUserId = externalUserId;
    }

    public String getDspId() {
        return dspId;
    }

    public void setDspId(String dspId) {
        this.dspId = dspId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getExternalUserId() {
        return externalUserId;
    }

    public void setExternalUserId(String externalUserId) {
        this.externalUserId = externalUserId;
    }
}
