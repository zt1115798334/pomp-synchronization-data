package com.example.pompsynchronizationdata.source.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.example.pompsynchronizationdata.base.entity.IdEntity;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "t_languages")
public class SourceLanguages extends IdEntity {
	private Long id;
	private String name;
	private LocalDateTime time;
	
}
