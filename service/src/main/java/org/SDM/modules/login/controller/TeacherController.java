package org.SDM.modules.login.controller;

import org.SDM.modules.login.entity.Teacher;
import org.SDM.modules.login.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/teacher")
@CrossOrigin
public class TeacherController {

    TeacherService service;

    @Autowired
    public void setService(TeacherService service){
        this.service = service;
    }

    @PostMapping(value = "find")
    boolean find(@RequestBody Teacher teacher){
        return service.find(teacher);
    }

}
