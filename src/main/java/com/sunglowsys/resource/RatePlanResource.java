package com.sunglowsys.resource;

import com.sunglowsys.domain.RatePlan;
import com.sunglowsys.service.RatePlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RatePlanResource {

    @Autowired
    private RatePlanService ratePlanService;

    @PostMapping("/rateplans")
    public ResponseEntity<?> create(@RequestBody RatePlan ratePlan){
        RatePlan result = ratePlanService.create(ratePlan);
        return ResponseEntity.ok().body("RatePlan is created successfully : " + result);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<RatePlan> update(@RequestBody RatePlan ratePlan,@PathVariable("id") Long id){
        RatePlan result = ratePlanService.update(ratePlan,id);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping
    public List<RatePlan> getAll(){
        List<RatePlan> result = ratePlanService.findAll();
        return result;
    }

    @GetMapping("get/{id}")
    public RatePlan getById(@PathVariable("id") Long id){
        return ratePlanService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        ratePlanService.delete(id);
        return ResponseEntity.ok().body("RatePlan is deleted successfully on this Id : " + id);
    }
}
