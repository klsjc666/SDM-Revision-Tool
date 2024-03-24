package org.SDM.modules.mistake.controller;

import org.SDM.common.mybatis.model.SaveModel;
import org.SDM.common.mybatis.model.TabPage;
import org.SDM.modules.mistake.entity.Mistake;
import org.SDM.modules.mistake.service.MistakeService;
import org.SDM.modules.quiz.controller.AnswerController;
import org.SDM.modules.quiz.entity.Answer;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/mistake")
@CrossOrigin
public class MistakeController {

    private final MistakeService service;

    public MistakeController(MistakeService service){this.service = service;}

    @PostMapping(value = "page")
    public ResponseEntity<TabPage<Mistake>> page(@RequestBody Map<String, Object> param){
        return new ResponseEntity<>(service.selectForPage(param), HttpStatus.OK);
    }

    @DeleteMapping(value = "dels")
    public ResponseEntity<Object> dels(@RequestBody List<Object> ids){
        service.deleteByIds(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "del")
    public ResponseEntity<Object> del(@RequestBody Mistake mistake){
        service.delete(mistake);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "batchSave")
    public ResponseEntity<SaveModel<Mistake>> batchSave(@RequestBody SaveModel<Mistake> entity){
        return new ResponseEntity<>(service.batchSaveOrUpdate(entity), HttpStatus.OK);
    }

    @PostMapping(value = "save")
    public ResponseEntity<Mistake> save(@RequestBody Mistake mistake){
        if (StringUtils.isNotBlank(mistake.getMistakeId())){
            mistake.setId(mistake.getMistakeId());
        }
        return new ResponseEntity<>(service.saveOrUpdate(mistake), HttpStatus.OK);
    }

    @PostMapping(value = "load")
    public ResponseEntity<Mistake> load(@RequestBody Mistake mistake){
        return new ResponseEntity<>(service.selectByPK(mistake),HttpStatus.OK);
    }
}
