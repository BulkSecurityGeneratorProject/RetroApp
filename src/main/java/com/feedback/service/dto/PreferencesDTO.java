package com.feedback.service.dto;


import com.feedback.domain.enumeration.Units;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the Preferences entity.
 */
public class PreferencesDTO implements Serializable {

    private Long id;

    @NotNull
    @Min(value = 10)
    @Max(value = 21)
    private Integer weeklyGoal;

    @NotNull
    private Units weightUnits;

    private Long userId;

    private String userLogin;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getWeeklyGoal() {
        return weeklyGoal;
    }

    public void setWeeklyGoal(Integer weeklyGoal) {
        this.weeklyGoal = weeklyGoal;
    }

    public Units getWeightUnits() {
        return weightUnits;
    }

    public void setWeightUnits(Units weightUnits) {
        this.weightUnits = weightUnits;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PreferencesDTO preferencesDTO = (PreferencesDTO) o;
        if(preferencesDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), preferencesDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "PreferencesDTO{" +
            "id=" + getId() +
            ", weeklyGoal='" + getWeeklyGoal() + "'" +
            ", weightUnits='" + getWeightUnits() + "'" +
            "}";
    }
}
