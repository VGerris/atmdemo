package com.example.simpleatm.converter;

import com.example.simpleatm.dto.AtmDto;
import com.example.simpleatm.entity.Atm;

/**
 * Created by vgerris on 29/4/19.
 */
public class AtmConverter {

    public static Atm dtoToEntity(AtmDto atmDto) {
        Atm Atm = new Atm(atmDto.getAtmName(), null, null, null,null,null,null);
                            Atm.setAtmId(atmDto.getAtmId());
                            Atm.setStashOf20(atmDto.getStashOf20());
                            Atm.setStashOf50(atmDto.getStashOf50());
                            Atm.setStashOf100(atmDto.getStashOf100());
                            Atm.setStashOf200(atmDto.getStashOf200());
                            Atm.setStashOf500(atmDto.getStashOf500());
                            Atm.setStashOf1000(atmDto.getStashOf1000());
        return Atm;
    }

    public static AtmDto entityToDto(Atm atm) {
        return new AtmDto(  atm.getAtmId(),
                            atm.getAtmName(),
                            atm.getStashOf20(),
                            atm.getStashOf50(),
                            atm.getStashOf100(),
                            atm.getStashOf200(),
                            atm.getStashOf500(),
                            atm.getStashOf1000());
    }

}