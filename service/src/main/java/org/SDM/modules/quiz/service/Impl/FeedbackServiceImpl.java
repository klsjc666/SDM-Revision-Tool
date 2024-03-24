package org.SDM.modules.quiz.service.Impl;

import org.SDM.common.mybatis.mapper.BaseMapper;
import org.SDM.common.mybatis.service.Impl.BaseServiceImpl;
import org.SDM.modules.quiz.entity.Feedback;
import org.SDM.modules.quiz.mapper.FeedbackMapper;
import org.SDM.modules.quiz.service.FeedbackService;
import org.springframework.stereotype.Service;

@Service
public class FeedbackServiceImpl extends BaseServiceImpl<Feedback> implements FeedbackService {

    private final FeedbackMapper mapper;

    public FeedbackServiceImpl(FeedbackMapper mapper){this.mapper = mapper;}

    @Override
    public BaseMapper<Feedback> getMapper() {return this.mapper;}
}
