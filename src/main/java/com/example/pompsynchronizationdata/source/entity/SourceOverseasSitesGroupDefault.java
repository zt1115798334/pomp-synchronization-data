package com.example.pompsynchronizationdata.source.entity;

import com.example.pompsynchronizationdata.base.entity.IdEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/10 10:10
 * description:
 */
@Data
@Entity
@Table(name = "t_overseas_sites_group_default")
public class SourceOverseasSitesGroupDefault extends IdEntity {

    /**
     *
     */
    private String name;


}
