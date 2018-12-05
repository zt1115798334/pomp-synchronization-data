package com.example.pompsynchronizationdata.source.entity;

import com.example.pompsynchronizationdata.base.entity.IdEntity;
import lombok.Data;

import javax.persistence.*;


/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/05 17:30
 * description:
 */
@Data
@Entity
@Table(name = "t_speech_order")
public class SourceSpeechOrder extends IdEntity {

	/**
	* 
	*/
	private Long userId;
	/**
	* 订阅内容，type：报告类型（day日报，week周报，month月报）；email：发送邮箱地址
	*/
	private String orderContent;


    
}
