package org.eu.luolei.compatition_ex.pojo;

import java.math.BigInteger;
import java.time.LocalDateTime;

public class ToolBorrow {
    private Integer id;
    private Integer borrowUserId;
    private Integer toolId;
    private LocalDateTime startTime;
    private LocalDateTime expectTime;
    private Integer duration;
    private Integer approvedUserId;
    private Boolean approvedState;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBorrowUserId() {
        return borrowUserId;
    }

    public void setBorrowUserId(Integer borrowUserId) {
        this.borrowUserId = borrowUserId;
    }

    public Integer getToolId() {
        return toolId;
    }

    public void setToolId(Integer toolId) {
        this.toolId = toolId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getExpectTime() {
        return expectTime;
    }

    public void setExpectTime(LocalDateTime expectTime) {
        this.expectTime = expectTime;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getApprovedUserId() {
        return approvedUserId;
    }

    public void setApprovedUserId(Integer approvedUserId) {
        this.approvedUserId = approvedUserId;
    }

    public Boolean getApprovedState() {
        return approvedState;
    }

    public void setApprovedState(Boolean approvedState) {
        this.approvedState = approvedState;
    }
}
