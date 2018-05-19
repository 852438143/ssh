package com.mule.elearing.action;

import com.mule.elearing.po.Attachment;
import com.mule.elearing.service.AttachmentService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.util.ArrayList;
import java.util.List;

public class AttachmentAction  extends ActionSupport implements ModelDriven{
	private Attachment attachment=new Attachment();
	private AttachmentService attachmentService;
	public Attachment getAttachment() {
		return attachment;
	}
	public void setAttachment(Attachment attachment) {
		this.attachment = attachment;
	}
	public AttachmentService getAttachmentService() {
		return attachmentService;
	}
	public void setAttachmentService(AttachmentService attachmentService) {
		this.attachmentService = attachmentService;
	}
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return attachment;
	}
	
	public String getUrlByCId(){
		List<Attachment> attachments=new ArrayList<Attachment>();
		try {
			attachments=this.attachmentService.getUrlByCId(this.attachment.getCid());
			ActionContext.getContext().put("attachments", attachments);
			return SUCCESS;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ERROR;
	}
}
