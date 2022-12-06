package com.example.dto;

import com.example.dto.group.OnCreate;
import com.example.dto.group.OnUpdate;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Builder;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@Builder
@JsonInclude(Include.NON_NULL)
public class UserDTO extends RepresentationModel<UserDTO> {

    @NotBlank(groups = OnUpdate.class)
    private int id;

    @NotBlank(groups = OnCreate.class)
    private String firstName;

    @NotBlank(groups = OnCreate.class)
    private String lastName;

    @NotBlank(groups = { OnCreate.class, OnUpdate.class })
    private String username;

    @NotBlank(groups = { OnCreate.class, OnUpdate.class })
    private String password;

    @NotBlank(groups = OnCreate.class)
    private String address;

    @NotBlank(groups = { OnCreate.class, OnUpdate.class })
    @Email(regexp = "[a-z]*@.*")
    private String email;
}
