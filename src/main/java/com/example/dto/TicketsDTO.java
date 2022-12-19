package com.example.dto;

import com.example.dto.group.OnCreate;
import com.example.dto.group.OnUpdate;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Builder;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@Builder
@JsonInclude(Include.NON_NULL)
public class TicketsDTO extends RepresentationModel<TicketsDTO> {

    @Min(value = 0, groups = { OnCreate.class, OnUpdate.class })
    private int id;

    @NotNull(groups = { OnCreate.class, OnUpdate.class })
    private UserDTO user;

    @NotNull(groups = { OnCreate.class, OnUpdate.class })
    private TrainDTO train;

    @Min(value = 0, groups = { OnCreate.class, OnUpdate.class })
    private int amountTickets;
}
