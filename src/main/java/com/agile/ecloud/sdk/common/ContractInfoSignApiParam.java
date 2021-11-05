package com.agile.ecloud.sdk.common;


public class ContractInfoSignApiParam {
    //合同编号
    private String contractNum;

    //签署信息
    private String positionName;

    private Integer page;

    private Integer x;

    private Integer y;

    private Integer isFinish;

    public ContractInfoSignApiParam(){

    }

    public ContractInfoSignApiParam(String contractNum, String positionName, Integer page, Integer x, Integer y, Integer isFinish) {
        this.contractNum = contractNum;
        this.positionName = positionName;
        this.page = page;
        this.x = x;
        this.y = y;
        this.isFinish = isFinish;
    }

    public String getContractNum() {
        return contractNum;
    }

    public void setContractNum(String contractNum) {
        this.contractNum = contractNum;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Integer getIsFinish() {
        return isFinish;
    }

    public void setIsFinish(Integer isFinish) {
        this.isFinish = isFinish;
    }
}