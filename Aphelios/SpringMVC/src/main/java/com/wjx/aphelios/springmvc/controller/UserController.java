package com.wjx.aphelios.springmvc.controller;

import com.wjx.aphelios.springmvc.domain.User;
import com.wjx.aphelios.springmvc.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author WJX
 * @since 2018/4/25 16:02
 */
@Controller
public class UserController {
    @Resource(name = "userService")
    private UserService userService;

    @InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
        //向springmvc内部注入一个自定义的类型转换器
        //参数一：将String转成什么类型的字节码
        //参数二：自定义转换规则
        //true表示该日期字段可以为空
        binder.registerCustomEditor(
                Date.class,
                new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), false)
        );
    }

    @ApiOperation(notes = "查询所有的user", value = "/springmvc/queryUser")
    @RequestMapping("/springmvc/queryUser")
    @ResponseBody
    public List<User> queryUser() {
        List<User> userList = userService.queryUser();
        userList.stream().forEach(e -> System.out.println(e));
        return userList;
    }

    @RequestMapping(value = "/springmvc/insertUser", method = RequestMethod.POST)
    public void insetUser(@RequestBody User user) {
        System.out.println(user);
        userService.insertUser(user);
    }

    @RequestMapping(value = "/springmvc/upload", method = RequestMethod.POST)
    public String upload(MultipartFile file) {
        try {
            String s = UUID.randomUUID().toString();
            //取文件拓展名
            String originalFilename = file.getOriginalFilename();
            String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
            String url = s + "." + extName;
            file.transferTo(new File("E:/upload/" + url));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "index";
    }
}
