package com.example.demo.dto.Sugerencia;

import com.example.demo.entities.Sugerencia;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SugerenciaMapper {
    SugerenciaMapper INSTANCE = Mappers.getMapper(SugerenciaMapper.class);

    Sugerencia sugerenciaDtoToSugerencia(SugerenciaDto sugerenciaDto);

    SugerenciaDto sugerenciaToSugerenciaDto(Sugerencia sugerencia);
   /* public static Sugerencia sugerenciaDtoToSugerenciaEntity(SugerenciaDto sugerenciaDto){
        return null;
    }

    public static SugerenciaDto sugerenciaEntityToSugerenciaDto(Sugerencia sugerencias){
        return null;
    }*/
}
