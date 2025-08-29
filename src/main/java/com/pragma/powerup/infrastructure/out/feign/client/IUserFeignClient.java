package com.pragma.powerup.infrastructure.out.feign.client;

import com.pragma.powerup.domain.model.User;
import com.pragma.powerup.infrastructure.configuration.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service", url = "${user.service.url}", configuration = FeignConfiguration.class)
public interface IUserFeignClient {
    @GetMapping("/user/{id}")
    User validateOwner(@PathVariable("id") Long idPropietario);
}
