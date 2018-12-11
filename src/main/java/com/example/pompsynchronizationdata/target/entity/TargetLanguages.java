package com.example.pompsynchronizationdata.target.entity;

import java.time.LocalDateTime;

import javax.persistence.*;

import com.example.pompsynchronizationdata.base.entity.IdEntity;

import lombok.Data;


/**
 * Created with IntelliJ IDEA.
 *
 * @author six
 * date: 2018/12/10 15:03
 * description:
 */
@Data
@Entity
@Table(name = "t_languages")
public class TargetLanguages extends IdEntity{
    	/**
	* 
	*/
	private Long id;
	/**
	* 
	*/
	private String name;
	/**
	* 
	*/
	private LocalDateTime time;


    
}
