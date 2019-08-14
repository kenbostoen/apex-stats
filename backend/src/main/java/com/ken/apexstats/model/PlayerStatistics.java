package com.ken.apexstats.model;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;

@Getter
public class PlayerStatistics implements Serializable {
    public PlatformInfo platformInfo;
    public List<?> segments;
}
