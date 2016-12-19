package com.krishagni.catissueplus.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.krishagni.catissueplus.core.biospecimen.events.BulkRegistrationAndKitDetail;
import com.krishagni.catissueplus.core.biospecimen.events.CprsAndSpecimenKitDetail;
import com.krishagni.catissueplus.core.biospecimen.events.SpecimenKitDetail;
import com.krishagni.catissueplus.core.biospecimen.services.SpecimenKitService;
import com.krishagni.catissueplus.core.common.events.RequestEvent;
import com.krishagni.catissueplus.core.common.events.ResponseEvent;

@Controller
@RequestMapping("/specimen-kits")
public class SpecimenKitsController {

    @Autowired
    private SpecimenKitService kitSvc;

    @RequestMapping(method = RequestMethod.GET, value="{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public SpecimenKitDetail getSpecimenKit(@PathVariable("id") Long kitId) {
        ResponseEvent<SpecimenKitDetail> resp = kitSvc.getSpecimenKit(getRequest(kitId));
        resp.throwErrorIfUnsuccessful();
        return resp.getPayload();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public CprsAndSpecimenKitDetail createSpecimenKit(@RequestBody BulkRegistrationAndKitDetail detail) {
        ResponseEvent<CprsAndSpecimenKitDetail> resp = kitSvc.createSpecimenKit(getRequest(detail));
        resp.throwErrorIfUnsuccessful();
        return resp.getPayload();
    }

    @RequestMapping(method = RequestMethod.PUT, value="{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public SpecimenKitDetail updateSpecimenKit(@PathVariable("id") Long id, @RequestBody SpecimenKitDetail detail)  {
        detail.setId(id);
        ResponseEvent<SpecimenKitDetail> resp = kitSvc.updateSpecimenKit(getRequest(detail));
        resp.throwErrorIfUnsuccessful();
        return resp.getPayload();
    }

    private <T> RequestEvent<T> getRequest(T payload) {
        return new RequestEvent<T>(payload);
    }

}
