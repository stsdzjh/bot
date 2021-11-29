package com.fourany.botserver.services.impls;

import com.fourany.botserver.services.RasaService;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RasaServiceImplTest extends TestCase {
    @Autowired
    private RasaServiceImpl rasaService;


    @Test
    public void testModelTrain() {
        rasaService.modelTrain();

    }
}