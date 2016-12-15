package com.krishagni.catissueplus.core.biospecimen.services;

import com.krishagni.catissueplus.core.biospecimen.events.SpecimenKitDetail;
import com.krishagni.catissueplus.core.common.events.RequestEvent;
import com.krishagni.catissueplus.core.common.events.ResponseEvent;

public interface SpecimenKitService {

    public ResponseEvent<SpecimenKitDetail> getSpecimenKit(RequestEvent<Long> req);

    public ResponseEvent<SpecimenKitDetail> addSpecimenKit(RequestEvent<SpecimenKitDetail> req);

    public ResponseEvent<SpecimenKitDetail> updateSpecimenKit(RequestEvent<SpecimenKitDetail> req);
}
