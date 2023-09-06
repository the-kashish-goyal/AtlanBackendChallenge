package com.atlan.backend.entity;

import jakarta.persistence.Entity;
import jdk.jfr.Enabled;
import lombok.Data;

@Data
public class isValid {
    private boolean NameValid;
    private boolean EmailValid;
    private boolean IncomeValid;
    private boolean PhoneValid;


}
