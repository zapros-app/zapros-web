package org.polytech.zaprosweb.dao;

import java.util.List;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.polytech.zapros.bean.Assessment;
import org.polytech.zaprosweb.dao.entity.AssessmentEntity;
import org.polytech.zaprosweb.dao.entity.CriteriaEntity;
import org.polytech.zaprosweb.dao.repository.AssessmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AssessmentDAO {

    private final Log log = LogFactory.getLog(this.getClass());

    @Autowired private AssessmentRepository assessmentRepository;

    public void addAssessments(CriteriaEntity criteriaEntity, List<Assessment> assessments) {
        int current = criteriaEntity.getOrderId() * assessments.size();

        for (Assessment assessment: assessments) {
            AssessmentEntity entity = new AssessmentEntity();
            entity.setName(assessment.getName());
            entity.setRank(assessment.getRank());
            entity.setOrderId(current++);
            entity.setCriteria(criteriaEntity);

            assessmentRepository.save(entity);
        }
    }
}
