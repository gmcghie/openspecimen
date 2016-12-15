package com.krishagni.catissueplus.core.biospecimen.domain.factory;

import com.krishagni.catissueplus.core.biospecimen.domain.SpecimenKit;
import com.krishagni.catissueplus.core.biospecimen.events.SpecimenKitDetail;

public interface SpecimenKitFactory {
    public SpecimenKit createSpecimenKit(SpecimenKitDetail detail);
}
