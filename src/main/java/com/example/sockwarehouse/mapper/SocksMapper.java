package com.example.sockwarehouse.mapper;

import com.example.sockwarehouse.dto.SocksDTO;
import com.example.sockwarehouse.entity.Socks;
import org.springframework.stereotype.Component;

@Component
public class SocksMapper {

    public static SocksDTO fromSocks (Socks socks) {
        SocksDTO socksDTO = new SocksDTO();
        socksDTO.setColor(socks.getColor());
        socksDTO.setCottonPart(socks.getCottonPart());
        socksDTO.setQuantity(socks.getQuantity());
        return socksDTO;
    }
}
