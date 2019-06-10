package com.ylsh.study.javabase.demo1;

public enum TrafficLightImples implements TrafficLightInterface{
    RED("RED","红灯"){
        @Override
        public void doaction() {

        }
    },
    GREEN("GREEN","绿灯"){
        @Override
        public void doaction() {

        }
    };

    private String color;

    private String desc;//描述

    private TrafficLightImples(String color,String desc){

    }
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
