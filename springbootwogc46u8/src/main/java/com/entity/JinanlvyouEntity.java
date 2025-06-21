package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 国内旅游
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-03-05 11:48:15
 */
@TableName("jinanlvyou")
public class JinanlvyouEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public JinanlvyouEntity() {
		
	}
	
	public JinanlvyouEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
    @TableId(type = IdType.AUTO)
    private Long id;
	/**
	 * 标题
	 */
					
	private String title;
	
	/**
	 * 图片
	 */
					
	private String picture;
	
	/**
	 * 建议游玩时间
	 */
					
	private String wandays;
	
	/**
	 * 简介
	 */
					
	private String brief;
	
	/**
	 * 地址
	 */
					
	private String address;
	
	/**
	 * 评分
	 */
					
	private Double score;
	
	/**
	 * 济南景点排名
	 */
					
	private Integer ranking;
	
	/**
	 * 打分人数
	 */
					
	private Integer renshu;
	
	/**
	 * 概述
	 */
					
	private String gaishu;
	
	/**
	 * 来源
	 */
					
	private String laiyuan;
	
	/**
	 * 门票
	 */
					
	private Double ticket;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：标题
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：图片
	 */
	public void setPicture(String picture) {
		this.picture = picture;
	}
	/**
	 * 获取：图片
	 */
	public String getPicture() {
		return picture;
	}
	/**
	 * 设置：建议游玩时间
	 */
	public void setWandays(String wandays) {
		this.wandays = wandays;
	}
	/**
	 * 获取：建议游玩时间
	 */
	public String getWandays() {
		return wandays;
	}
	/**
	 * 设置：简介
	 */
	public void setBrief(String brief) {
		this.brief = brief;
	}
	/**
	 * 获取：简介
	 */
	public String getBrief() {
		return brief;
	}
	/**
	 * 设置：地址
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：地址
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 设置：评分
	 */
	public void setScore(Double score) {
		this.score = score;
	}
	/**
	 * 获取：评分
	 */
	public Double getScore() {
		return score;
	}
	/**
	 * 设置：济南景点排名
	 */
	public void setRanking(Integer ranking) {
		this.ranking = ranking;
	}
	/**
	 * 获取：济南景点排名
	 */
	public Integer getRanking() {
		return ranking;
	}
	/**
	 * 设置：打分人数
	 */
	public void setRenshu(Integer renshu) {
		this.renshu = renshu;
	}
	/**
	 * 获取：打分人数
	 */
	public Integer getRenshu() {
		return renshu;
	}
	/**
	 * 设置：概述
	 */
	public void setGaishu(String gaishu) {
		this.gaishu = gaishu;
	}
	/**
	 * 获取：概述
	 */
	public String getGaishu() {
		return gaishu;
	}
	/**
	 * 设置：来源
	 */
	public void setLaiyuan(String laiyuan) {
		this.laiyuan = laiyuan;
	}
	/**
	 * 获取：来源
	 */
	public String getLaiyuan() {
		return laiyuan;
	}
	/**
	 * 设置：门票
	 */
	public void setTicket(Double ticket) {
		this.ticket = ticket;
	}
	/**
	 * 获取：门票
	 */
	public Double getTicket() {
		return ticket;
	}

}
