package com.mule.elearing.dao.impl;

import com.mule.elearing.po.Attachment;
import com.mule.elearing.dao.AttachmentDao;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 85243 on 2017/4/17.
 */
@Transactional
public class AttachmentDaoImpl implements AttachmentDao{
    private SessionFactory sf ;
    @Override
    public Attachment save() {
        Attachment attachment = new Attachment();
        attachment.setAttachmentId("aaaa");
        attachment.setAttachmentName("bbb");
        sf.getCurrentSession().save(attachment);
        return null;
    }
    public void setSf(SessionFactory sf) {
        this.sf = sf;
    }
	@Override
	public List<Attachment> getUrlByCId(String cid) {
		// TODO Auto-generated method stub
		String hql="from Attachment a where a.cid='"+cid+"'";
		List<Attachment> attachments=new ArrayList<Attachment>();
		try {
			attachments=sf.getCurrentSession().createQuery(hql).list() ;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return attachments;
	}
}
