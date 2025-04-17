package br.com.dnos.Ponto.controller;


import br.com.dnos.Ponto.config.JWTUserData;
import br.com.dnos.Ponto.controller.request.RecordRequest;
import br.com.dnos.Ponto.controller.response.RecordResponse;
import br.com.dnos.Ponto.entity.Record;
import br.com.dnos.Ponto.entity.User;
import br.com.dnos.Ponto.mapper.RecordMapper;
import br.com.dnos.Ponto.mapper.UserMapper;
import br.com.dnos.Ponto.service.RecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(path = "record")
@RequiredArgsConstructor
public class RecordController implements RecordControllerDocs {

    private final RecordService recordService;

    @Override
    @PostMapping
    public RecordResponse createRecord(@RequestBody RecordRequest data) {
        JWTUserData jwtUserData = (JWTUserData) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = UserMapper.toUser(jwtUserData);
        Record savedRecord = recordService.save(RecordMapper.toRecord(data, user));
        return RecordMapper.toRecordResponse(savedRecord);
    }

    @GetMapping
    public List<RecordResponse> getAllRecordFromAUser() {
        JWTUserData jwtUserData = (JWTUserData) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = UserMapper.toUser(jwtUserData);
        return recordService.getAllRecords(user).stream().map(RecordMapper::toRecordResponse).toList();
    }

    @GetMapping("runing")
    public List<RecordResponse> getRuning() {
        JWTUserData jwtUserData = (JWTUserData) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = UserMapper.toUser(jwtUserData);

        return recordService.getAllRecordsRunning(user).stream().map(RecordMapper::toRecordResponse).toList();
    }

    @GetMapping("end")
    public RecordResponse endLastRecord() {
        JWTUserData jwtUserData = (JWTUserData) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = UserMapper.toUser(jwtUserData);

        Record ended = recordService.endRecordRunning(user);

        return RecordMapper.toRecordResponse(ended);
    }

    @GetMapping("start")
    public RecordResponse startRecord() {
        JWTUserData jwtUserData = (JWTUserData) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = UserMapper.toUser(jwtUserData);


        Record data = recordService.save(
                Record.builder()
                        .startAt(LocalDateTime.now())
                        .owner(user)
                        .build()
        );

        return RecordMapper.toRecordResponse(data);
    }


}
