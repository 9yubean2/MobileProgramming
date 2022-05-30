package com.example.covid19apirecyclerview;

public class Dictionary
{

    String createDt;
    String gubun;
    String defCnt;


    public Dictionary( String createDt,String gubun, String defCnt ) {
        this.createDt = createDt;
        this.gubun = gubun;
        this.defCnt = defCnt;
    }


    public String getCreateDt() {
        return createDt;
    }

    public void setCreateDt(String createDt) {
        this.createDt = createDt;
    }

    public String getGubun() {
        return gubun;
    }

    public void setGubun(String gubun) {
        this.gubun = gubun;
    }

    public String getDefCnt() {
        return defCnt;
    }

    public void setDefCnt(String defCnt) {
        this.defCnt = defCnt;
    }
}