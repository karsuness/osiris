package com.wjx.aphelios.oauth2.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.wjx.aphelios.oauth2.domain.User;
import com.wjx.aphelios.oauth2.service.UserService;
import com.wjx.aphelios.oauth2.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author WJX
 * @since 2018/5/23 15:40
 */

/**
 * 用户登陆controller
 */
@Controller
@RequestMapping("/com/wjx/oauth")
public class SSOController {
    @Autowired
    private UserService userService;

    @Value("#{configProperties['baidu.authUrl']}")
    private String baiduAuthUrl;

    @Value("#{configProperties['baidu.tokenUrl']}")
    private String baiduTokenUrl;

    @Value("#{configProperties['baidu.userInfoApi']}")
    private String baiduUserInfoApi;

    /**
     * 跳转到用户登陆页面
     *
     * @return
     */
    @RequestMapping("/login")
    public void gotoLoginPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("baiduAuthUrl", baiduAuthUrl);
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
    }

    @RequestMapping(value = "/userLogin", method = RequestMethod.POST)
    public void userLogin(User loginUser, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = userService.checkLogin(loginUser);
        if (user == null || !user.getAccount().equals(loginUser.getAccount()) || !MD5Utils.encrypt(loginUser.getPasswd()).equals(user.getPasswd())) {
            request.setAttribute("errMsg", "用户名或密码错误");
            request.setAttribute("account", loginUser.getAccount());
            request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
        } else {
            request.getSession().setAttribute("loginUser", user);
            response.sendRedirect("user_page");
        }
    }

    @RequestMapping("/user_page")
    public void loginSuccess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("loginUser") == null) {
            response.sendRedirect("login");
        } else {
            request.getRequestDispatcher("/WEB-INF/jsp/user.jsp").forward(request, response);
        }
    }

    @RequestMapping("/register")
    public String gotoRegister() {
        return "register";
    }

    @RequestMapping(value = "/userRegister", method = RequestMethod.POST)
    public String userRegister(@RequestBody User userRegister) {
        User user = new User();
        user.setAccount(userRegister.getAccount());
        user.setName(userRegister.getName());
        user.setPasswd(MD5Utils.encrypt(userRegister.getPasswd()));
        boolean registerSuccess = userService.register(user);
        if (registerSuccess) {
            return "login";
        }
        return "register";
    }

    @RequestMapping("/third_login/*")
    public String thirdLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String plat = getPlatName(request);
        String code = request.getParameter("code");
        Map<String, String> params = new HashMap<>();
        params.put("code", code);
        String tokenUrl = templateHandle(baiduTokenUrl, params);
        String s = httpGet(tokenUrl);
        Map<String, Object> stringObjectMap = JSON.parseObject(s, new TypeReference<Map<String, Object>>() {
        });
        String access_token = (String) stringObjectMap.get("access_token");
        params.put("access_token", access_token);
        String userInfoApi = templateHandle(baiduUserInfoApi, params);
        String s1 = httpGet(userInfoApi);
        return "auth_success";
    }


    /**
     * 解析uri获取当前平台名
     */
    private String getPlatName(HttpServletRequest request) {
        String uri = request.getRequestURI();
        return uri.substring(uri.lastIndexOf("/") + 1);
    }

    /**
     * 替换字符
     *
     * @param template
     * @param params
     * @return
     */
    private String templateHandle(String template, Map<String, String> params) {
        // 示例:
        // template =
        // "http://test.com/auth?client_id=${cid}&redirect_uri=${ruri}&auth_type=code";
        // regex = ${(.+?)}，匹配${cid}, ${ruri},匹配后group(0)为${cid}，group(1)为cid

        // 执行匹配操作
        Pattern regex = Pattern.compile("\\$\\{(.+?)\\}");
        Matcher matcher = regex.matcher(template);

        StringBuffer sb = new StringBuffer(); // 用来缓存替换后结果
        while (matcher.find()) { // 从字符串开头查找每个匹配项
            String key = matcher.group(1); // 找到每个匹配项后，从匹配值中取出要替换的变量名，如cid
            String replaceVal = params.get(key); // 根据变量名到map中查找要替换的值，如cid的真实值

            if (replaceVal == null) {
                // 未在参数map中找到替换值则不替换此参数，如初次处理tokenUrl时，code变量不需要替换
                continue;
            } else {
                // 用指定值替换匹配部分，如：将${cid}替换成真实cid值xxxx，并将替换后结果缓存入sb，匹配项前面的字符原样存入
                matcher.appendReplacement(sb, replaceVal);
            }
        }
        // 最后一个匹配项并替换完成后，sb中已存入到最后匹配项位置的所有替换结果
        // 最后匹配项以后的字符还没有加入，通过以下操作，将剩余字符加入，完成完整替换过程
        matcher.appendTail(sb);
        return sb.toString();
    }

    // 发起http get类型请求获取返回结果
    private static String httpGet(String urlstr) throws IOException {
        URL url = new URL(urlstr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.connect();
        InputStream is = conn.getInputStream();

        byte[] buff = new byte[is.available()];
        is.read(buff);
        String ret = new String(buff, "utf-8");

        is.close();
        conn.disconnect();

        return ret;
    }
}
