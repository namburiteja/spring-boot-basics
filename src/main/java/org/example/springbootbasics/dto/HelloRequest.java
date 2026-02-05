package org.example.springbootbasics.dto;


public class HelloRequest {
    private String boyName;
    private String girlName;
    public String getboyName(){
        return boyName;
    }
    public String getgirlName(){
        return girlName;
    }
    public void setboyName(String x){
        this.boyName = x;
    }
    public void setgirlName(String y){
        this.girlName = y;
    }

}
