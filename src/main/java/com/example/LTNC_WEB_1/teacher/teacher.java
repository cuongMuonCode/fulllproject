package com.example.LTNC_WEB_1.teacher;
import com.example.LTNC_WEB_1.information.information;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class teacher {
    private information in4_gv;
    private List<String> idClass;
    private List<String> diploma;

}
