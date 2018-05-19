package com.mule.elearing.dao;

import com.mule.elearing.po.Attachment;

import java.util.List;

/**
 * Created by 85243 on 2017/4/17.
 */
public interface AttachmentDao {
    public Attachment save();
    public List<Attachment> getUrlByCId(String cid);
}
