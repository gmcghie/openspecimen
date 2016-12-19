package com.krishagni.catissueplus.core.biospecimen.services;

import com.krishagni.catissueplus.core.biospecimen.events.SpecimenKitDetail;
import com.krishagni.catissueplus.core.common.events.RequestEvent;
import com.krishagni.catissueplus.core.common.events.ResponseEvent;

public interface SpecimenKitService {

    ResponseEvent<SpecimenKitDetail> getSpecimenKit(RequestEvent<Long> req);

    ResponseEvent<SpecimenKitDetail> createSpecimenKit(RequestEvent<SpecimenKitDetail> req);

    ResponseEvent<SpecimenKitDetail> updateSpecimenKit(RequestEvent<SpecimenKitDetail> req);
}
