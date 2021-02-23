package com.wjx.brand.main;

import com.wjx.brand.domain.WxInfoDTO;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liusha
 * @date 2021/2/22 15:07
 * @mail liusha@wacai.com
 * @description
 */
public class XmlTest {
    public static void main(String[] args) throws DocumentException {
        String xmlStr = "<sysmsg type=\"sysmsgtemplate\">\n" +
                "\t<sysmsgtemplate>\n" +
                "\t\t<content_template type=\"tmpl_type_profile\">\n" +
                "\t\t\t<plain><![CDATA[]]></plain>\n" +
                "\t\t\t<template><![CDATA[\" $adder$\"通过扫描\"$from$\"分享的二维码加入群聊]]></template>\n" +
                "\t\t\t<link_list>\n" +
                "\t\t\t\t<link name=\"adder\" type=\"link_profile\">\n" +
                "\t\t\t\t\t<memberlist>\n" +
                "\t\t\t\t\t\t<member>\n" +
                "\t\t\t\t\t\t\t<username><![CDATA[wxid_qgep6pu979p22]]></username>\n" +
                "\t\t\t\t\t\t\t<nickname><![CDATA[静儿]]></nickname>\n" +
                "\t\t\t\t\t\t</member>\n" +
                "\t\t\t\t\t</memberlist>\n" +
                "\t\t\t\t</link>\n" +
                "\t\t\t\t<link name=\"from\" type=\"link_profile\">\n" +
                "\t\t\t\t\t<memberlist>\n" +
                "\t\t\t\t\t\t<member>\n" +
                "\t\t\t\t\t\t\t<username><![CDATA[wxid_girb4v6sqnug22]]></username>\n" +
                "\t\t\t\t\t\t\t<nickname><![CDATA[0222印象]]></nickname>\n" +
                "\t\t\t\t\t\t</member>\n" +
                "\t\t\t\t\t</memberlist>\n" +
                "\t\t\t\t</link>\n" +
                "\t\t\t</link_list>\n" +
                "\t\t</content_template>\n" +
                "\t</sysmsgtemplate>\n" +
                "</sysmsg>";

        Document document = DocumentHelper.parseText(xmlStr);
        Element rootElement = document.getRootElement();
        Element sysmsgtemplate = rootElement.element("sysmsgtemplate");
        Element content_template = sysmsgtemplate.element("content_template");
        Element template = content_template.element("template");
        Element link_list = content_template.element("link_list");
        List<Element> linkList = link_list.elements("link");

        Map<String, WxInfoDTO> wxInfoMap = new HashMap<>(2);

        for (Element linkElement : linkList) {
            String name = linkElement.attribute("name").getData().toString();
            Element memberListElement = linkElement.element("memberlist");
            Element memberElement = memberListElement.element("member");
            Element usernameElement = memberElement.element("username");
            Element nicknameElement = memberElement.element("nickname");
            String wxId = usernameElement.getData().toString();
            String nickName = nicknameElement.getData().toString();
            WxInfoDTO wxInfoDTO = WxInfoDTO.builder()
                    .wxId(wxId)
                    .nickName(nickName)
                    .build();
            wxInfoMap.put(name, wxInfoDTO);
        }

        String value = String.valueOf(template.getData());

        WxInfoDTO adder = wxInfoMap.get("adder");
        WxInfoDTO from = wxInfoMap.get("from");

        String replace = value.replace("\" $adder$\"", adder.getNickName()).replace("\"$from$\"", from.getNickName());
        System.out.println(replace);

    }
}
