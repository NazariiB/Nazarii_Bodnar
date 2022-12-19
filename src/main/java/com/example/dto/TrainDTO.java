package com.example.dto;

import com.example.dto.group.OnCreate;
import com.example.dto.group.OnUpdate;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Builder;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@JsonInclude(Include.NON_NULL)
public class TrainDTO extends RepresentationModel<TrainDTO> {

    @Min(value = 0, groups = OnUpdate.class)
    private int id;

    @NotBlank(groups = { OnCreate.class, OnUpdate.class })
    private String first;

    @NotBlank(groups = { OnCreate.class, OnUpdate.class })
    private String departureTime;

    @NotBlank(groups = { OnCreate.class, OnUpdate.class })
    private String finalStation;

    @NotBlank(groups = { OnCreate.class, OnUpdate.class })
    private String arrivalTime;

    @Min(value = 0, groups = OnCreate.class)
    private Integer freeSeats;

    @Min(value = 0, groups = OnCreate.class)
    private Integer price;

    @NotNull(groups = { OnCreate.class, OnUpdate.class })
    private List<TicketsDTO> tickets;
}
