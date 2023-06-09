package com.pelin.boxservice.mapper;

import com.pelin.boxservice.dto.BoxDto;
import com.pelin.boxservice.model.Box;
import com.pelin.boxservice.model.request.CreateBoxRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BoxMapper {

    BoxMapper BOX_MAPPER = Mappers.getMapper(BoxMapper.class);

    BoxDto convertToBoxDto(Box box);
    Box createBox(CreateBoxRequest createBoxRequest);

}
