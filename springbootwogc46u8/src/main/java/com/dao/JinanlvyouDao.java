package com.dao;

import com.entity.JinanlvyouEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JinanlvyouVO;
import com.entity.view.JinanlvyouView;


/**
 * 国内旅游
 * 
 * @author 
 * @email 
 * @date 2024-03-05 11:48:15
 */
public interface JinanlvyouDao extends BaseMapper<JinanlvyouEntity> {
	
	List<JinanlvyouVO> selectListVO(@Param("ew") Wrapper<JinanlvyouEntity> wrapper);
	
	JinanlvyouVO selectVO(@Param("ew") Wrapper<JinanlvyouEntity> wrapper);
	
	List<JinanlvyouView> selectListView(@Param("ew") Wrapper<JinanlvyouEntity> wrapper);

	List<JinanlvyouView> selectListView(Pagination page,@Param("ew") Wrapper<JinanlvyouEntity> wrapper);

	
	JinanlvyouView selectView(@Param("ew") Wrapper<JinanlvyouEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<JinanlvyouEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<JinanlvyouEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<JinanlvyouEntity> wrapper);

    List<Map<String, Object>> scoreSectionStat(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<JinanlvyouEntity> wrapper);
    List<Map<String, Object>> renshuSectionStat(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<JinanlvyouEntity> wrapper);
    List<Map<String, Object>> ticketSectionStat(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<JinanlvyouEntity> wrapper);


}
