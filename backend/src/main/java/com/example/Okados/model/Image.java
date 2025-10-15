package com.example.Okados.model;

public class Image {
    private String publicId;
    private String secureUrl;

    public Image() {}
    public Image(String publicId, String secureUrl) { this.publicId = publicId; this.secureUrl = secureUrl; }
    public String getPublicId() { return publicId; }
    public void setPublicId(String publicId) { this.publicId = publicId; }
    public String getSecureUrl() { return secureUrl; }
    public void setSecureUrl(String secureUrl) { this.secureUrl = secureUrl; }
}
