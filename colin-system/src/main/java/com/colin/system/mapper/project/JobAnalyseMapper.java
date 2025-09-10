package com.colin.system.mapper.project;

import com.alibaba.fastjson.JSONObject;
import com.colin.system.domain.project.RecommendResult;
import com.colin.system.domain.project.RecommendResult2;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface JobAnalyseMapper {
    List<JSONObject> analyseOne();

    List<JSONObject> analyseTwo();

    List<JSONObject> analyseThree();

    List<JSONObject> analyseFour();

    List<JSONObject> analyseFive();

    List<JSONObject> analyseSix();

    List<JSONObject> analyseSeven();


    List<JSONObject> jobRecommend(@Param("name") String name,@Param("city") String city, @Param("experience") String experience, @Param("eduction") String eduction);

    List<JSONObject> getRecommendResult();

    void insertRecommendResult(RecommendResult recommendResult);

    List<JSONObject> getRecommendResult1();

    void insertRecommendResult1(RecommendResult2 recommendResult1);
}
