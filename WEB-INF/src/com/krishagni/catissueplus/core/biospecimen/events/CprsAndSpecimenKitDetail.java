package com.krishagni.catissueplus.core.biospecimen.events;

import java.util.List;

import com.krishagni.catissueplus.core.biospecimen.domain.CollectionProtocolRegistration;
import com.krishagni.catissueplus.core.biospecimen.domain.SpecimenKit;

public class CprsAndSpecimenKitDetail {

    private List<CollectionProtocolRegistrationDetail> cprs;

    private SpecimenKitDetail kitDetail;


    public List<CollectionProtocolRegistrationDetail> getCprs() {
        return cprs;
    }

    public void setCprs(List<CollectionProtocolRegistrationDetail> cprs) {
        this.cprs = cprs;
    }

    public SpecimenKitDetail getKitDetail() {
        return kitDetail;
    }

    public void setKitDetail(SpecimenKitDetail kitDetail) {
        this.kitDetail = kitDetail;
    }

    public static CprsAndSpecimenKitDetail from(List<CollectionProtocolRegistration> cprs, SpecimenKit kit) {
        CprsAndSpecimenKitDetail detail = new CprsAndSpecimenKitDetail();
        detail.setCprs(CollectionProtocolRegistrationDetail.from(cprs, false));
        detail.setKitDetail(SpecimenKitDetail.from(kit));
        return detail;
    }
}
