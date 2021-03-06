package org.polytech.zaprosweb.dao.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.polytech.zapros.bean.Assessment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "assessments")
public class AssessmentEntity implements IEntity<Assessment> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int rank;

    @Column(nullable = false)
    private int orderId;

    @ManyToOne
    @JoinColumn(name = "criteria_id", nullable = false)
    private CriteriaEntity criteria;

    @ManyToMany(mappedBy = "assessmentSet")
    @ToString.Exclude
    private Set<AlternativeEntity> alternativeSet = new HashSet<>();

    //ignore
    @OneToMany(mappedBy = "i")
    @ToString.Exclude
    private Set<AnswerEntity> answersI = new HashSet<>();

    //ignore
    @OneToMany(mappedBy = "j")
    @ToString.Exclude
    private Set<AnswerEntity> answersJ = new HashSet<>();

    //ignore
    @OneToMany(mappedBy = "assessment")
    @ToString.Exclude
    private Set<RankEntity> ranks = new HashSet<>();

    @Override
    public Assessment toModel() {
        return new Assessment(id, name, criteria.getId(), rank, orderId);
    }
}
