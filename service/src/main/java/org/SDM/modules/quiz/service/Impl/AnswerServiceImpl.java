package org.SDM.modules.quiz.service.Impl;

import org.SDM.common.mybatis.mapper.BaseMapper;
import org.SDM.common.mybatis.service.Impl.BaseServiceImpl;
import org.SDM.modules.quiz.entity.Answer;
import org.SDM.modules.quiz.mapper.AnswerMapper;
import org.SDM.modules.quiz.service.AnswerService;
import org.springframework.stereotype.Service;

@Service
public class AnswerServiceImpl extends BaseServiceImpl<Answer> implements AnswerService {

    private final AnswerMapper mapper;

    public AnswerServiceImpl(AnswerMapper mapper){this.mapper = mapper;}

    @Override
    public BaseMapper<Answer> getMapper() {return this.mapper;}
}
