package org.SDM.modules.mistake.service.Impl;

import org.SDM.common.mybatis.mapper.BaseMapper;
import org.SDM.common.mybatis.service.Impl.BaseServiceImpl;
import org.SDM.modules.mistake.entity.Mistake;
import org.SDM.modules.mistake.mapper.MistakeMapper;
import org.SDM.modules.mistake.service.MistakeService;
import org.springframework.stereotype.Service;

@Service
public class MistakeServiceImpl extends BaseServiceImpl<Mistake> implements MistakeService {

    private final MistakeMapper mapper;

    public MistakeServiceImpl(MistakeMapper mapper){this.mapper = mapper;}

    @Override
    public BaseMapper<Mistake> getMapper() {return this.mapper;}
}
