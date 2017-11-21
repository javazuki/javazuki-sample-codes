package com.javazuki.samples.prg.ui.web;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class PrgSampleForm {

  @NotEmpty @Size(min = 2) private String name;

}
