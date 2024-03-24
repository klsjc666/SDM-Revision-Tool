package org.SDM.modules.login.service;

import org.SDM.modules.login.entity.Teacher;
import org.SDM.modules.login.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

    TeacherMapper mapper;
    @Autowired
    public void setMapper(TeacherMapper mapper){
        this.mapper = mapper;
    }

    public boolean find(Teacher teacher){
        return mapper.find(teacher) != null;
    }
}
