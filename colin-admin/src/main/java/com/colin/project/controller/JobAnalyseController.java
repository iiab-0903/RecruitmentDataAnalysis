package com.colin.project.controller;

import com.alibaba.fastjson.JSONObject;
import com.colin.common.core.controller.BaseController;
import com.colin.common.core.domain.AjaxResult;
import com.colin.common.core.page.TableDataInfo;
import com.colin.system.domain.project.RecommendResult;
import com.colin.system.domain.project.RecommendResult2;
import com.colin.system.mapper.project.JobAnalyseMapper;
import com.google.gson.Gson;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/project/jobAnalyse")
public class JobAnalyseController extends BaseController {
    private String prefix = "project/jobAnalyse";

    @Autowired
    private JobAnalyseMapper jobAnalyseMapper;

    @GetMapping("/industrySalary")
    public String industrySalary() {
        return prefix + "/industrySalary";
    }

    @GetMapping("/educationSalary")
    public String educationSalary() {
        return prefix + "/educationSalary";
    }

    @GetMapping("/citySalary")
    public String citySalary() {
        return prefix + "/citySalary";
    }


    @GetMapping("/scaleCnt")
    public String scaleCnt() {
        return prefix + "/scaleCnt";
    }

    @GetMapping("/typeCnt")
    public String typeCnt() {
        return prefix + "/typeCnt";
    }

    @GetMapping("/eductionCnt")
    public String eductionCnt() {
        return prefix + "/eductionCnt";
    }

    @GetMapping("/experienceCnt")
    public String experienceCnt() {
        return prefix + "/experienceCnt";
    }


    @GetMapping("/jobRecommend")
    public String jobRecommend() {
        return prefix + "/jobRecommend";
    }

    @ApiOperation(value = "解析职位推荐数据并入库", notes = "")
    @GetMapping("/parseRecommendDetail")
    @ResponseBody
    public AjaxResult parseRecommendDetail() {
        List<JSONObject> analyseOne = jobAnalyseMapper.getRecommendResult();
        for (JSONObject jsonObject : analyseOne) {
            String recommendedJobs = jsonObject.getString("recommended_jobs");
            Integer userId = jsonObject.getInteger("user_id");
            Gson gson = new Gson();
            String[][] result = gson.fromJson(recommendedJobs, String[][].class);
            for (String[] pair : result) {
                RecommendResult recommendResult = new RecommendResult();
                recommendResult.setUserId(userId);
                recommendResult.setJobId(Integer.valueOf(String.valueOf(pair[0])));
                recommendResult.setRecommendIndex(BigDecimal.valueOf(Double.parseDouble(pair[1])));
                jobAnalyseMapper.insertRecommendResult(recommendResult);
            }
        }
        return AjaxResult.success(analyseOne);
    }

    @ApiOperation(value = "解析职位推荐数据并入库", notes = "")
    @GetMapping("/parseRecommendDetail2")
    @ResponseBody
    public AjaxResult parseRecommendDetail2() {
        List<JSONObject> analyseOne = jobAnalyseMapper.getRecommendResult1();
        for (JSONObject jsonObject : analyseOne) {
            String recommendedTv = jsonObject.getString("recommended_tv");
            Integer userId = jsonObject.getInteger("user_id");
            Gson gson = new Gson();
            String[][] result = gson.fromJson(recommendedTv, String[][].class);
            for (String[] pair : result) {
                RecommendResult2 recommendResult = new RecommendResult2();
                recommendResult.setUserId(userId);
                recommendResult.setShowId(Integer.valueOf(String.valueOf(pair[0])));
                recommendResult.setRecommendIndex(BigDecimal.valueOf(Double.parseDouble(pair[1])));
                jobAnalyseMapper.insertRecommendResult1(recommendResult);
            }
        }
        return AjaxResult.success(analyseOne);
    }

    @ApiOperation(value = "分析1", notes = "")
    @GetMapping("/analyseOne")
    @ResponseBody
    public AjaxResult analyseOne() {
        List<JSONObject> analyseOne = jobAnalyseMapper.analyseOne();
        return AjaxResult.success(analyseOne);
    }

    @ApiOperation(value = "分析1", notes = "")
    @GetMapping("/analyseTwo")
    @ResponseBody
    public AjaxResult analyseTwo() {
        List<JSONObject> analyseOne = jobAnalyseMapper.analyseTwo();
        return AjaxResult.success(analyseOne);
    }

    @ApiOperation(value = "分析1", notes = "")
    @GetMapping("/analyseThree")
    @ResponseBody
    public AjaxResult analyseThree() {
        List<JSONObject> analyseOne = jobAnalyseMapper.analyseThree();
        return AjaxResult.success(analyseOne);
    }

    @ApiOperation(value = "分析1", notes = "")
    @GetMapping("/analyseFour")
    @ResponseBody
    public AjaxResult analyseFour() {
        List<JSONObject> analyseOne = jobAnalyseMapper.analyseFour();
        return AjaxResult.success(analyseOne);
    }

    @ApiOperation(value = "分析5", notes = "")
    @GetMapping("/analyseFive")
    @ResponseBody
    public AjaxResult analyseFive() {
        List<JSONObject> analyseOne = jobAnalyseMapper.analyseFive();
        return AjaxResult.success(analyseOne);
    }

    @ApiOperation(value = "分析5", notes = "")
    @GetMapping("/analyseSix")
    @ResponseBody
    public AjaxResult analyseSix() {
        List<JSONObject> analyseOne = jobAnalyseMapper.analyseSix();
        return AjaxResult.success(analyseOne);
    }

    @ApiOperation(value = "分析5", notes = "")
    @GetMapping("/analyseSeven")
    @ResponseBody
    public AjaxResult analyseSeven() {
        List<JSONObject> analyseOne = jobAnalyseMapper.analyseSeven();
        return AjaxResult.success(analyseOne);
    }

    @PostMapping("/jobRecommendTable")
    @ResponseBody
    public TableDataInfo jobRecommendTable(@RequestParam(value = "name", required = false) String name,
                                           @RequestParam(value = "city", required = false) String city,
                                           @RequestParam(value = "experience", required = false) String experience,
                                           @RequestParam(value = "eduction", required = false) String eduction
    ) {
        startPage();
        List<JSONObject> list = jobAnalyseMapper.jobRecommend(name, city, experience, eduction);
        return getDataTable(list);
    }
}
