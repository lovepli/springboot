package com.goat.controller;

import com.goat.chapter001.bean2.Pet;
import com.goat.chapter001.bean2.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/stu")
public class ListController {

    // http://localhost:8265/stu/test2
    @RequestMapping("/test2")
    public String findList(Model model) {

        Student stu = new Student();
        stu.setAge(11);
        stu.setName("stuName");

        // 爱好
        String[] haha = new String[]{"111","222","333"};
        stu.setHobbies(haha);

        // 地址
        Map<String,Object> location = new HashMap<>(16);
        location.put("pro","辽宁");
        location.put("city","抚顺");
        location.put("area","清原");
        stu.setLocation(location);

        Pet pet = new Pet();
        pet.setAge(22);
        pet.setNickName("petName");
        stu.setPet(pet);

        // 技能
        List<String> skills = new ArrayList<>(16);
        skills.add("星期一");
        skills.add("星期二");
        skills.add("星期三");
        stu.setSkill(skills);
        model.addAttribute("student",stu);
        return "test/list";
    }


}
