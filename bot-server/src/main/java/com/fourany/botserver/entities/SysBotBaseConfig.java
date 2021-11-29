package com.fourany.botserver.entities;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * @Description: TODO
 * @author: zhangjh
 * @date: 2021年11月28日 12:27
 */
@Data
public class SysBotBaseConfig {
    @TableId(type= IdType.ASSIGN_UUID)
    private String id;

    private String pipeline;

    private String policies;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

}
