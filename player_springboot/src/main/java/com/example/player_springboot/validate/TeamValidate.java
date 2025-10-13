package com.example.player_springboot.validate;

import com.example.player_springboot.entity.Team;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class TeamValidate implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Team team = (Team) target;

        if (team.getName() == null || team.getName().trim().isEmpty()) {
            errors.rejectValue("name", null, "Không được để trống");
        } else if (team.getName().length() < 5 || team.getName().length() > 50) {
            errors.rejectValue("name", null, "Tên phải từ 5 đến 50 kí tự");
        }

        if (team.getCountry() == null || team.getCountry().trim().isEmpty()) {
            errors.rejectValue("country", null, "Không được để trống");
        }

        if (team.getCoach() == null || team.getCoach().trim().isEmpty()) {
            errors.rejectValue("coach", null, "Không được để trống");
        }
    }
}
