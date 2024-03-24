package org.SDM.modules.quiz.mapper;

import org.SDM.common.mybatis.mapper.BaseMapper;
import org.SDM.modules.quiz.entity.Feedback;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FeedbackMapper extends BaseMapper<Feedback> {
}
