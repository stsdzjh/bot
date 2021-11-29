package com.fourany.botserver.mappers;

import com.fourany.botserver.entities.SysBotBaseConfig;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SysBotBaseConfigMapperTest extends TestCase {

    @Autowired
    private SysBotBaseConfigMapper sysBotBaseConfigMapper;

    @Test
    public void testInsert(){
        SysBotBaseConfig entity = new SysBotBaseConfig();
        entity.setPipeline("abc");
        entity.setPolicies("efg");

        sysBotBaseConfigMapper.insert(entity);


    }

}