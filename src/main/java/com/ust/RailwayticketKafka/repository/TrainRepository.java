package com.ust.RailwayticketKafka.repository;

import com.ust.RailwayticketKafka.entity.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainRepository extends JpaRepository<Train,Long> {
}
