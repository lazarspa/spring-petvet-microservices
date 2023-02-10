package com.lazarspa.customer.test.configuration.common;

import com.lazarspa.customer.test.configuration.DatasourceTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.util.Assert;

@SpringBootTest
@ContextConfiguration(classes = { DatasourceTestConfig.class })
@ActiveProfiles("test")
public class PetvetCustomerTest {


    @Test
    public void test(){
        Assert.isTrue(true,"true");
    }

}
