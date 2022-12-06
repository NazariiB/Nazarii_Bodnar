package com.example.dto;

import com.example.dto.group.OnCreate;
import com.example.dto.group.OnUpdate;
import lombok.Builder;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import javax.validation.constraints.NotBlank;

@Data
@Builder
public class TicketsDTO extends RepresentationModel<TicketsDTO> {
    @NotBlank(groups = OnUpdate.class)
    private int id;
    @NotBlank(groups = { OnCreate.class, OnUpdate.class })
    private int userId;

    @NotBlank(groups = { OnCreate.class, OnUpdate.class })
    private int trainId;

    @NotBlank(groups = { OnCreate.class, OnUpdate.class })
    private int amountTickets;
}
