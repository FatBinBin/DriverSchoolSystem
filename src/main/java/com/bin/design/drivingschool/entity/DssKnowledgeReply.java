package com.bin.design.drivingschool.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DssKnowledgeReply {

    private Integer id;

    private Integer commentId;

    private String content;

    private Byte status;

}