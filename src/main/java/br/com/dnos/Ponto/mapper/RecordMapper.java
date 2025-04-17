package br.com.dnos.Ponto.mapper;

import br.com.dnos.Ponto.controller.request.RecordRequest;
import br.com.dnos.Ponto.controller.response.RecordResponse;
import br.com.dnos.Ponto.entity.Record;
import br.com.dnos.Ponto.entity.User;

public class RecordMapper {
    public static Record toRecord(RecordRequest recordRequest, User user) {
        return Record.builder()
                .owner(user)
                .startAt(recordRequest.startAt())
                .endAt(recordRequest.endAt())
                .build();
    }

    public static RecordResponse toRecordResponse(Record record) {
        return RecordResponse.builder()
                .id(record.getId())
                .startAt(record.getStartAt())
                .endAt(record.getEndAt())
                .build();
    }
}
