package com.example.pompsynchronizationdata.source.service.impl;

import com.example.pompsynchronizationdata.base.service.PageUtils;
import com.example.pompsynchronizationdata.custom.DateUtils;
import com.example.pompsynchronizationdata.source.entity.SourceWarning;
import com.example.pompsynchronizationdata.source.repo.SourceWarningRepository;
import com.example.pompsynchronizationdata.source.service.SourceWarningService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/04 11:12
 * description:
 */
@Service
@Transactional(rollbackOn = RuntimeException.class)
public class SourceWarningServiceImpl implements SourceWarningService {

    @Autowired
    private SourceWarningRepository sourceWarningRepository;

    @Override
    public Page<SourceWarning> findPageByEntity(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageUtils.buildPageRequest(pageNumber, pageSize);
        LocalDateTime startTime = DateUtils.currentDateTimeAddMonth(-4);
        LocalDateTime endTime = DateUtils.currentDateTime();
        Specification<SourceWarning> specification = (Specification<SourceWarning>) (root, query, builder) -> {
            List<Predicate> predicates = Lists.newArrayList();
            predicates.add(builder.greaterThanOrEqualTo(root.get("inTime").as(LocalDateTime.class), startTime));
            predicates.add(builder.lessThanOrEqualTo(root.get("inTime").as(LocalDateTime.class), endTime));
            Predicate[] pre = new Predicate[predicates.size()];
            query.where(predicates.toArray(pre));

            return builder.and(predicates.toArray(pre));
        };

        return sourceWarningRepository.findAll(specification, pageRequest);
    }
}
