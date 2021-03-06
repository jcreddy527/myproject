package com.tavant.kershaw.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tavant.kershaw.entity.DocumentType;
import com.tavant.kershaw.helper.RequestData;
import com.tavant.kershaw.service.DocumentTypeManagerService;
import com.tavant.kershaw.vo.DocumentTypeVO;
import com.tavant.kershaw.vo.SectionVO;

@RestController
@RequestMapping(value = "/documentType")
public class DocumentTypeController {

	@Autowired
	private DocumentTypeManagerService documentTypeManagerService;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public DocumentType createDocumentType(@RequestBody DocumentType docType) {
		documentTypeManagerService.createDocumentType(docType);
		return docType;
	}
	
	@ResponseBody
	@RequestMapping(value = "/withFields", method = RequestMethod.GET)
	public List<DocumentTypeVO> getAllDocumentTypes() {
		List<DocumentTypeVO> documentTypeList = documentTypeManagerService.getAllDocumentTypes();
		return documentTypeList;
	}
	
	@ResponseBody
	@RequestMapping(value = "/shallow", method = RequestMethod.GET)
	public List<DocumentTypeVO> getDocumentTypesShallow() {
		List<DocumentTypeVO> documentTypeList = documentTypeManagerService.getDocumentTypesShallow();
		return documentTypeList;
	}
	
	@ResponseBody
	@RequestMapping(value = "/{documentTypeId}/sections", method = RequestMethod.GET)
	public List<SectionVO> getSectionsByDocumentId(@PathVariable("documentTypeId") Integer documentTypeId) {
		 List<SectionVO> documentTypeList = documentTypeManagerService.getSectionsByDocumentId(documentTypeId);
		return documentTypeList;
	}
	
	@RequestMapping(value = "/field", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public void createDocumentWithField(@RequestBody RequestData requestData) {
		documentTypeManagerService.updateDocumentWithField(requestData);
	}
	
	@RequestMapping(value = "/fields/values", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public void createDocumentWithField(@RequestBody List<SectionVO> requestData) {
		System.out.println(requestData);
		documentTypeManagerService.updateSectionFieldsValue(requestData);
	}
}
