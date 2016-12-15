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

import com.krishagni.catissueplus.core.biospecimen.events.SpecimenKitDetail;
import com.krishagni.catissueplus.core.biospecimen.services.SpecimenKitService;
import com.krishagni.catissueplus.core.common.events.RequestEvent;
import com.krishagni.catissueplus.core.common.events.ResponseEvent;

@Controller
@RequestMapping("/specimen-kits")
public class SpecimenKitsController {

    @Autowired
    private SpecimenKitService specimenKitSvc;

    @RequestMapping(method = RequestMethod.GET, value="{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public SpecimenKitDetail getContainerType(@PathVariable("id") Long kitId) {
        ResponseEvent<SpecimenKitDetail> resp = specimenKitSvc.getSpecimenKit(getRequest(kitId));
        resp.throwErrorIfUnsuccessful();
        return resp.getPayload();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public SpecimenKitDetail addKit(@RequestBody SpecimenKitDetail detail) {
        ResponseEvent<SpecimenKitDetail> resp = specimenKitSvc.addSpecimenKit(getRequest(detail));
        resp.throwErrorIfUnsuccessful();
        return resp.getPayload();
    }

    @RequestMapping(method = RequestMethod.PUT, value="{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public SpecimenKitDetail updateKit(@PathVariable("id") Long id, @RequestBody SpecimenKitDetail detail) {
        detail.setId(id);
        ResponseEvent<SpecimenKitDetail> resp = specimenKitSvc.updateSpecimenKit(getRequest(detail));
        resp.throwErrorIfUnsuccessful();
        return resp.getPayload();
    }

    private <T> RequestEvent<T> getRequest(T payload) {
        return new RequestEvent<T>(payload);
    }

}
