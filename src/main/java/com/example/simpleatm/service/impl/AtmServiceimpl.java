package com.example.simpleatm.service.impl;

import com.example.simpleatm.converter.AtmConverter;
import com.example.simpleatm.dto.AtmDto;
import com.example.simpleatm.repository.AtmRepository;
import com.example.simpleatm.service.AtmService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by vgerrs on 29/4/19.
 */
@Service
public class AtmServiceimpl implements AtmService {
    @Autowired
    AtmRepository atmRepository;

    @Override
    public AtmDto getAtmById(Integer atmId) {
        return AtmConverter.entityToDto(atmRepository.getOne(atmId));
    }

    @Override
    public void saveAtm(AtmDto atmDto) {
        atmRepository.save(AtmConverter.dtoToEntity(atmDto));
    }

    @Override
    public Float withdrawBills(AtmDto atmDto, Float withdrawal) {
        //atmDto.getTransactionDtos(); // TODO if moving to transactions
        atmDto.removeFromStashes(withdrawal);
        saveAtm(atmDto);
        return withdrawal;
    }

    @Override
    public Float depositBills(AtmDto atmDto, Float deposit20, Float deposit50, Float deposit100, Float deposit200, Float deposit500, Float deposit1000) {
        //atmDto.getTransactionDtos(); TODO if moving to transaction
        atmDto.depositBills(deposit20.intValue(),deposit50.intValue(),deposit100.intValue(),deposit200.intValue(),deposit500.intValue(),deposit1000.intValue());
        System.out.println("depositBills params: 20: " + deposit20.intValue() + " 50: " +deposit50.intValue() + " 100: " +deposit100.intValue() + " 200: " +deposit200.intValue() + " 500: " + deposit500.intValue() + " 1000: " + deposit1000.intValue());
        saveAtm(atmDto);
        return deposit20; // to test
    }

    @Override
    public List<AtmDto> getAllAtms() {
        return atmRepository.findAll().stream().map(AtmConverter::entityToDto).collect(Collectors.toList());
    }
}
