package com.uros.rosix.rule;

import com.uros.rosix.core.ROSIXException;
import java.time.Instant;
import java.util.List;

/**
 * 规则引擎接口
 * 提供基于规则的编程功能
 */
public interface RuleEngine {
    
    /**
     * 定义规则集
     * 
     * @param name 规则集名称
     * @param rules 规则列表
     * @throws ROSIXException 如果定义失败
     */
    void defineRuleSet(String name, List<Rule> rules) throws ROSIXException;
    
    /**
     * 启用规则集
     * 
     * @param name 规则集名称
     * @throws ROSIXException 如果启用失败
     */
    void enableRuleSet(String name) throws ROSIXException;
    
    /**
     * 禁用规则集
     * 
     * @param name 规则集名称
     * @throws ROSIXException 如果禁用失败
     */
    void disableRuleSet(String name) throws ROSIXException;
    
    /**
     * 删除规则集
     * 
     * @param name 规则集名称
     * @throws ROSIXException 如果删除失败
     */
    void deleteRuleSet(String name) throws ROSIXException;
    
    /**
     * 执行规则
     * 
     * @param context 规则执行上下文
     * @return 执行结果
     * @throws ROSIXException 如果执行失败
     */
    RuleResult executeRules(RuleContext context) throws ROSIXException;
    
    /**
     * 执行特定规则
     * 
     * @param ruleSetName 规则集名称
     * @param ruleIndex 规则索引
     * @param context 规则执行上下文
     * @return 执行结果
     * @throws ROSIXException 如果执行失败
     */
    RuleResult executeSpecificRule(String ruleSetName, int ruleIndex, RuleContext context) throws ROSIXException;
    
    /**
     * 获取规则执行统计信息
     * 
     * @param ruleSetName 规则集名称
     * @return 统计信息
     * @throws ROSIXException 如果获取失败
     */
    RuleStats getRuleStats(String ruleSetName) throws ROSIXException;
    
    /**
     * 获取规则执行历史
     * 
     * @param ruleSetName 规则集名称
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @param maxResults 最大结果数量
     * @return 执行结果列表
     * @throws ROSIXException 如果获取失败
     */
    List<RuleResult> getRuleHistory(String ruleSetName, Instant startTime, 
                                   Instant endTime, int maxResults) throws ROSIXException;
    
    /**
     * 验证规则条件
     * 
     * @param condition 条件表达式
     * @throws ROSIXException 如果验证失败
     */
    void validateCondition(String condition) throws ROSIXException;
    
    /**
     * 验证规则动作
     * 
     * @param action 动作表达式
     * @throws ROSIXException 如果验证失败
     */
    void validateAction(String action) throws ROSIXException;
    
    /**
     * 测试规则
     * 
     * @param rule 要测试的规则
     * @param testData 测试数据
     * @return 测试结果
     * @throws ROSIXException 如果测试失败
     */
    RuleResult testRule(Rule rule, String testData) throws ROSIXException;
    
    /**
     * 保存规则集到文件
     * 
     * @param ruleSetName 规则集名称
     * @param filename 文件名
     * @throws ROSIXException 如果保存失败
     */
    void saveRuleSet(String ruleSetName, String filename) throws ROSIXException;
    
    /**
     * 从文件加载规则集
     * 
     * @param filename 文件名
     * @return 规则集名称
     * @throws ROSIXException 如果加载失败
     */
    String loadRuleSet(String filename) throws ROSIXException;
    
    /**
     * 导出规则集为 JSON
     * 
     * @param ruleSetName 规则集名称
     * @return JSON 字符串
     * @throws ROSIXException 如果导出失败
     */
    String exportRuleSetToJson(String ruleSetName) throws ROSIXException;
    
    /**
     * 从 JSON 导入规则集
     * 
     * @param jsonInput JSON 字符串
     * @return 规则集名称
     * @throws ROSIXException 如果导入失败
     */
    String importRuleSetFromJson(String jsonInput) throws ROSIXException;
    
    /**
     * 检查规则冲突
     * 
     * @param ruleSetName 规则集名称
     * @param maxConflicts 最大冲突数量
     * @return 冲突描述列表
     * @throws ROSIXException 如果检查失败
     */
    List<String> checkRuleConflicts(String ruleSetName, int maxConflicts) throws ROSIXException;
    
    /**
     * 列出所有可用的规则集
     * 
     * @param maxRuleSets 最大规则集数量
     * @return 规则集名称列表
     * @throws ROSIXException 如果列出失败
     */
    List<String> listRuleSets(int maxRuleSets) throws ROSIXException;
}
