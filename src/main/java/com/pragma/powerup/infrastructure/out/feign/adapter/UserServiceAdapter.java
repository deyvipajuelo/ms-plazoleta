package com.pragma.powerup.infrastructure.out.feign.adapter;

import com.pragma.powerup.domain.spi.IUserServicePort;
import com.pragma.powerup.domain.model.User;
import com.pragma.powerup.infrastructure.out.feign.client.IUserFeignClient;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserServiceAdapter implements IUserServicePort {
    private final IUserFeignClient userFeignClient;

    @Override
    public boolean isOwner(Long idPropietario) {
        User user = userFeignClient.validateOwner(idPropietario);
        return user.getRol().getNombre().equalsIgnoreCase("PROPIETARIO");
    }
}
