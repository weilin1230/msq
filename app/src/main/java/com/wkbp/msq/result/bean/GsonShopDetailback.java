package com.wkbp.msq.result.bean;

import java.io.Serializable;
import java.util.List;

public class GsonShopDetailback implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 8959885432480233347L;
    private String result;
    private String resultNote;
    private String totalPage;
    private List<CommodityBean> commodityList;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getResultNote() {
        return resultNote;
    }

    public void setResultNote(String resultNote) {
        this.resultNote = resultNote;
    }

    public String getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(String totalPage) {
        this.totalPage = totalPage;
    }

    public List<CommodityBean> getCommodityList() {
        return commodityList;
    }

    public void setCommodityList(List<CommodityBean> commodityList) {
        this.commodityList = commodityList;
    }

    @Override
    public String toString() {
        return "GsonShopDetailback [result=" + result + ", resultNote="
                + resultNote + ", totalPage=" + totalPage + ", commodityList="
                + commodityList + "]";
    }

}
