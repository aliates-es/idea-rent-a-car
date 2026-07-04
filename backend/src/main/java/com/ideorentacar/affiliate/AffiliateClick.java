package com.ideorentacar.affiliate;

import java.time.Instant;

public class AffiliateClick {

private String id;
private String affiliateId;
private Instant clickedAt;
private String utmSource;
private String utmCampaign;
private String landingPage;

public String getId() {
  return id;
}

public void setId(String id) {
  this.id = id;
}

public String getAffiliateId() {
  return affiliateId;
}

public void setAffiliateId(String affiliateId) {
  this.affiliateId = affiliateId;
}

public Instant getClickedAt() {
  return clickedAt;
}

public void setClickedAt(Instant clickedAt) {
  this.clickedAt = clickedAt;
}

public String getUtmSource() {
  return utmSource;
}

public void setUtmSource(String utmSource) {
  this.utmSource = utmSource;
}

public String getUtmCampaign() {
  return utmCampaign;
}

public void setUtmCampaign(String utmCampaign) {
  this.utmCampaign = utmCampaign;
}

public String getLandingPage() {
  return landingPage;
}

public void setLandingPage(String landingPage) {
  this.landingPage = landingPage;
}
}
