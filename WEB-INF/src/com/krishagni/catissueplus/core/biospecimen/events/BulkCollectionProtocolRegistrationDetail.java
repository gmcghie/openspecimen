package com.krishagni.catissueplus.core.biospecimen.events;

import java.util.List;

public class BulkCollectionProtocolRegistrationDetail {
    private Long cpId;

    private String cpTitle;

    private String cpShortTitle;

    private int noOfRegistrations;

    private List<CollectionProtocolEventDetail> events;

    public Long getCpId() {
        return cpId;
    }

    public void setCpId(Long cpId) {
        this.cpId = cpId;
    }

    public String getCpTitle() {
        return cpTitle;
    }

    public void setCpTitle(String cpTitle) {
        this.cpTitle = cpTitle;
    }

    public String getCpShortTitle() {
        return cpShortTitle;
    }

    public void setCpShortTitle(String cpShortTitle) {
        this.cpShortTitle = cpShortTitle;
    }

    public Integer getNoOfRegistrations() {
        return noOfRegistrations;
    }

    public void setNoOfRegistrations(int noOfRegistrations) {
        this.noOfRegistrations = noOfRegistrations;
    }

    public List<CollectionProtocolEventDetail> getEvents() {
        return events;
    }

    public void setEvents(List<CollectionProtocolEventDetail> events) {
        this.events = events;
    }
}
