package com.guodu.pojo.dtu;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JbxxPhoto implements Serializable {

    private String pid;
    private String tsid;
    private String pName;
    private String pPath;

    private static final long serialVersionUID = 1L;
}