package com.arete.software.springcloudfeigndemo;

import com.arete.software.springcloudfeigndemo.api.DemoServiceApi;
import com.arete.software.springcloudfeigndemo.config.LocalRibbonClientConfiguration;
import com.arete.software.springcloudfeigndemo.config.SpringCloudFeignDemoConfig;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;
import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
        SpringCloudFeignDemoConfig.class,
//        LocalRibbonClientConfiguration.class // Uncomment this to make the tests pass.
})
@TestPropertySource("classpath:application-test.yml")
@ActiveProfiles("test")
public class DemoServiceTest {
    @Autowired
    DemoServiceApi api;

    @Rule
    public WireMockRule demoServer = new WireMockRule(wireMockConfig().port(8001));

    @Test
    public void happyPath() {
        demoServer.stubFor(get(urlPathEqualTo("/customer"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withBody("wonderful customer")));
        final String customer = api.getCustomer();
        assertEquals(customer, "wonderful customer");
    }
}
