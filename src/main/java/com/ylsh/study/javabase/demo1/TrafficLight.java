package com.ylsh.study.javabase.demo1;

public enum TrafficLight {
    RED("RED","红灯"),
    GREEN("GREEN","绿灯");

    private String value;

    private String desc;

    private TrafficLight(String value,String desc){
        this.value = value;
        this.desc = desc;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
