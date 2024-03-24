package org.SDM.modules.quiz.mapper;

import org.SDM.common.mybatis.mapper.BaseMapper;
import org.SDM.modules.quiz.entity.Quiz;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QuizMapper extends BaseMapper<Quiz> {
}
