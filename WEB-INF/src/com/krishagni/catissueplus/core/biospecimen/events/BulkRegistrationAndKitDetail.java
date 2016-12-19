package com.krishagni.catissueplus.core.biospecimen.events;

public class BulkRegistrationAndKitDetail {
    private BulkRegistrationsDetail bulkRegDetail;

    private SpecimenKitDetail kitDetail;

    public BulkRegistrationsDetail getBulkRegDetail() {
        return bulkRegDetail;
    }

    public void setBulkRegDetail(BulkRegistrationsDetail bulkRegDetail) {
        this.bulkRegDetail = bulkRegDetail;
    }

    public SpecimenKitDetail getKitDetail() {
        return kitDetail;
    }

    public void setKitDetail(SpecimenKitDetail kitDetail) {
        this.kitDetail = kitDetail;
    }
}
