package org.SDM.modules.mistake.mapper;

import org.SDM.common.mybatis.mapper.BaseMapper;
import org.SDM.modules.mistake.entity.Mistake;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MistakeMapper extends BaseMapper<Mistake> {
}
