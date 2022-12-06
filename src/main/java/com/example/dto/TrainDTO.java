package com.example.dto;

import com.example.dto.group.OnCreate;
import com.example.dto.group.OnUpdate;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TrainDTO extends RepresentationModel<TrainDTO> {

    @NotBlank(groups = OnUpdate.class)
    private int id;

    @NotBlank(groups = { OnCreate.class, OnUpdate.class })
    private String first;

    @NotBlank(groups = { OnCreate.class, OnUpdate.class })
    private String departureTime;

    @NotBlank(groups = { OnCreate.class, OnUpdate.class })
    private String finalStation;

    @NotBlank(groups = { OnCreate.class, OnUpdate.class })
    private String arrivalTime;

    @NotBlank(groups = { OnCreate.class, OnUpdate.class })
    private int freeSeats;

    @NotBlank(groups = { OnCreate.class, OnUpdate.class })
    private int price;
}
