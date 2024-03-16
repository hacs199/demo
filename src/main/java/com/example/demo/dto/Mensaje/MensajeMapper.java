package com.example.demo.dto.Mensaje;

import com.example.demo.entities.Mensaje;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MensajeMapper {

    MensajeMapper INSTANCE = Mappers.getMapper(MensajeMapper.class);

    Mensaje mensajeDtoToMensaje(MensajeDto mensajeDto);

    MensajeDto mensajeToMensajeDto(Mensaje mensaje);

    /*public static Mensaje mensajeDtoMensajeEntity(MensajeDto mensajeDto){
        return null;
    }

    public static MensajeDto mensajeEntityToMensajeDto(Mensaje mensaje){
        return null;
    }*/
}
