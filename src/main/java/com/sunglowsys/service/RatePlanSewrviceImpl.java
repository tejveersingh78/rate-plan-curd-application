package com.sunglowsys.service;

import com.sunglowsys.domain.RatePlan;
import com.sunglowsys.repository.RatePlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatePlanSewrviceImpl implements RatePlanService{

    @Autowired
    private RatePlanRepository ratePlanRepository;

    @Override
    public RatePlan create(RatePlan ratePlan) {
        return ratePlanRepository.save(ratePlan);
    }

    @Override
    public RatePlan update(RatePlan ratePlan, Long id) {
        RatePlan ratePlan1 = findById(id);
        if(ratePlan.getName() != null){
            ratePlan1.setName(ratePlan.getName());
        }
        RatePlan result = ratePlanRepository.save(ratePlan1);
        return result;
    }

    @Override
    public List<RatePlan> findAll() {
        return ratePlanRepository.findAll();
    }

    @Override
    public RatePlan findById(Long id) {
        return ratePlanRepository.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        ratePlanRepository.deleteById(id);

    }
}
