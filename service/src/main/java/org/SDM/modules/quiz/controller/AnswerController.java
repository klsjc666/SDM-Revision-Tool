package org.SDM.modules.quiz.controller;

import org.SDM.common.mybatis.model.SaveModel;
import org.SDM.common.mybatis.model.TabPage;
import org.SDM.modules.quiz.entity.Answer;
import org.SDM.modules.quiz.service.AnswerService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/answer")
@CrossOrigin
public class AnswerController {

    private final AnswerService service;

    public AnswerController(AnswerService service){
        this.service = service;
    }

    @PostMapping(value = "page")
    public ResponseEntity<TabPage<Answer>> page(@RequestBody Map<String, Object> param){
        return new ResponseEntity<>(service.selectForPage(param), HttpStatus.OK);
    }

    @DeleteMapping(value = "dels")
    public ResponseEntity<Object> dels(@RequestBody List<Object> ids){
        service.deleteByIds(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "del")
    public ResponseEntity<Object> del(@RequestBody Answer answer){
        service.delete(answer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "batchSave")
    public ResponseEntity<SaveModel<Answer>> batchSave(@RequestBody SaveModel<Answer> entity){
        return new ResponseEntity<>(service.batchSaveOrUpdate(entity), HttpStatus.OK);
    }

    @PostMapping(value = "save")
    public ResponseEntity<Answer> save(@RequestBody Answer answer){
        if (StringUtils.isNotBlank(answer.getAnswerId())){
            answer.setId(answer.getAnswerId());
        }
        return new ResponseEntity<>(service.saveOrUpdate(answer), HttpStatus.OK);
    }

    @PostMapping(value = "load")
    public ResponseEntity<Answer> load(@RequestBody Answer answer){
        return new ResponseEntity<>(service.selectByPK(answer),HttpStatus.OK);
    }

    /*
    public Answer innerSave(Answer answer){
        if (StringUtils.isNotBlank(answer.getAnswerId())){
            answer.setId(answer.getAnswerId());
        }
        return service.saveOrUpdate(answer);
    }

    public Answer innerLoad(Answer answer){
        return service.selectByPK(answer);
    }
     */
}

