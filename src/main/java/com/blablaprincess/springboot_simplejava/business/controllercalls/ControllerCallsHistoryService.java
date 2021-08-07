package com.blablaprincess.springboot_simplejava.business.controllercalls;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ControllerCallsHistoryService implements ControllerCallsHistory {

    private final ControllerCallDescriptionsRepository repository;

    @Override
    @Async("telegramBotNotifierServiceTaskExecutor")
    public void saveCall(ControllerCallDescriptionEntity call) {
        repository.save(call);
    }

    @Override
    public List<ControllerCallDescriptionEntity> getCalls() {
        return repository.findAll();
    }

    @Override
    public List<ControllerCallDescriptionEntity> getCalls(Date from, Date to) {
        return repository.findByTimestampIsBetween(from, to);
    }

    @Override
    public List<ControllerCallDescriptionEntity> getLastCalls(int amount) {
        Page<ControllerCallDescriptionEntity> page = repository.findAll(Pageable.ofSize(amount));
        return page.toList();
    }

    @Override
    public List<ControllerCallDescriptionEntity> getLastCalls(Date from, Date to, int amount) {
        Page<ControllerCallDescriptionEntity> page = repository.findByTimestampIsBetween(from, to, Pageable.ofSize(amount));
        return page.toList();
    }

}