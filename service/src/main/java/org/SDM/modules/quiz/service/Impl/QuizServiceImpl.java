package org.SDM.modules.quiz.service.Impl;

import org.SDM.common.mybatis.mapper.BaseMapper;
import org.SDM.common.mybatis.service.Impl.BaseServiceImpl;
import org.SDM.modules.quiz.entity.Quiz;
import org.SDM.modules.quiz.mapper.QuizMapper;
import org.SDM.modules.quiz.service.QuizService;
import org.springframework.stereotype.Service;

@Service
public class QuizServiceImpl extends BaseServiceImpl<Quiz>  implements QuizService {

    private final QuizMapper mapper;

    public QuizServiceImpl(QuizMapper mapper){
        this.mapper = mapper;
    }

    @Override
    public BaseMapper<Quiz> getMapper(){
        return this.mapper;
    }
}
