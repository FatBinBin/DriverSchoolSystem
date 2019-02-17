package com.bin.design.drivingschool.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DssKnowledgeComment {

    private Integer id;

    private Integer learnerId;

    private Integer knowledgeId;

    private String content;

    private Byte status;
}