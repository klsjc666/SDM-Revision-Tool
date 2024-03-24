package org.SDM.modules.quiz.controller;

import org.SDM.common.mybatis.model.SaveModel;
import org.SDM.common.mybatis.model.TabPage;
import org.SDM.modules.quiz.entity.Quiz;
import org.SDM.modules.quiz.service.QuizService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/quiz")
@CrossOrigin
public class QuizController {

    private final QuizService service;

    public QuizController(QuizService service){
        this.service = service;
    }

    @PostMapping(value = "page")
    public ResponseEntity<TabPage<Quiz>> page(@RequestBody Map<String, Object> param){
        return new ResponseEntity<>(service.selectForPage(param), HttpStatus.OK);
    }

    @DeleteMapping(value = "del")
    public ResponseEntity<Object> del(@RequestBody List<Object> ids){
        service.deleteByIds(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "batchSave")
    public ResponseEntity<SaveModel<Quiz>> batchSave(@RequestBody SaveModel<Quiz> entity){
        return new ResponseEntity<>(service.batchSaveOrUpdate(entity), HttpStatus.OK);
    }

    @PostMapping(value = "save")
    public ResponseEntity<Quiz> save(@RequestBody Quiz quiz){
        return new ResponseEntity<>(service.saveOrUpdate(quiz), HttpStatus.OK);
    }

    @PostMapping(value = "update")
    public ResponseEntity<Quiz> update(@RequestBody Quiz quiz){
        if (StringUtils.isNotBlank(quiz.getQuizId())){
            quiz.setId(quiz.getQuizId());
        }
        return new ResponseEntity<>(service.saveOrUpdate(quiz), HttpStatus.OK);
    }

    @PostMapping(value = "load")
    public ResponseEntity<Quiz> load(@RequestBody Quiz quiz){
        return new ResponseEntity<>(service.selectByPK(quiz.getQuizId()),HttpStatus.OK);
    }
}
