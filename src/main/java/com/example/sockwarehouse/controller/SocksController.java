package com.example.sockwarehouse.controller;

import com.example.sockwarehouse.dto.Operation;
import com.example.sockwarehouse.dto.SocksDTO;
import com.example.sockwarehouse.service.SocksService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/socks")
@RequiredArgsConstructor
public class SocksController {

    private final SocksService socksService;

    @PostMapping("/income")
    public SocksDTO addSocks(@RequestBody SocksDTO socksDTO) {
        return socksService.addSocks(socksDTO);
    }

    @PostMapping("/outcome")
    public SocksDTO issueSocks(@RequestBody SocksDTO socksDTO) {
        return socksService.issueSocks(socksDTO);
    }

    @GetMapping
    public ResponseEntity<Integer> getSocks (@RequestParam(required = false) String color,
                                           @RequestParam Operation operation,
                                           @RequestParam(required = false) Integer cottonPart) {
        return new ResponseEntity<>(socksService.getSocks(color, operation, cottonPart), HttpStatus.OK);
    }
}
