package com.wjx.aphelios.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author WJX
 * @since 2018/4/25 14:11
 */
@Controller
public class Demo {
    @RequestMapping("springmvc/demo.action")
    public String SpringDemo() {
        return "index";
    }

    @RequestMapping("springmvc/modelview.action")
    public ModelAndView modelDemo() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/index.jsp");
        return modelAndView;
    }
}
