package com.pelin.boxservice.dto;

import com.pelin.boxservice.model.BaseEntity;

public class BoxDto extends BaseEntity {
    private String weight;
    private String dimensions;

    public BoxDto(){}

    public BoxDto(String weight, String dimensions) {
        this.weight = weight;
        this.dimensions = dimensions;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }
}
