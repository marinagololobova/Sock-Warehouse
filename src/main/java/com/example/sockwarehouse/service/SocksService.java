package com.example.sockwarehouse.service;

import com.example.sockwarehouse.dto.Operation;
import com.example.sockwarehouse.dto.SocksDTO;
import com.example.sockwarehouse.entity.Socks;
import com.example.sockwarehouse.exceptions.SocksNotFoundException;
import com.example.sockwarehouse.mapper.SocksMapper;
import com.example.sockwarehouse.repository.SocksRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class SocksService {

    private final SocksRepository socksRepository;

    public SocksDTO addSocks(SocksDTO socksDTO) {
        if (socksRepository.findSocksByColorAndCottonPart(socksDTO.getColor(), socksDTO.getCottonPart()) == null) {
        Socks socks = new Socks();
        socks.setColor(socksDTO.getColor());
        socks.setCottonPart(socksDTO.getCottonPart());
        socks.setQuantity(socksDTO.getQuantity());
        return SocksMapper.fromSocks(socksRepository.save(socks));
        } else {
            Socks socks = socksRepository.findSocksByColorAndCottonPart(socksDTO.getColor(), socksDTO.getCottonPart());
            int numbers = socksDTO.getQuantity();
            socks.setQuantity(socks.getQuantity() + numbers);
            return SocksMapper.fromSocks(socksRepository.save(socks));
        }
    }

    public SocksDTO issueSocks(SocksDTO socksDTO) {
        Socks socks = socksRepository.findSocksByColorAndCottonPart(socksDTO.getColor(), socksDTO.getCottonPart());
        int numbers = socks.getQuantity();
        if (numbers < socksDTO.getQuantity()) {
            throw new SocksNotFoundException("На складе нет такого количества носков");
        } else {
            socks.setQuantity(numbers - socksDTO.getQuantity());
        }
        return SocksMapper.fromSocks(socksRepository.save(socks));
    }

    public Integer getSocks(String color, Operation operation, Integer cottonPart) {
        List<Socks> socks = new ArrayList<>();
        switch (operation) {
            case equal -> socks = socksRepository.findSocksByColorAndCottonPartEquals(color, cottonPart);
            case lessThan -> socks = socksRepository.findSocksByColorAndCottonPartLessThan(color, cottonPart);
            case moreThan -> socks = socksRepository.findSocksByColorAndCottonPartGreaterThan(color, cottonPart);
        }
        int quantity = 0;
        for (Socks s : socks) {
            quantity += s.getQuantity();
        }
        return quantity;
    }
}
