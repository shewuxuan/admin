package com.guodu.pojo.equip;

import lombok.Data;

import java.io.Serializable;

@Data
public class EquipPhoto implements Serializable {

    private String pid;
    private String sbid;
    private String pName;
    private String pPath;
}