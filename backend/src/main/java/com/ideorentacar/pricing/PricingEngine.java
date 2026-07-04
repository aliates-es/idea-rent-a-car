package com.ideorentacar.pricing;

public interface PricingEngine {

PriceBreakdown calculate(PricingRequest request);
}
