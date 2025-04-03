package br.com.dnos.Ponto.repository;

import br.com.dnos.Ponto.entity.Record;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordRepository extends JpaRepository<Record, Long> {
}
