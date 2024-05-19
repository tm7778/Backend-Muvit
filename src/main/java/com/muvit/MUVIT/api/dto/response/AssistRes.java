package com.muvit.MUVIT.api.dto.response;

import com.muvit.MUVIT.util.enums.DNITypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AssistRes {
    private String id;
    private String name;
    private String lastName;
    private DNITypeEnum DNI_type;
    private String DNI;
    private AssistToDriverResp Driver;
}
