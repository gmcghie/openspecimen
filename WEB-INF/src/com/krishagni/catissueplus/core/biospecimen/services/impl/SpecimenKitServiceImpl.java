package com.krishagni.catissueplus.core.biospecimen.services.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.krishagni.catissueplus.core.biospecimen.domain.CollectionProtocolRegistration;
import com.krishagni.catissueplus.core.biospecimen.domain.Specimen;
import com.krishagni.catissueplus.core.biospecimen.domain.SpecimenKit;
import com.krishagni.catissueplus.core.biospecimen.domain.Visit;
import com.krishagni.catissueplus.core.biospecimen.domain.factory.SpecimenKitFactory;
import com.krishagni.catissueplus.core.biospecimen.domain.factory.impl.SpecimenKitErrorCode;
import com.krishagni.catissueplus.core.biospecimen.events.BulkRegistrationAndKitDetail;
import com.krishagni.catissueplus.core.biospecimen.events.CprsAndSpecimenKitDetail;
import com.krishagni.catissueplus.core.biospecimen.events.SpecimenKitDetail;
import com.krishagni.catissueplus.core.biospecimen.repository.DaoFactory;
import com.krishagni.catissueplus.core.biospecimen.services.CollectionProtocolRegistrationService;
import com.krishagni.catissueplus.core.biospecimen.services.SpecimenKitService;
import com.krishagni.catissueplus.core.common.PlusTransactional;
import com.krishagni.catissueplus.core.common.errors.OpenSpecimenException;
import com.krishagni.catissueplus.core.common.events.RequestEvent;
import com.krishagni.catissueplus.core.common.events.ResponseEvent;

public class SpecimenKitServiceImpl implements SpecimenKitService {

    private DaoFactory daoFactory;

    private SpecimenKitFactory specimenKitFactory;

    private CollectionProtocolRegistrationService cprSvc;

    public void setDaoFactory(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    public void setSpecimenKitFactory(SpecimenKitFactory specimenKitFactory) {
        this.specimenKitFactory = specimenKitFactory;
    }

    public void setCprSvc(CollectionProtocolRegistrationService cprSvc) {
        this.cprSvc = cprSvc;
    }

    @Override
    @PlusTransactional
    public ResponseEvent<SpecimenKitDetail> getSpecimenKit(RequestEvent<Long> req) {
        try {
            return ResponseEvent.response(SpecimenKitDetail.from(getKit(req.getPayload())));
        } catch (OpenSpecimenException ose) {
            return ResponseEvent.error(ose);
        } catch (Exception e) {
            return ResponseEvent.serverError(e);
        }
    }

    @Override
    @PlusTransactional
    public ResponseEvent<CprsAndSpecimenKitDetail> createSpecimenKit(RequestEvent<BulkRegistrationAndKitDetail> req) {
        try {
            BulkRegistrationAndKitDetail detail = req.getPayload();
            List<CollectionProtocolRegistration> cprs = cprSvc.bulkRegistration(detail.getBulkRegDetail());
            SpecimenKit kit = createSpecimenKit(detail.getKitDetail(), cprs);
            return ResponseEvent.response(CprsAndSpecimenKitDetail.from(cprs, kit));
        } catch (OpenSpecimenException ose) {
            return ResponseEvent.error(ose);
        } catch (Exception e) {
            return ResponseEvent.serverError(e);
        }
    }

    @Override
    @PlusTransactional
    public ResponseEvent<SpecimenKitDetail> updateSpecimenKit(RequestEvent<SpecimenKitDetail> req) {
        try {
            SpecimenKitDetail detail = req.getPayload();
            SpecimenKit existing = getKit(detail.getId());

            SpecimenKit kit = specimenKitFactory.createSpecimenKit(detail);
            existing.update(kit);

            daoFactory.getSpecimenKitDao().saveOrUpdate(existing);
            return ResponseEvent.response(SpecimenKitDetail.from(existing));
        } catch (OpenSpecimenException ose) {
            return ResponseEvent.error(ose);
        } catch (Exception e) {
            return ResponseEvent.serverError(e);
        }
    }

    private SpecimenKit getKit(Long kitId) {
        SpecimenKit kit = daoFactory.getSpecimenKitDao().getById(kitId);

        if (kit == null) {
            throw OpenSpecimenException.userError(SpecimenKitErrorCode.NOT_FOUND, kitId);
        }

        return kit;
    }


    private SpecimenKit createSpecimenKit(SpecimenKitDetail detail, List<CollectionProtocolRegistration> cprs) {
        if (detail == null) {
            return null;
        }

        SpecimenKit kit = specimenKitFactory.createSpecimenKit(detail);
        Set<Specimen> specimens = new HashSet<>();
        for (CollectionProtocolRegistration cpr: cprs) {
            for (Visit visit: cpr.getVisits()) {
                specimens.addAll(visit.getSpecimens());
            }
        }

        kit.setSpecimens(specimens);
        daoFactory.getSpecimenKitDao().saveOrUpdate(kit);
        return kit;
    }
}
