package com.example.player_springboot.validate;

import com.example.player_springboot.dto.PlayerDTO;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class PlayerValidate implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        PlayerDTO playerDTO = (PlayerDTO) target;

        if (playerDTO.getFullName() == null || playerDTO.getFullName().trim().isEmpty()) {
            errors.rejectValue("fullName", null, "Không được để trống");
        } else if (playerDTO.getFullName().length() < 5 || playerDTO.getFullName().length() > 50) {
            errors.rejectValue("fullName", null, "Tên phải từ 5 đến 50 ký tự");
        }

        if (playerDTO.getExperience() == null || playerDTO.getExperience().trim().isEmpty()) {
            errors.rejectValue("experience", null, "Không được để trống");
        }

        if (playerDTO.getPosition() == null || playerDTO.getPosition().trim().isEmpty()) {
            errors.rejectValue("position", null, "Không được để trống");
        }

        if (playerDTO.getAvatar() == null || playerDTO.getAvatar().trim().isEmpty()) {
            errors.rejectValue("avatar", null, "Không được để trống");
        } else if (!playerDTO.getAvatar().matches("^(https?|ftp)://[^\\s/$.?#].[^\\s]*$")) {
            errors.rejectValue("avatar", null, "Đường dẫn không hợp lệ");
        }

        if (playerDTO.getDayOfBirth() == null || playerDTO.getDayOfBirth().trim().isEmpty()) {
            errors.rejectValue("dayOfBirth", null, "Không được để trống");
        } else {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
            try {
                LocalDate.parse(playerDTO.getDayOfBirth(), formatter);
            } catch (DateTimeParseException e) {
                errors.rejectValue("dayOfBirth", null, "Định dạng ngày sinh phải là dd/MM/yy");
            }
        }

        if (playerDTO.getTeamId() == null) {
            errors.rejectValue("team", null, "Cầu thủ phải thuộc về một đội tuyển");
        }
    }
}
