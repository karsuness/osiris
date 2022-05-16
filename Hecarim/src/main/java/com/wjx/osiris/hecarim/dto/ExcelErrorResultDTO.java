package com.wjx.osiris.hecarim.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author liusha
 * @date 2022/5/14 13:09
 * @mail liusha@wacai.com
 * @description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExcelErrorResultDTO implements Serializable {

    private String name;

    private String errorMessage;
}
