package com.example.kmupbl3;

import com.example.kmupbl3.tool.TimeTool;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdSearchCond {
    private String category;
    private String title;
    private Timestamp timestamp;

    public AdSearchCond(String category, String title, Long timestamp) {
        this.category = category;
        this.title = title;
        this.timestamp = TimeTool.convertLongToTimestamp(timestamp);
    }
}
