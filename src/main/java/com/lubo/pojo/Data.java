package com.lubo.pojo;

public class Data {
    private String delResult;
    private String result;
    public Data() {
    }


    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getDelResult() {
        return delResult;
    }

    public void setDelResult(String delResult) {
        this.delResult = delResult;
    }

    @Override
    public String toString() {
        return "Data{" +
                "delResult='" + delResult + '\'' +
                ", result='" + result + '\'' +
                '}';
    }
}
