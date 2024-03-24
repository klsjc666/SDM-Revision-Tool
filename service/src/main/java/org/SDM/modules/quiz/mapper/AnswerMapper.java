package org.SDM.modules.quiz.mapper;

import org.SDM.common.mybatis.mapper.BaseMapper;
import org.SDM.modules.quiz.entity.Answer;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AnswerMapper extends BaseMapper<Answer> {
}
