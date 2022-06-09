package com.wjx.osiris.morgana.config;

import com.alibaba.csp.sentinel.annotation.aspectj.SentinelResourceAspect;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liusha
 * @date 2022/5/16 14:09
 * @mail liusha@wacai.com
 * @description
 */
@Configuration
public class SentinelConfig {

    @Bean
    public SentinelResourceAspect sentinelResourceAspect() {
        return new SentinelResourceAspect();
    }

    @PostConstruct
    public void initRules() throws Exception {
        FlowRule rule = new FlowRule();
        rule.setResource("home");
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);

        // 每秒调用最大次数为 1 次
        rule.setCount(1);

        List<FlowRule> rules = new ArrayList<>();
        rules.add(rule);

        // 将控制规则载入到 Sentinel
        FlowRuleManager.loadRules(rules);
    }
}
