package com.example.LTNC_WEB_1.TKB;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TKB {
    private Integer id;
    private List<String> ca1;
    private List<String> ca2;

}
