package com.example.simpleatm.service;

import com.example.simpleatm.dto.AtmDto;
import java.util.List;

/**
 * Created by vgerris on 29/4/19.
 */
public interface AtmService {
    AtmDto getAtmById(Integer atmId);
    void saveAtm(AtmDto atmDto);
    Float withdrawBills(AtmDto atmDto, Float withdrawal);
    Float depositBills(AtmDto atmDto, Float deposit20, Float deposit50, Float deposit100, Float deposit200, Float deposit500, Float deposit1000);
    List<AtmDto> getAllAtms();
}