package ru.otus.microservice.architecture.metrics.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.otus.microservice.architecture.metrics.entity.MetricEntity;

@Repository
public interface MetricRepository extends CrudRepository<MetricEntity, Long> {
}