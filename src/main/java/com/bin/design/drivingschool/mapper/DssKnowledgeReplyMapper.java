package com.bin.design.drivingschool.mapper;

import com.bin.design.drivingschool.entity.DssKnowledgeReply;

public interface DssKnowledgeReplyMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dss_knowledge_reply
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dss_knowledge_reply
     *
     * @mbggenerated
     */
    int insert(DssKnowledgeReply record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dss_knowledge_reply
     *
     * @mbggenerated
     */
    int insertSelective(DssKnowledgeReply record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dss_knowledge_reply
     *
     * @mbggenerated
     */
    DssKnowledgeReply selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dss_knowledge_reply
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(DssKnowledgeReply record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dss_knowledge_reply
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(DssKnowledgeReply record);
}