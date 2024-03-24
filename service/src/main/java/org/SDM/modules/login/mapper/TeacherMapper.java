package org.SDM.modules.login.mapper;

import org.SDM.modules.login.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TeacherMapper {

    Integer find(Teacher teacher);
}
