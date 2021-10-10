package com.project.homework3.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


/**
 * @author Habib
 * @on 10/6/21 - 7:32 AM
 */
//DB kullanmadığımız sürçe @Entity gibi yani   javax.persistence DB bağlanacak diye biz onu istemiyoruz
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StartProcess extends Measurements {


    private String name;
    private String description;
    private String baseUnit;

    public List<Measurements> measurements;
    public List<String> availableTags;
}
