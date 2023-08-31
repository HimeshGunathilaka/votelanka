package com.techgenie.demo.dto.domain;

import com.techgenie.demo.dto.model.Candidate;
import com.techgenie.demo.dto.model.User;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Data
public class Area {
    private long id;
    private String name;
    private long no;
    private List<Candidate> candidates;
    private List<User> voters;
}
