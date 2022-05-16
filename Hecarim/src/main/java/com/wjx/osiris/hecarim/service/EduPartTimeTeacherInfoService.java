package com.wjx.osiris.hecarim.service;

import com.wjx.osiris.hecarim.dao.EduPartTimeTeacherInfoMapper;
import com.wjx.osiris.hecarim.domain.EduPartTimeTeacherInfo;
import com.wjx.osiris.hecarim.dto.ExcelErrorResultDTO;
import com.wjx.osiris.hecarim.request.PartTimeTeacherInfoExcelRequest;
import com.wjx.osiris.hecarim.utils.OrikaBeanUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.groups.Default;
import java.util.Set;

/**
 * <p>
 * 兼职班主任信息表 服务实现类
 * </p>
 *
 * @author liusha
 * @since 2022-05-13
 */
@Service
public class EduPartTimeTeacherInfoService {

    @Resource
    private EduPartTimeTeacherInfoMapper eduPartTimeTeacherInfoMapper;

    /**
     * 验证器
     */
    private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    public ExcelErrorResultDTO handExcelData(PartTimeTeacherInfoExcelRequest partTimeTeacherInfoExcelRequest) {
        Set<ConstraintViolation<PartTimeTeacherInfoExcelRequest>> validateSet = validator.validate(partTimeTeacherInfoExcelRequest, Default.class);

        if (CollectionUtils.isEmpty(validateSet)) {
            //落库
            EduPartTimeTeacherInfo eduPartTimeTeacherInfo = OrikaBeanUtils.copyBean(partTimeTeacherInfoExcelRequest, EduPartTimeTeacherInfo.class);
            eduPartTimeTeacherInfoMapper.insert(eduPartTimeTeacherInfo);
            return null;
        } else {
            ConstraintViolation<PartTimeTeacherInfoExcelRequest> partTimeTeacherInfoExcelRequestConstraintViolation = validateSet.iterator().next();

            ExcelErrorResultDTO excelErrorResultDTO = ExcelErrorResultDTO.builder()
                    .name(partTimeTeacherInfoExcelRequest.getFlowerName())
                    .errorMessage(partTimeTeacherInfoExcelRequestConstraintViolation.getMessage())
                    .build();

            return excelErrorResultDTO;
        }
    }
}
