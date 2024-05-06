package com.one.pojian.controller;

import com.one.pojian.entity.po.ReqParamArea;
import com.one.pojian.entity.po.ReqParamCountry;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @description：请求参数测试
 */
@RestController
@RequestMapping("/reqParamTest")
public class ReqParamTest {
    @RequestMapping("fun1")
    public String fun1(String name, String code) {
        String out = "fun1:" + name + code;
        System.out.println(out);
        return out;
    }
    @RequestMapping("fun2")
    public String fun2(ReqParamArea reqParamArea) {
        String out = "fun2:" + reqParamArea.getName() + reqParamArea.getCode();
        System.out.println(out);
        return out;
    }
    @RequestMapping("fun3/{name}/{number}")
    public String fun3(@PathVariable String name, @PathVariable("number") String code) {
        String out = "fun3:" + name + code;
        System.out.println(out);
        return out;
    }
    @RequestMapping("fun4")
    public String fun4(HttpServletRequest httpServletRequest) {
        String name = httpServletRequest.getParameter("name");
        String code = httpServletRequest.getParameter("code");
        String out = "fun4:" + name + code;
        System.out.println(out);
        return out;
    }
    @RequestMapping("fun5")
    public String fun5(@RequestParam(name = "name", required = false, defaultValue = "默认值") String name, @RequestParam String code) {
        String out = "fun5:" + name + code;
        System.out.println(out);
        return out;
    }
    @RequestMapping("fun6")
    public String fun6(@RequestParam Map<String, Object> map) {
        String out = "fun6:" + map + map.get("name");
        System.out.println(out);
        return out;
    }
    @RequestMapping("fun7")
    public String fun7(@RequestBody ReqParamArea reqParamArea) {
        String out = "fun7:" + reqParamArea.getName() + reqParamArea.getCode();
        System.out.println(out);
        return out;
    }
    @RequestMapping("fun8")
    public String fun8(@RequestBody ReqParamCountry reqParamCountry) {
        String out = "fun8:" + reqParamCountry.getName() + reqParamCountry.getCode() +
                reqParamCountry.getProvinces()[0].getName();
        System.out.println(out);
        return out;
    }
    @RequestMapping("fun9")
    public String fun9(@RequestBody HashMap paramsHashMap) {
        String out = "fun9:" + paramsHashMap.get("name") + paramsHashMap.get("code");
        System.out.println(out);
        return out;
    }
}
