package com.scl.cms.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.scl.cms.domain.Attach;
import com.scl.cms.mapper.AttachMapper;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.xml.bind.attachment.AttachmentMarshaller;
import java.util.List;

/**
 * Created by shengchenglong on 17/4/6.
 */
@Service(protocol = "dubbo")
@Transactional
public class AttachServiceImpl implements AttachService {

    @Resource
    private AttachMapper attachMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return attachMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Attach record) {
        return attachMapper.insert(record);
    }

    @Override
    public int insertSelective(Attach record) {
        return attachMapper.insertSelective(record);
    }

    @Override
    public Attach selectByPrimaryKey(String id) {
        return attachMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Attach record) {
        return attachMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Attach record) {
        return attachMapper.updateByPrimaryKey(record);
    }

    /**
     * 根据hostId来查询附件
     * @param hostId
     * @return
     */
    @Override
    public List<Attach> listByHostId(String hostId) {
        return attachMapper.listByHostId(hostId);
    }
}
