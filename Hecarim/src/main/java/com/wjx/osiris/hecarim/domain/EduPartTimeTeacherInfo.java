package com.wjx.osiris.hecarim.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 兼职班主任信息表
 * </p>
 *
 * @author liusha
 * @since 2022-05-13
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName("edu_part_time_teacher_info")
@ApiModel(value = "EduPartTimeTeacherInfo对象", description = "兼职班主任信息表")
public class EduPartTimeTeacherInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "花名")
    @TableField("flower_name")
    private String flowerName;

    @ApiModelProperty(value = "花名拼音")
    @TableField("flower_name_pinyin")
    private String flowerNamePinyin;

    @ApiModelProperty(value = "真名")
    @TableField("real_name")
    private String realName;

    @ApiModelProperty(value = "性别 0 男 1女")
    @TableField("sex")
    private Integer sex;

    @ApiModelProperty(value = "手机号")
    @TableField("mobile")
    private String mobile;

    @ApiModelProperty(value = "入职时间")
    @TableField("entry_time")
    private Date entryTime;

    @ApiModelProperty(value = "出生日期")
    @TableField("birth_date")
    private Date birthDate;

    @ApiModelProperty(value = "所在区域")
    @TableField("district")
    private String district;

    @ApiModelProperty(value = "带班经验")
    @TableField("work_experience")
    private String workExperience;

    @ApiModelProperty(value = "评级 0金牌 1银 2铜")
    @TableField("rating")
    private Integer rating;

    @ApiModelProperty(value = "推荐人")
    @TableField("recommender")
    private String recommender;

    @ApiModelProperty(value = "合作状态 0 正常 1保持关注 2停期 3停止合作")
    @TableField("work_status")
    private Integer workStatus;

    @ApiModelProperty(value = "全职职业")
    @TableField("full_time_job")
    private String fullTimeJob;

    @ApiModelProperty(value = "兼职类型 1 基金班 2 股票班")
    @TableField("part_time_type")
    private Integer partTimeType;

    @ApiModelProperty(value = "当前带班班级id")
    @TableField("current_bind_grade_id")
    private Long currentBindGradeId;

    @ApiModelProperty(value = "绑定班主任id")
    @TableField("bind_teacher_id")
    private Long bindTeacherId;

    @ApiModelProperty(value = "带班次数")
    @TableField("with_class_count")
    private Integer withClassCount;

    @ApiModelProperty(value = "合格率")
    @TableField("pass_rate")
    private Double passRate;

    @ApiModelProperty(value = "备注")
    @TableField("remark")
    private String remark;

    @ApiModelProperty(value = "创建时间")
    @TableField("created_time")
    private Date createdTime;

    @ApiModelProperty(value = "更新时间")
    @TableField("updated_time")
    private Date updatedTime;

    @ApiModelProperty(value = "创建人")
    @TableField("created_by")
    private String createdBy;

    @ApiModelProperty(value = "更新人")
    @TableField("updated_by")
    private String updatedBy;
}
