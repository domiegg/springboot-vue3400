package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.JinanlvyouDao;
import com.entity.JinanlvyouEntity;
import com.service.JinanlvyouService;
import com.entity.vo.JinanlvyouVO;
import com.entity.view.JinanlvyouView;

@Service("jinanlvyouService")
public class JinanlvyouServiceImpl extends ServiceImpl<JinanlvyouDao, JinanlvyouEntity> implements JinanlvyouService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JinanlvyouEntity> page = this.selectPage(
                new Query<JinanlvyouEntity>(params).getPage(),
                new EntityWrapper<JinanlvyouEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JinanlvyouEntity> wrapper) {
		  Page<JinanlvyouView> page =new Query<JinanlvyouView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<JinanlvyouVO> selectListVO(Wrapper<JinanlvyouEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JinanlvyouVO selectVO(Wrapper<JinanlvyouEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JinanlvyouView> selectListView(Wrapper<JinanlvyouEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JinanlvyouView selectView(Wrapper<JinanlvyouEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<JinanlvyouEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<JinanlvyouEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<JinanlvyouEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> scoreSectionStat(Map<String, Object> params, Wrapper<JinanlvyouEntity> wrapper) {
        return baseMapper.scoreSectionStat(params, wrapper);
    }
    @Override
    public List<Map<String, Object>> renshuSectionStat(Map<String, Object> params, Wrapper<JinanlvyouEntity> wrapper) {
        return baseMapper.renshuSectionStat(params, wrapper);
    }
    @Override
    public List<Map<String, Object>> ticketSectionStat(Map<String, Object> params, Wrapper<JinanlvyouEntity> wrapper) {
        return baseMapper.ticketSectionStat(params, wrapper);
    }



}
