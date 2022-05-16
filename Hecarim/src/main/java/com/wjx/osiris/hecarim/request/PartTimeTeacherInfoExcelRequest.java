package com.wjx.osiris.hecarim.request;

import cn.hutool.core.date.DatePattern;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * @author liusha
 * @date 2022/5/13 11:46
 * @mail liusha@wacai.com
 * @description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PartTimeTeacherInfoExcelRequest implements Serializable {

    @ExcelProperty(index = 0)
    @NotNull(message = "花名不能为空")
    private String flowerName;

    @ExcelProperty(index = 1)
    @NotNull(message = "花名拼音不能为空")
    private String flowerNamePinyin;

    @ExcelProperty(index = 2)
    private Integer partTimeType;

    @ExcelProperty(index = 3)
    @NotNull(message = "入职时间不能为空")
    @DateTimeFormat(DatePattern.NORM_DATE_PATTERN)
    private Date entryTime;

    @ExcelProperty(index = 4)
    @NotNull(message = "真实姓名不能为空")
    private String realName;

    @ExcelProperty(index = 5)
    private Integer sex;

    @ExcelProperty(index = 6)
    @DateTimeFormat(DatePattern.NORM_DATE_PATTERN)
    private Date birthDate;

    @ExcelProperty(index = 7)
    private String mobile;

    @ExcelProperty(index = 8)
    private String district;

    @ExcelProperty(index = 9)
    private String fullTimeJob;

    @ExcelProperty(index = 10)
    private String workExperience;

    @ExcelProperty(index = 11)
    private String recommender;

    @ExcelProperty(index = 12)
    private Integer rating;

    @ExcelProperty(index = 13)
    private Integer workStatus;

    @ExcelProperty(index = 14)
    private String remark;

}
