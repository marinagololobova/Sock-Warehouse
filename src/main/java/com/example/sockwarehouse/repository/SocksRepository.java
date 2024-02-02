package com.example.sockwarehouse.repository;

import com.example.sockwarehouse.entity.Socks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SocksRepository extends JpaRepository<Socks, Integer> {

    List<Socks> findSocksByColorAndCottonPartGreaterThan(String color, Integer cottonPart);

    List<Socks> findSocksByColorAndCottonPartLessThan(String color, Integer cottonPart);

    List<Socks> findSocksByColorAndCottonPartEquals(String color, Integer cottonPart);

    Socks findSocksByColorAndCottonPart(String color, Integer cottonPart);


}
