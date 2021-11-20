package ru.otus.microservice.architecture.metrics.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.microservice.architecture.metrics.entity.MetricEntity;
import ru.otus.microservice.architecture.metrics.repository.MetricRepository;

@Service
public class DbMetricService implements MetricService {
    private final MetricRepository metricRepository;

    @Autowired
    public DbMetricService(MetricRepository metricRepository) {
        this.metricRepository = metricRepository;
    }

    @Override
    @Transactional
    public Long create(String name, String value) {
        MetricEntity metricEntity = new MetricEntity(null, name, value);
        metricRepository.save(metricEntity);
        return metricEntity.getId();
    }

    @Override
    @Transactional
    public String read(Long id) {
        MetricEntity metricEntity = metricRepository.findById(id).orElseThrow(RuntimeException::new);
        return String.format("%s:%s", metricEntity.getName(), metricEntity.getValue());
    }
}