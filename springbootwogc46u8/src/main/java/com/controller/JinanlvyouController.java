package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.Random;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.JinanlvyouEntity;
import com.entity.view.JinanlvyouView;

import com.service.JinanlvyouService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.JavaPairRDD;
import scala.Tuple2;

/**
 * 国内旅游
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-05 11:48:15
 */
@RestController
@RequestMapping("/jinanlvyou")
public class JinanlvyouController {
    @Autowired
    private JinanlvyouService jinanlvyouService;
    @Autowired
    private JavaSparkContext javaSparkContext;




    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JinanlvyouEntity jinanlvyou,
		HttpServletRequest request){
        EntityWrapper<JinanlvyouEntity> ew = new EntityWrapper<JinanlvyouEntity>();

		PageUtils page = jinanlvyouService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jinanlvyou), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JinanlvyouEntity jinanlvyou, 
		HttpServletRequest request){
        EntityWrapper<JinanlvyouEntity> ew = new EntityWrapper<JinanlvyouEntity>();

		PageUtils page = jinanlvyouService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jinanlvyou), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JinanlvyouEntity jinanlvyou){
       	EntityWrapper<JinanlvyouEntity> ew = new EntityWrapper<JinanlvyouEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jinanlvyou, "jinanlvyou")); 
        return R.ok().put("data", jinanlvyouService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JinanlvyouEntity jinanlvyou){
        EntityWrapper< JinanlvyouEntity> ew = new EntityWrapper< JinanlvyouEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jinanlvyou, "jinanlvyou")); 
		JinanlvyouView jinanlvyouView =  jinanlvyouService.selectView(ew);
		return R.ok("查询国内旅游成功").put("data", jinanlvyouView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JinanlvyouEntity jinanlvyou = jinanlvyouService.selectById(id);
        return R.ok().put("data", jinanlvyou);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JinanlvyouEntity jinanlvyou = jinanlvyouService.selectById(id);
        return R.ok().put("data", jinanlvyou);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JinanlvyouEntity jinanlvyou, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(jinanlvyou);
        jinanlvyouService.insert(jinanlvyou);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JinanlvyouEntity jinanlvyou, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(jinanlvyou);
        jinanlvyouService.insert(jinanlvyou);
        return R.ok();
    }

    /**
     * 批量生成数据
     */
    @RequestMapping("/batch/gen")
    public R batch(int recordNum){
        List<JinanlvyouEntity> list = jinanlvyouService.selectList(new EntityWrapper<JinanlvyouEntity>().last("order by rand() limit 50"));
        if(list!=null && list.size()>0 && recordNum>0) {
            List<JinanlvyouEntity> batchList = new ArrayList<JinanlvyouEntity>(recordNum);
            int max = list.size();
            Random random = new Random();
            for(int i=0;i<recordNum;i++) {
                JinanlvyouEntity jinanlvyou = new JinanlvyouEntity();
               jinanlvyou.setTitle(list.get(random.nextInt(max)).getTitle());
               jinanlvyou.setPicture(list.get(random.nextInt(max)).getPicture());
               jinanlvyou.setWandays(list.get(random.nextInt(max)).getWandays());
               jinanlvyou.setBrief(list.get(random.nextInt(max)).getBrief());
               jinanlvyou.setAddress(list.get(random.nextInt(max)).getAddress());
               jinanlvyou.setScore(list.get(random.nextInt(max)).getScore());
               jinanlvyou.setRanking(list.get(random.nextInt(max)).getRanking());
               jinanlvyou.setRenshu(list.get(random.nextInt(max)).getRenshu());
               jinanlvyou.setGaishu(list.get(random.nextInt(max)).getGaishu());
               jinanlvyou.setLaiyuan(list.get(random.nextInt(max)).getLaiyuan());
               jinanlvyou.setTicket(list.get(random.nextInt(max)).getTicket());
                batchList.add(jinanlvyou);
            }
            jinanlvyouService.insertBatch(batchList);
        }
        return R.ok();
    }




    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JinanlvyouEntity jinanlvyou, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jinanlvyou);
        jinanlvyouService.updateById(jinanlvyou);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jinanlvyouService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	






    /**
     * （按值统计）
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}")
    public R value(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        EntityWrapper<JinanlvyouEntity> ew = new EntityWrapper<JinanlvyouEntity>();
        List<Map<String, Object>> result = jinanlvyouService.selectValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        List<Map<String, Object>> result2 = new ArrayList<Map<String,Object>>();
        for(Map<String, Object> m : result) {
            List<Tuple2<String, Object>> data = new ArrayList<>();
            for(String s : m.keySet()) {
                data.add(new Tuple2<>(s, m.get(s)));
            }
            JavaPairRDD<String, Object> originRDD = javaSparkContext.parallelizePairs(data);
            result2.add(originRDD.collectAsMap());
        }
        return R.ok().put("data", result2);
    }

    /**
     * （按值统计(多)）
     */
    @RequestMapping("/valueMul/{xColumnName}")
    public R valueMul(@PathVariable("xColumnName") String xColumnName,@RequestParam String yColumnNameMul, HttpServletRequest request) {
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        EntityWrapper<JinanlvyouEntity> ew = new EntityWrapper<JinanlvyouEntity>();
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = jinanlvyouService.selectValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }

    /**
     * （按值统计）时间统计类型
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}/{timeStatType}")
    public R valueDay(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        params.put("timeStatType", timeStatType);
        EntityWrapper<JinanlvyouEntity> ew = new EntityWrapper<JinanlvyouEntity>();
        List<Map<String, Object>> result = jinanlvyouService.selectTimeStatValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        List<Map<String, Object>> result2 = new ArrayList<Map<String,Object>>();
        for(Map<String, Object> m : result) {
            List<Tuple2<String, Object>> data = new ArrayList<>();
            for(String s : m.keySet()) {
                data.add(new Tuple2<>(s, m.get(s)));
            }
            JavaPairRDD<String, Object> originRDD = javaSparkContext.parallelizePairs(data);
            result2.add(originRDD.collectAsMap());
        }
        return R.ok().put("data", result2);
    }

    /**
     * （按值统计）时间统计类型(多)
     */
    @RequestMapping("/valueMul/{xColumnName}/{timeStatType}")
    public R valueMulDay(@PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,@RequestParam String yColumnNameMul,HttpServletRequest request) {
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("timeStatType", timeStatType);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        EntityWrapper<JinanlvyouEntity> ew = new EntityWrapper<JinanlvyouEntity>();
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = jinanlvyouService.selectTimeStatValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }

    /**
     * 分组统计
     */
    @RequestMapping("/group/{columnName}")
    public R group(@PathVariable("columnName") String columnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("column", columnName);
        EntityWrapper<JinanlvyouEntity> ew = new EntityWrapper<JinanlvyouEntity>();
        List<Map<String, Object>> result = jinanlvyouService.selectGroup(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        List<Map<String, Object>> result2 = new ArrayList<Map<String,Object>>();
        for(Map<String, Object> m : result) {
            List<Tuple2<String, Object>> data = new ArrayList<>();
            for(String s : m.keySet()) {
                data.add(new Tuple2<>(s, m.get(s)));
            }
            JavaPairRDD<String, Object> originRDD = javaSparkContext.parallelizePairs(data);
            result2.add(originRDD.collectAsMap());
        }
        return R.ok().put("data", result2);
    }

    /**
     * 分段统计
     */
    @RequestMapping("/sectionStat/score")
    @IgnoreAuth
    public R scoreSectionStat(HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        EntityWrapper<JinanlvyouEntity> ew = new EntityWrapper<JinanlvyouEntity>();
        List<Map<String, Object>> result = jinanlvyouService.scoreSectionStat(params, ew);
        List<Map<String, Object>> result2 = new ArrayList<Map<String,Object>>();
        for(Map<String, Object> m : result) {
            List<Tuple2<String, Object>> data = new ArrayList<>();
            for(String s : m.keySet()) {
                data.add(new Tuple2<>(s, m.get(s)));
            }
            JavaPairRDD<String, Object> originRDD = javaSparkContext.parallelizePairs(data);
            result2.add(originRDD.collectAsMap());
        }
        return R.ok().put("data", result2);
    }
    /**
     * 分段统计
     */
    @RequestMapping("/sectionStat/renshu")
    @IgnoreAuth
    public R renshuSectionStat(HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        EntityWrapper<JinanlvyouEntity> ew = new EntityWrapper<JinanlvyouEntity>();
        List<Map<String, Object>> result = jinanlvyouService.renshuSectionStat(params, ew);
        List<Map<String, Object>> result2 = new ArrayList<Map<String,Object>>();
        for(Map<String, Object> m : result) {
            List<Tuple2<String, Object>> data = new ArrayList<>();
            for(String s : m.keySet()) {
                data.add(new Tuple2<>(s, m.get(s)));
            }
            JavaPairRDD<String, Object> originRDD = javaSparkContext.parallelizePairs(data);
            result2.add(originRDD.collectAsMap());
        }
        return R.ok().put("data", result2);
    }
    /**
     * 分段统计
     */
    @RequestMapping("/sectionStat/ticket")
    @IgnoreAuth
    public R ticketSectionStat(HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        EntityWrapper<JinanlvyouEntity> ew = new EntityWrapper<JinanlvyouEntity>();
        List<Map<String, Object>> result = jinanlvyouService.ticketSectionStat(params, ew);
        List<Map<String, Object>> result2 = new ArrayList<Map<String,Object>>();
        for(Map<String, Object> m : result) {
            List<Tuple2<String, Object>> data = new ArrayList<>();
            for(String s : m.keySet()) {
                data.add(new Tuple2<>(s, m.get(s)));
            }
            JavaPairRDD<String, Object> originRDD = javaSparkContext.parallelizePairs(data);
            result2.add(originRDD.collectAsMap());
        }
        return R.ok().put("data", result2);
    }



    /**
     * 总数量
     */
    @RequestMapping("/count")
    public R count(@RequestParam Map<String, Object> params,JinanlvyouEntity jinanlvyou, HttpServletRequest request){
        EntityWrapper<JinanlvyouEntity> ew = new EntityWrapper<JinanlvyouEntity>();
        int count = jinanlvyouService.selectCount(MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jinanlvyou), params), params));
        return R.ok().put("data", count);
    }



}
