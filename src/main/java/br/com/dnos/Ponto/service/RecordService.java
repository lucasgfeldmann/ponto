package br.com.dnos.Ponto.service;


import br.com.dnos.Ponto.entity.Record;
import br.com.dnos.Ponto.entity.User;
import br.com.dnos.Ponto.repository.RecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RecordService {

    private final RecordRepository recordRepository;

    public Record save(Record data) {
        return recordRepository.save(data);

    }

    public Record update(Long id, Record data) {
        Optional<Record> record = recordRepository.findById(id);
        if (record.isPresent()) {
            data.setId(id);
            recordRepository.save(data);
            return record.get();
        }
        return null;

    }

    public List<Record> getAllRecords(User user) {
        return recordRepository.findByOwner(user);
    }

    public List<Record> getAllRecordsRunning(User user) {
        return recordRepository.findByOwnerAndEndAtNull(user);
    }

    public Record endRecordRunning(User user) {
        List<Record> listRecords = recordRepository.findByOwnerAndEndAtNullOrderByStartAtDesc(user);
        Record record = listRecords.getFirst();
        record.setEndAt(LocalDateTime.now());
        return recordRepository.save(record);
    }


    public void delete(Long id) {
        recordRepository.deleteById(id);
    }


}
