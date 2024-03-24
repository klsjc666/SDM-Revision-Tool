package org.SDM.modules.quiz.controller;

import org.SDM.common.mybatis.model.SaveModel;
import org.SDM.common.mybatis.model.TabPage;
import org.SDM.modules.quiz.entity.Feedback;
import org.SDM.modules.quiz.service.FeedbackService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/feedback")
@CrossOrigin
public class FeedbackController {

    private final FeedbackService service;

    public FeedbackController(FeedbackService service){this.service = service;}

    @PostMapping(value = "page")
    public ResponseEntity<TabPage<Feedback>> page(@RequestBody Map<String, Object> param){
        return new ResponseEntity<>(service.selectForPage(param), HttpStatus.OK);
    }

    @DeleteMapping(value = "dels")
    public ResponseEntity<Object> dels(@RequestBody List<Object> ids){
        service.deleteByIds(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "del")
    public ResponseEntity<Object> del(@RequestBody Feedback feedback){
        service.delete(feedback);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "batchSave")
    public ResponseEntity<SaveModel<Feedback>> batchSave(@RequestBody SaveModel<Feedback> entity){
        return new ResponseEntity<>(service.batchSaveOrUpdate(entity), HttpStatus.OK);
    }

    @PostMapping(value = "save")
    public ResponseEntity<Feedback> save(@RequestBody Feedback feedback){
        if (StringUtils.isNotBlank(feedback.getFeedbackId())){
            feedback.setId(feedback.getFeedbackId());
        }
        return new ResponseEntity<>(service.saveOrUpdate(feedback), HttpStatus.OK);
    }

    @PostMapping(value = "load")
    public ResponseEntity<Feedback> load(@RequestBody Feedback feedback){
        return new ResponseEntity<>(service.selectByPK(feedback),HttpStatus.OK);
    }
}
