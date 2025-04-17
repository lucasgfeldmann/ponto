package br.com.dnos.Ponto.repository;

import br.com.dnos.Ponto.entity.Record;
import br.com.dnos.Ponto.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecordRepository extends JpaRepository<Record, Long> {
    public List<Record> findByOwner(User user);

    public List<Record> findByOwnerAndEndAtNull(User user);

    public List<Record> findByOwnerAndEndAtNullOrderByStartAtDesc(User user);
}
