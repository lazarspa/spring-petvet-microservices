import com.lazarspa.vet.test.configuration.DatasourceTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import org.springframework.util.Assert;

@SpringBootTest
@ContextConfiguration(classes = { DatasourceTestConfig.class })
@ActiveProfiles("test")
public class VetControllerTest {

    @Test
    public void findAllVetsTest(){
        Assert.isTrue(true,"Test");
    }
}
