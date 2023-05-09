package com.yanglao.sys.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComplaintDTO extends Complaint{
    private List<Complaint> complaintList;
    private  String handlerName;
}
