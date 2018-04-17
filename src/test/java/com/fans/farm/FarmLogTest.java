package com.fans.farm;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: Ike.Fan
 * @date: 2018/4/4.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FarmLogTest {
    private final Logger mLogger = LoggerFactory.getLogger(FarmLogTest.class);


    @Test
    public void FarmLogTest1(){
        mLogger.debug("debug...");
        mLogger.info("info...");
        mLogger.error("error...");
    }

}
