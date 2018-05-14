package com.arete.software.springcloudfeigndemo.config;

import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ServerList;
import org.springframework.cloud.netflix.ribbon.StaticServerList;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile({"local", "test"})
public class LocalRibbonClientConfiguration {

    @Bean
    public ServerList<Server> ribbonServerList() {
        return new StaticServerList<>(
                new Server("localhost", 8001),
                new Server("localhost", 8000)
        );
    }
}