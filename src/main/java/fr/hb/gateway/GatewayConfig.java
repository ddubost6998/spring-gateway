package fr.hb.gateway;

import org.springframework.cloud.gateway.server.mvc.filter.LoadBalancerFilterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

@Configuration
public class GatewayConfig {

    @Bean
    public RouterFunction<ServerResponse> getRoute() {
        return GatewayRouterFunctions.route("api_route")
            .GET("/sec/**", HandlerFunctions.http())
            .filter(LoadBalancerFilterFunctions.lb("SECURITY"))
            .build();
    }

}
