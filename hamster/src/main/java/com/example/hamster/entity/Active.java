package com.example.hamster.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Active {

    private Integer active_id;

    @NonNull
    private Integer hamster_id;

    @NonNull
    private Integer lap_count;

    @NonNull
    private Date insert_date_time;

    @NonNull
    private String insert_user;
}
