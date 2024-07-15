package org.eu.luolei.compatition_ex.pojo;

public class ToolReturn {
    private Integer id;
    private Integer toolBorrowId;
    private Integer number;
    private Integer approvedUserId;
    private Boolean approveState;
    private String toolState;
    private Boolean damaged;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getToolBorrowId() {
        return toolBorrowId;
    }

    public void setToolBorrowId(Integer toolBorrowId) {
        this.toolBorrowId = toolBorrowId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getApprovedUserId() {
        return approvedUserId;
    }

    public void setApprovedUserId(Integer approvedUserId) {
        this.approvedUserId = approvedUserId;
    }

    public Boolean getApproveState() {
        return approveState;
    }

    public void setApproveState(Boolean approveState) {
        this.approveState = approveState;
    }

    public String getToolState() {
        return toolState;
    }

    public void setToolState(String toolState) {
        this.toolState = toolState;
    }

    public Boolean getDamaged() {
        return damaged;
    }

    public void setDamaged(Boolean damaged) {
        this.damaged = damaged;
    }
}
