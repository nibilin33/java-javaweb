package com.fase.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fase.iservice.Iaskpermisson;
import com.fase.mapper.AskpermissionMapper;
import com.fase.po.Askpermission;
@Service
@Transactional
public class FaskPermission implements Iaskpermisson {
    @Resource
    private AskpermissionMapper askdao;
	@Override
	public void insertP(Askpermission ask) {
		// TODO 自动生成的方法存根
         askdao.insertSelective(ask);
	}

	@Override
	public void updateP(Askpermission ask) {
		// TODO 自动生成的方法存根
         askdao.updateByPrimaryKeySelective(ask);
	}

	@Override
	public List<Askpermission> selectall(String fuid) {
		// TODO 自动生成的方法存根
		
		return askdao.selectall(fuid);
	}

}
