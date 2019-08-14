package com.ken.apexstats.model;

import java.io.Serializable;

import lombok.Getter;

@Getter
public class PlatformInfo implements Serializable {
    public String platformSlug;
    public String platformUserId;
    public String platformUserHandle;
    public String platformUserIdentifier;
    public String avatarUrl;
}
