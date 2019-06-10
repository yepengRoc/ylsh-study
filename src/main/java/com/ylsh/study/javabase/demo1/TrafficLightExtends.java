package com.ylsh.study.javabase.demo1;

public enum  TrafficLightExtends {
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

    private TrafficLightExtends(String color,String desc){
        this.color = color;
        this.desc = desc;
    }
    public abstract void doaction();

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
