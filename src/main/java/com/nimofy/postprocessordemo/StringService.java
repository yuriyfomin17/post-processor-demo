package com.nimofy.postprocessordemo;

import com.nimofy.postprocessordemo.annotations.Trimmed;
import org.springframework.stereotype.Service;

@Service
public class StringService {
    public String processString(@Trimmed String str) {
        return str;
    }
}
