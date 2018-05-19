package com.mule.elearing.service;

import java.util.ArrayList;
import java.util.List;

import com.mule.elearing.dao.AttachmentDao;
import com.mule.elearing.po.Attachment;

public class AttachmentService {
	private AttachmentDao attachmentDao;

	public AttachmentDao getAttachmentDao() {
		return attachmentDao;
	}

	public void setAttachmentDao(AttachmentDao attachmentDao) {
		this.attachmentDao = attachmentDao;
	}
	
	public List<Attachment> getUrlByCId(String cid){
		List<Attachment> attachments=new ArrayList<Attachment>();
		try {
			attachments=this.attachmentDao.getUrlByCId(cid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return attachments;
	}
}
