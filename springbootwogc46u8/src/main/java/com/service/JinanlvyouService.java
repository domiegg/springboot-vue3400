package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JinanlvyouEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JinanlvyouVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JinanlvyouView;


/**
 * 国内旅游
 *
 * @author 
 * @email 
 * @date 2024-03-05 11:48:15
 */
public interface JinanlvyouService extends IService<JinanlvyouEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JinanlvyouVO> selectListVO(Wrapper<JinanlvyouEntity> wrapper);
   	
   	JinanlvyouVO selectVO(@Param("ew") Wrapper<JinanlvyouEntity> wrapper);
   	
   	List<JinanlvyouView> selectListView(Wrapper<JinanlvyouEntity> wrapper);
   	
   	JinanlvyouView selectView(@Param("ew") Wrapper<JinanlvyouEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JinanlvyouEntity> wrapper);

   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<JinanlvyouEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<JinanlvyouEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<JinanlvyouEntity> wrapper);

    List<Map<String, Object>> scoreSectionStat(Map<String, Object> params,Wrapper<JinanlvyouEntity> wrapper);
    List<Map<String, Object>> renshuSectionStat(Map<String, Object> params,Wrapper<JinanlvyouEntity> wrapper);
    List<Map<String, Object>> ticketSectionStat(Map<String, Object> params,Wrapper<JinanlvyouEntity> wrapper);


}

